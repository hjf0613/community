package cn.edu.nuc.community.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.edu.nuc.community.dao.FunctionMapper;
import cn.edu.nuc.community.dao.RoleMapper;
import cn.edu.nuc.community.dao.RolesRightMapper;
import cn.edu.nuc.community.dto.Page;
import cn.edu.nuc.community.entity.Function;
import cn.edu.nuc.community.entity.Role;
import cn.edu.nuc.community.entity.RolesRight;
import cn.edu.nuc.community.service.Interface.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private FunctionMapper functionMapper;
	
	@Autowired
	private RolesRightMapper rolesRightMapper;
	@Override
	public void showRoleByPage(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");  
		  
	    Page page = null;  
	  
	    List<Role> listRole = new ArrayList<Role>();  
	  
	    int totalCount = (int)roleMapper.getRoleCount();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        listRole = roleMapper.listRole(page.getStartPos()+1, page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        listRole = roleMapper.listRole(page.getStartPos(), page.getStartPos()+page.getPageSize());  
	    }  
	    System.out.println(listRole);
	    model.addAttribute("listRole", listRole);  
	    model.addAttribute("page", page); 
	}
	@Override
	public void selectRoleByPage(String roleName, HttpServletRequest request, Model model) {
		Role role = roleMapper.selectRoleByName(roleName);
		if(role == null){
			model.addAttribute("msg", "查询角色不存在");
			return ;
		}
		System.out.println(role);
		
		String pageNow = request.getParameter("pageNow");  
	  
	    Page page = null;  
	  
	    List<Role> listRole = new ArrayList<Role>();  
	  
	    int totalCount = (int)roleMapper.getRoleCount();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        listRole = roleMapper.selectRole(role.getRoleId(), page.getStartPos(),page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        listRole = roleMapper.selectRole(role.getRoleId(), page.getStartPos(),page.getStartPos()+page.getPageSize());
	    }  
	  System.out.println(listRole);
	    model.addAttribute("listRole", listRole);  
	    model.addAttribute("page", page); 
		
	}
	@Override
	public Integer addRole(Role role, Model model) {
		Integer rtn = 0;
		rtn = roleMapper.insert(role);
		if(rtn == 0){
			model.addAttribute("msg", "添加失败！");
		}
		return rtn;
	}
	@Override
	public Role selectRoleById(Integer role) {
		Role role1 = roleMapper.selectByPrimaryKey(role);
		return role1;
	}
	@Override
	public Integer updateRole(Role role, Model model) {
		Integer rtn = roleMapper.updateByPrimaryKey(role);
		if(rtn == 0){
			model.addAttribute("msg", "修改失败");
		}
		return rtn;
	}
	@Override
	public List<Function> initfunlist(Integer roleId,Model model) {
		Role role = new Role();
		List<Function> list = functionMapper.selectFunByRoleId(new BigDecimal(roleId));
		if(list == null || list.isEmpty()){
			model.addAttribute("msg", "初始化权限失败！");
		}
		System.out.println("初始化权限：+"+list);
		role = roleMapper.selectByPrimaryKey(roleId);
		model.addAttribute("list", list);
		model.addAttribute("role", role);
		return list;
	}
	@Override
	public Integer saveRight(Integer roleId, String[] funIds, Model model) {
		
		rolesRightMapper.deleteByRoleId(roleId);
		Integer rtn1 = 0;
		if(funIds != null){
			
			RolesRight rolesRight = new RolesRight();
			for(int i = 0;i < funIds.length;i++){
				rolesRight.setRoleId(roleId);
				rolesRight.setFunId(Integer.parseInt(funIds[i]));
				rtn1 = rolesRightMapper.insert(rolesRight);
			}
			if(rtn1 == 0){
				model.addAttribute("msg", "保存权限失败！");
			}
			
		}else{
			rtn1 = 10;
		}
		
		
		return rtn1;
	}

}
