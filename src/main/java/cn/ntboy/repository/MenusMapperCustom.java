package cn.ntboy.repository;

import cn.ntboy.model.Menus;

public interface MenusMapperCustom {

    /**
     * 新建Menus记录 并将主键设置到传入值上
     * @param menus 要新建的记录
     * @return 受影响的行数
     */
    int insertAndSelectKey(Menus menus);
}
