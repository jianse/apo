package cn.ntboy.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SqlSessionUtilTest {

    @Test
    public void getSqlSessionFactory() {
        SqlSessionFactory factory = SqlSessionUtil.getSqlSessionFactory();
        SqlSession session = factory.openSession();
        List<String> tables = session.selectList("show tables");
        System.out.println(tables);

    }
}