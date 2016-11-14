package cn.edu.nuc.community.service.Interface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import cn.edu.nuc.community.entity.Function;
import cn.edu.nuc.community.entity.Role;

@Transactional
public interface RoleService {

	void showRoleByPage(HttpServletRequest request, Model model);
	
	void selectRoleByPage(String roleName,HttpServletRequest request,Model model);
	
	Integer addRole(Role role,Model model);
	
	Role selectRoleById(Integer role);
	
	Integer updateRole(Role role,Model model);
	
	List<Function> initfunlist(Integer roleId,Model model);
	
	Integer saveRight(Integer roleId,String[] funIds,Model model);
}
