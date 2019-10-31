package cn.ntboy.service;

import cn.ntboy.model.Admin;
import cn.ntboy.service.impl.AdminServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminServiceTest {
    AdminService adminService = new AdminServiceImpl();

    @Test
    public void login() {
        Admin admin = new Admin();
        admin.setName("root");
        admin.setPwd("123");
        ServiceResultState login = adminService.login(admin);
        System.out.println(login);
    }
}