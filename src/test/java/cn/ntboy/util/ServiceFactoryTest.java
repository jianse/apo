package cn.ntboy.util;

import cn.ntboy.model.Admin;
import cn.ntboy.service.AdminService;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.service.impl.AdminServiceImpl;
import cn.ntboy.util.tx.Service;
import org.junit.Before;
import org.junit.Test;

import java.lang.invoke.VarHandle;
import java.util.Set;
import java.util.regex.Pattern;

public class ServiceFactoryTest {

    @Test
    public void getClasses() {
        Set<Class<?>> classes = ServiceFactoryUtil.getClasses("org.apache.commons.dbcp2", false);
        System.out.println(classes);
    }

    @Test
    public void regexTest(){
        String src = "org/apache/commons/dbcp2/ConnectionFactory.class";
        String regex = "org/apache/commons/dbcp2(/[\\w$]*)\\.class";
        System.out.println(Pattern.matches(regex, src));
    }

    @Test
    public void classTest(){
        Class adminService = AdminServiceImpl.class;
        System.out.println(AdminService.class.isAssignableFrom(adminService));
    }

    AdminService service = null;

    @Before
    public void setUp() throws Exception {
        ServiceFactory factory = new ServiceFactory();
        service = factory.getService(AdminService.class);
    }

    @Test
    public void getService() {
        ServiceFactory factory = new ServiceFactory();
        service = factory.getService(AdminService.class);
        Admin admin = new Admin();
        admin.setName("root");
        admin.setPwd("123");
        ServiceResultState login = service.login(admin);
        System.out.println(login);
    }
}