package cn.ntboy.repository;

import cn.ntboy.model.Menus;
import cn.ntboy.model.combination.MenusAndTypes;

import java.util.List;

public interface MenusMapperCustom {

    /**
     * 新建Menus记录 并将主键设置到传入值上
     * @param menus 要新建的记录
     * @return 受影响的行数
     */
    int insertAndSelectKey(Menus menus);

    /**
     * 多表查询Menu和Type
     * @return Menu和Type的列表
     */
    List<MenusAndTypes> selectAllMenusAndTypes();
}
