package cn.edu.nuc.community.service.Interface;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.nuc.community.entity.Admin;
@Transactional
public interface AdminService {
	Admin selectAdminByName(String name);
	Integer updateAdminByName(String name,String pass);
}
