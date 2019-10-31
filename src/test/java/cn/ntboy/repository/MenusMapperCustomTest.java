package cn.ntboy.repository;

import cn.ntboy.model.Menus;
import cn.ntboy.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenusMapperCustomTest {

    @Test
    public void insertAndSelectKey() {
        try(SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();){
            MenusMapperCustom mapper = session.getMapper(MenusMapperCustom.class);
            Menus menus = new Menus();
            menus.setName("1234");
            menus.setBrief("好吃就完了!");
            menus.setBurden("各种食材.");
            menus.setPrice("25");
            menus.setPrice1("20");
            menus.setSums("0");
            menus.setSums1("0");
            menus.setTypeid("1");
            menus.setImgpath("../.*");
            int result = mapper.insertAndSelectKey(menus);
            System.out.println(result);
            System.out.println(menus);

        }
    }
}