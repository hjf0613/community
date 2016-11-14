package cn.edu.nuc.community.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.community.dao.AdminMapper;
import cn.edu.nuc.community.entity.Admin;
import cn.edu.nuc.community.service.Interface.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin selectAdminByName(String name) {
		Admin admin = adminMapper.selectByName(name);
		return admin;
	}

	@Override
	public Integer updateAdminByName(String name,String password) {
		Admin admin = new Admin();
		admin.setAdminName(name);
		admin.setAdminPassword(password);
		Integer rtn = adminMapper.updateByAdminName(admin);
		return rtn;
	}

}
