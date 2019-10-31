package cn.ntboy.util;

import cn.ntboy.util.tx.Service;
import cn.ntboy.util.tx.TransactionHandler;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ServiceFactory {

    private static ServiceFactory instance = null;

    public static ServiceFactory getInstance() {
        if (instance == null)
            instance = new ServiceFactory();
        return instance;
    }

    @Getter
    @Setter
    private String servicePackage = "cn.ntboy.service.impl";

    private Map<String, Class> serviceMap = new HashMap<>();

    private Map<Class,Object> cachedServiceInstance = new HashMap<>();

    public ServiceFactory() {
        scanAndBuildServiceMap();
    }

    public void scanAndBuildServiceMap() {
        Set<Class<?>> classes = ServiceFactoryUtil.getClasses(servicePackage, false);
        classes.stream().filter(item -> item.isAnnotationPresent(Service.class)).forEach((item) -> {
            String value = item.getAnnotation(Service.class).value();
            if ("".equals(value)) {
                value = item.getSimpleName();
            }

            if (serviceMap.containsKey(value)) {
                throw new ServiceFactoryException("service was registered multi-times : " + value);
            }
            serviceMap.put(value, item);
        });
    }

    public <T> T getService(Class<T> service) {
        for (Class item : serviceMap.values()) {
            if (service.isAssignableFrom(item)) {
                return buildService(item);
            }

        }
        throw new ServiceFactoryException("no service find under package : "+servicePackage+" for "+service.getSimpleName());
    }

    public <T> T getService(String name) {
        if (!serviceMap.containsKey(name)) {
            throw new ServiceFactoryException("no such service name=" + name);
        }

        return buildService(serviceMap.get(name));
    }

    private <T> T buildService(Class serviceClass) {
        try {
            // first looking from cache
            if (cachedServiceInstance.containsKey(serviceClass)) {
                return (T)cachedServiceInstance.get(serviceClass);
            }

            // no cached create new one and add to cache
            Object o = Proxy.newProxyInstance(serviceClass.getClassLoader(), serviceClass.getInterfaces(), new TransactionHandler(serviceClass.getConstructor().newInstance()));
            cachedServiceInstance.put(serviceClass,o);
            return (T) o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }


}
