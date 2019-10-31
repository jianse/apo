package cn.ntboy.repository;

import cn.ntboy.model.Menus;
import cn.ntboy.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenusMapperTest {

    @Test
    public void insert() {
        try(SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();){
            MenusMapper mapper = session.getMapper(MenusMapper.class);
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
            int result = mapper.insert(menus);
            System.out.println(result);

        }


    }
}