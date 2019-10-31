package cn.ntboy.util;

import org.apache.ibatis.session.*;

import java.sql.Connection;

/**
 * mybatis SqlSessionFactory 代理类
 */
public class SqlSessionFactoryProxy implements SqlSessionFactory {
    private SqlSessionFactory originFactory = null;

    private SqlSessionFactoryProxy(SqlSessionFactory sessionFactory) {
        originFactory = sessionFactory;
    }

    public static SqlSessionFactory proxy(SqlSessionFactory sessionFactory) {
        return new SqlSessionFactoryProxy(sessionFactory);
    }

    //实现 SqlSessionFactory接口并拦截openSession方法返回SqlSessionProxy


    @Override
    public SqlSession openSession() {
        return SqlSessionProxy.proxy(originFactory.openSession());
    }

    @Override
    public SqlSession openSession(boolean autoCommit) {
        return SqlSessionProxy.proxy(originFactory.openSession());
    }

    @Override
    public SqlSession openSession(Connection connection) {
        return SqlSessionProxy.proxy(originFactory.openSession(connection));
    }

    @Override
    public SqlSession openSession(TransactionIsolationLevel level) {
        return SqlSessionProxy.proxy(originFactory.openSession(level));
    }

    @Override
    public SqlSession openSession(ExecutorType execType) {
        return SqlSessionProxy.proxy(originFactory.openSession(execType));
    }

    @Override
    public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
        return SqlSessionProxy.proxy(originFactory.openSession(execType, autoCommit));
    }

    @Override
    public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
        return SqlSessionProxy.proxy(originFactory.openSession(execType, level));
    }

    @Override
    public SqlSession openSession(ExecutorType execType, Connection connection) {
        return SqlSessionProxy.proxy(originFactory.openSession(execType, connection));
    }

    @Override
    public Configuration getConfiguration() {
        return originFactory.getConfiguration();
    }
}
