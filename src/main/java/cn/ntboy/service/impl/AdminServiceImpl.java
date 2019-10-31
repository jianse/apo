package cn.ntboy.service.impl;

import cn.ntboy.model.Admin;
import cn.ntboy.model.AdminExample;
import cn.ntboy.repository.AdminMapper;
import cn.ntboy.service.AdminService;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.util.InjectMapper;
import cn.ntboy.util.tx.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @InjectMapper
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    private AdminMapper adminMapper = null;


    @Override
    public ServiceResultState<Admin> login(Admin admin) {
        AdminExample example = new AdminExample();
        example.createCriteria().andNameEqualTo(admin.getName()).andPwdEqualTo(admin.getPwd());
        List<Admin> data = adminMapper.selectByExample(example);
        if(data!=null&&!data.isEmpty()){
            return new ServiceResultState<Admin>(200,data.get(0));
        }
        return new ServiceResultState<>(500,null);
    }
}
