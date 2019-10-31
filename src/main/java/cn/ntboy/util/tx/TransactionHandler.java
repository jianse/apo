package cn.ntboy.util.tx;

import cn.ntboy.util.InjectMapper;
import cn.ntboy.util.SqlSessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * jdk动态代理类, 代理Service实现类, 处理注入和事务
 * @author qiang
 * @version 0.0.2
 */
@Slf4j
public class TransactionHandler implements InvocationHandler {

    private Object target =null;
    private Map<Method,Class<?>> injectMap = new HashMap<>();

    public TransactionHandler(Object target) {
        this.target = target;
        Method[] methods = target.getClass().getMethods();
        for (Method method : methods) {
            // todo: one param only
            if (method.isAnnotationPresent(InjectMapper.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                injectMap.put(method,parameterTypes[0]);
            }
        }
    }

    @Override
    public synchronized Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret =null;

        // if there is nothing to inject
        // so that is no need for transaction control
        if (injectMap.isEmpty()){
            // invoke directly
            ret = method.invoke(target,args);
            return ret;
        }

        try(SqlSession session = SqlSessionUtil.getSqlSessionFactory().openSession(false)){
            // set mapper values
            injectMap.forEach((k,v)->{
                try {
                    k.invoke(target,session.getMapper(v));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    log.error("could not inject mapper.",e);
//                    e.printStackTrace();
                }
            });
            try {
                ret = method.invoke(target,args);

                if (method.isAnnotationPresent(Transactional.class)) {
                    session.commit(true);
                }else {
                    session.commit();
                }
            }catch (Exception any){
                session.rollback();
                log.error("rollback for exception",any);
            }

        }
        return ret;
    }

}
