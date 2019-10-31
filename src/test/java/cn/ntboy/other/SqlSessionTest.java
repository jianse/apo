package cn.ntboy.other;

import cn.ntboy.model.Types;
import cn.ntboy.repository.TypesMapper;
import cn.ntboy.util.SqlSessionProxy;
import cn.ntboy.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SqlSessionTest {

    @Test
    public void test(){
//        SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
//        TypesMapper mapper = session.getMapper(TypesMapper.class);
//        session.close();
//        SqlSession newSession = SqlSessionUtil.getSqlSessionFactory().openSession();
//        Types types = mapper.selectByPrimaryKey(1);
//        System.out.println(types);

        final SqlSession[] sessions = {null,null};
        final SqlSession[] asessions = {null,null};

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sessions[0] = SqlSessionUtil.getSqlSessionFactory().openSession();
                asessions[0] = ((SqlSessionProxy)sessions[0]).getSqlSession();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sessions[1] = SqlSessionUtil.getSqlSessionFactory().openSession();

                asessions[1] = ((SqlSessionProxy)sessions[1]).getSqlSession();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull(sessions[0]);
        assertNotNull(sessions[1]);

        assertNotEquals(asessions[0],asessions[1]);

    }

    @Test
    @Ignore
    public void concurrentTest(){

        //
        final SqlSession[] sessions = {null,null,null,null};

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession();
                SqlSessionProxy proxy = (SqlSessionProxy) session;
                sessions[1] = proxy.getSqlSession();

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
