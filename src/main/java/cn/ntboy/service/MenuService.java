package cn.ntboy.service;

import cn.ntboy.model.Menus;
import cn.ntboy.model.combination.MenusAndTypes;
import cn.ntboy.model.vo.PageVO;
import com.github.pagehelper.Page;

public interface MenuService {

    ServiceResultState<PageVO<Menus>> getAllMenus(PageVO page);

    /**
     * 查询menu和type数据 并分页
     * @param page 分页信息
     * @return 查询到的数据
     */
    ServiceResultState<PageVO<MenusAndTypes>> getAllMenusWithType(PageVO page);

    ServiceResultState deleteById(Integer id);

    ServiceResultState<Menus> getById(Integer id);

    ServiceResultState<Menus> updateMenuById(Integer id, Menus newMenu);

    ServiceResultState<Menus> newMenu(Menus newMenu);
}
