package cn.ntboy.util;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

@Slf4j
@ToString
public class SqlSessionProxy implements SqlSession {

    private static SqlSessionProxy instance = null;

    public SqlSession getSqlSession(){
        return sqlSessionThreadLocal.get();
    }

    private ThreadLocal<SqlSession> sqlSessionThreadLocal = new ThreadLocal<>();

    private SqlSessionProxy() {

    }

    public static SqlSession proxy(SqlSession session){
        if (instance == null) {
            instance = new SqlSessionProxy();
        }
        log.debug("new session {}",session);
        instance.sqlSessionThreadLocal.set(session);
        return instance;
    }

    @Override
    public <T> T selectOne(String statement) {
        return sqlSessionThreadLocal.get().selectOne(statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return sqlSessionThreadLocal.get().selectOne(statement,parameter);
    }

    @Override
    public <E> List<E> selectList(String statement) {
        return sqlSessionThreadLocal.get().selectList(statement);
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) {
        return sqlSessionThreadLocal.get().selectList(statement, parameter);
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
        return sqlSessionThreadLocal.get().selectList(statement,parameter,rowBounds);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
        return sqlSessionThreadLocal.get().selectMap(statement,mapKey);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
        return sqlSessionThreadLocal.get().selectMap(statement,parameter, mapKey);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
        return sqlSessionThreadLocal.get().selectMap(statement, parameter, mapKey, rowBounds);
    }

    @Override
    public <T> Cursor<T> selectCursor(String statement) {
        return sqlSessionThreadLocal.get().selectCursor(statement);
    }

    @Override
    public <T> Cursor<T> selectCursor(String statement, Object parameter) {
        return sqlSessionThreadLocal.get().selectCursor(statement, parameter);
    }

    @Override
    public <T> Cursor<T> selectCursor(String statement, Object parameter, RowBounds rowBounds) {
        return sqlSessionThreadLocal.get().selectCursor(statement, parameter, rowBounds);
    }

    @Override
    public void select(String statement, Object parameter, ResultHandler handler) {
        sqlSessionThreadLocal.get().select(statement, parameter, handler);
    }

    @Override
    public void select(String statement, ResultHandler handler) {
        sqlSessionThreadLocal.get().select(statement, handler);
    }

    @Override
    public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
        sqlSessionThreadLocal.get().select(statement, parameter, rowBounds, handler);
    }

    @Override
    public int insert(String statement) {
        return sqlSessionThreadLocal.get().insert(statement);
    }

    @Override
    public int insert(String statement, Object parameter) {
        return sqlSessionThreadLocal.get().insert(statement, parameter);
    }

    @Override
    public int update(String statement) {
        return sqlSessionThreadLocal.get().update(statement);
    }

    @Override
    public int update(String statement, Object parameter) {
        return sqlSessionThreadLocal.get().update(statement, parameter);
    }

    @Override
    public int delete(String statement) {
        return sqlSessionThreadLocal.get().delete(statement);
    }

    @Override
    public int delete(String statement, Object parameter) {
        return sqlSessionThreadLocal.get().delete(statement, parameter);
    }

    @Override
    public void commit() {
        sqlSessionThreadLocal.get().commit();
    }

    @Override
    public void commit(boolean force) {
        sqlSessionThreadLocal.get().commit(force);
    }

    @Override
    public void rollback() {
        sqlSessionThreadLocal.get().rollback();
    }

    @Override
    public void rollback(boolean force) {
        sqlSessionThreadLocal.get().rollback(force);
    }

    @Override
    public List<BatchResult> flushStatements() {
        return sqlSessionThreadLocal.get().flushStatements();
    }


    /**
     * close session and remove thread local
     */
    @Override
    public void close() {
        log.debug("close session {}",sqlSessionThreadLocal.get());
        sqlSessionThreadLocal.get().close();
        sqlSessionThreadLocal.remove();
    }

    @Override
    public void clearCache() {
        sqlSessionThreadLocal.get().clearCache();
    }

    @Override
    public Configuration getConfiguration() {
        return sqlSessionThreadLocal.get().getConfiguration();
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return sqlSessionThreadLocal.get().getMapper(type);
    }

    @Override
    public Connection getConnection() {
        return sqlSessionThreadLocal.get().getConnection();
    }
}
