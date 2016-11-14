package cn.edu.nuc.community.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.nuc.community.entity.Function;
import cn.edu.nuc.community.entity.Role;
import cn.edu.nuc.community.service.Interface.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	/**
	 * 分页角色列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/roleList",method=RequestMethod.GET)
	public String roleList(HttpServletRequest request, Model model){
		roleService.showRoleByPage(request, model); 
		  
	    return "/admin/listRole";
	}
	/**
	 * 分页查询角色
	 * @param roleName
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectRole", method = RequestMethod.POST)  
	public String selectRole(@RequestParam("roleName") String roleName,HttpServletRequest request, Model model) {  
	      
	    if(roleName == null || roleName.isEmpty()){
	    	 
	    	return "redirect:/roleList";
	    }else{
	    		roleService.selectRoleByPage(roleName,request, model); 
	    	    		
	    		return "/admin/listRole"; 
	    }
	    
	}
	/**
	 * 跳转角色添加页面
	 * @return
	 */
	@RequestMapping(value="/toAddRole",method=RequestMethod.GET)
	public String toAddRole(){
		return "/admin/addRole";
	}
	
	@RequestMapping(value="addRole",method=RequestMethod.POST)
	public String addRole(Role role,Model model){
		Integer rtn  = 0;
		rtn = roleService.addRole(role, model);
		if(rtn > 0){
			return "redirect:roleList";
		}else{
			return "/admin/addRole";
		}
	}
	
	@RequestMapping(value="editRole/{roleId}",method=RequestMethod.GET)
	public ModelAndView toEditRole(@PathVariable("roleId") Integer roleId){
		Role role = roleService.selectRoleById(roleId);
		String viewName = "/admin/detailRole";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("role", role);
		return modelAndView;
	}
	/**
	 * 编辑权限
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editRole",method=RequestMethod.POST)
	public String editRole(Role role,Model model){
		Integer rtn = roleService.updateRole(role, model);
		if(rtn == 0){
			return "/admin/detailRole";
		}else{
			return "redirect:/roleList";
		}
	}
	/**
	 * 初始化角色的权限
	 * @param roleId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="initFunList/{roleId}",method=RequestMethod.GET)
	public String initFunList(@PathVariable("roleId") Integer roleId,Model model){
		List<Function> list = roleService.initfunlist(roleId, model);
		if(list != null){
			return "/admin/right";
		}else{
			return "redirect:/roleList";
		}
	}
	@RequestMapping(value="/saveright",method=RequestMethod.POST)
	public String saveRight(@RequestParam(value="roleId") Integer roleId,@RequestParam(value="ckrr",required=false) String[] funIds,Model model){
		String[] funids = funIds;
		Integer rtn = roleService.saveRight(roleId, funids, model);
		if(rtn > 0 ){
			return "redirect:/roleList";
		}else{
			return "/admin/right";
		}
		
		
	}
}
