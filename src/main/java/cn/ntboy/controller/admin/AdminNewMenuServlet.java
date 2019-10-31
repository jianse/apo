package cn.ntboy.controller.admin;

import cn.ntboy.model.Menus;
import cn.ntboy.model.Types;
import cn.ntboy.service.MenuService;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.service.TypeService;
import cn.ntboy.util.FileUtils;
import cn.ntboy.util.ServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@MultipartConfig
@Slf4j
@WebServlet(name = "AdminNewMenuServlet",urlPatterns = "/admin/menus_add.jsp",initParams = {
        @WebInitParam(name = "uploadFileDir",value = "E://images",description = "上传文件的存储路径")
})
public class AdminNewMenuServlet extends HttpServlet {

    private MenuService menuService = ServiceFactory.getInstance().getService(MenuService.class);
    private TypeService typeService = ServiceFactory.getInstance().getService(TypeService.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取multipart中的图片
        Part img = request.getPart("img");
        log.debug("file name : {}",img.getSubmittedFileName());
        // 使用uuid生成新的图片名
        UUID uuid = UUID.randomUUID();
        String filename = FileUtils.renameFile(img.getSubmittedFileName(),uuid.toString());

        // 指定文件的存储路径
        String appRelativePath = "/img/"+filename;

        // 通过web应用的相对路径找到文件系统的绝对路径
        String realPath = getServletContext().getRealPath(appRelativePath);
        log.debug("write to : {}",realPath);

        // 写入文件
        img.write(realPath);

        // 解析其余的表单信息
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.debug("parameter map {}",parameterMap);
        Menus menus = new Menus();
        try {
            BeanUtils.populate(menus,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("populate error",e);
        }
        log.debug("new menus {}",menus);

        // 设置新生成的文件路径
        menus.setImgpath(appRelativePath);

        // 新建
        // todo : 判断新建是否成功
        menuService.newMenu(menus);

        // 回主页
        response.sendRedirect(request.getContextPath()+"/admin/menus.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceResultState<List<Types>> allTypes = typeService.getAllTypes();
        request.setAttribute("types",allTypes.getPayload());
        request.getRequestDispatcher("/WEB-INF/admin/menus_add.jsp").forward(request,response);

    }
}
