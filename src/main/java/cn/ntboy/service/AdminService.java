package cn.ntboy.service;

import cn.ntboy.model.Admin;

/**
 * 管理员业务,
 */
public interface AdminService {

    /**
     * 管理员登录业务
     * @return 业务返回状态
     */
    ServiceResultState login(Admin admin);


}
