package cn.ntboy.service;

import cn.ntboy.model.Menus;
import cn.ntboy.model.vo.PageVO;
import com.github.pagehelper.Page;

public interface MenuService {

    ServiceResultState<PageVO<Menus>> getAllMenus(PageVO page);

    ServiceResultState deleteById(Integer id);

    ServiceResultState<Menus> getById(Integer id);

    ServiceResultState<Menus> updateMenuById(Integer id, Menus newMenu);

    ServiceResultState<Menus> newMenu(Menus newMenu);
}
