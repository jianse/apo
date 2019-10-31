package cn.ntboy.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SqlSessionInvocationHandler implements InvocationHandler {

    private static SqlSessionInvocationHandler instance = null;

    private SqlSessionInvocationHandler() {

    }

    public static SqlSessionInvocationHandler getInstance() {
        if (instance == null)
            instance = new SqlSessionInvocationHandler();
        return instance;
    }

    private ThreadLocal<Object> originSqlSessionTreadLocal = new ThreadLocal<>();

    public static Object newSqlSessionProxy(Object target){
        SqlSessionInvocationHandler instance = getInstance();
        instance.originSqlSessionTreadLocal.set(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                instance);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(originSqlSessionTreadLocal.get(),args);
    }
}
