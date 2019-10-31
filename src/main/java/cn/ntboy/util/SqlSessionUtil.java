package cn.ntboy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSessionFactory = SqlSessionFactoryProxy.proxy(sessionFactory);
//            sqlSessionFactory = (SqlSessionFactory)Proxy.newProxyInstance(sessionFactory.getClass().getClassLoader(), sessionFactory.getClass().getInterfaces(), new InvocationHandler() {
//                @Override
//                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////                    System.out.println(method.getName());
//                    Object ret = method.invoke(sessionFactory, args);
//
//                    if ("openSession".equals(method.getName())){
//                        Object session = ret;
//                        ret = SqlSessionInvocationHandler.newSqlSessionProxy(session);
//                    }
//                    return ret;
//                }
//            });
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }


}
