package cn.ntboy.controller;

import cn.ntboy.service.FileService;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.util.ServiceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@WebServlet(name = "ImageServlet",urlPatterns = "/images/*")
public class ImageServlet extends HttpServlet {
    
    private FileService fileService = ServiceFactory.getInstance().getService(FileService.class);
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();

        int i = servletPath.lastIndexOf('/');
        String pathParam = servletPath.substring(i+1);

        log.debug("path {}",pathParam);

        ServiceResultState<File> result = fileService.getFile(pathParam);

        if (result.getStateCode()==200) {
            File file = result.getPayload();

            Path path = file.toPath();
            response.setContentType(Files.probeContentType(path));
            ServletOutputStream stream = response.getOutputStream();

            stream.write(Files.readAllBytes(path));
            return;
        }
        response.sendError(404);
    }
}
