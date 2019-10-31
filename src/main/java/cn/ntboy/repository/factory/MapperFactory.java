package cn.ntboy.repository.factory;

import cn.ntboy.model.Admin;
import cn.ntboy.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class MapperFactory {
    public static<T> T getMapper(Class<T> mapper){
        SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
        return session.getMapper(mapper);

    }
}
