package cn.edu.nuc.community.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.nuc.community.entity.Admin;
import cn.edu.nuc.community.service.Interface.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 转向登录页面
	 * @return
	 */
	@RequestMapping(value="/adminLogin",method=RequestMethod.GET)
	public String loginGet(){
		return "admin/adminlogin";
	}
	/**
	 * 管理员登录
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/adminLogin",method=RequestMethod.POST)
	public String login(@RequestParam("adminName") String name,@RequestParam("adminPassword") String password,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Admin admin = adminService.selectAdminByName(name);
		if(admin.getAdminPassword().equals(password)){
			session.setAttribute("admin", admin);
			return "redirect:/initPage";
		}else{
			session.setAttribute("error", "用户名或密码错误！");
			return "/admin/adminlogin";
		}
		
	}
	/**
	 * 注销
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		return "redirect:/adminLogin";
	}
	/**
	 * 注销
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout1",method=RequestMethod.GET)
	public String logout1(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("league");
		return "redirect:/leagueLogin";
	}
	/**
	 * 转向修改密码页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/editPassword",method=RequestMethod.GET)
	public ModelAndView editPasswordGet(HttpServletRequest request){
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		String viewName = "/admin/admin_editPass";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("admin", admin);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/editPassword",method=RequestMethod.POST)
	public String editPassword(@RequestParam("adminName") String adminName,@RequestParam("adminPassword") String adminPassword,Model model){
		Integer rtn = 0;
		if(adminPassword != null && !adminPassword.isEmpty()){
			rtn = adminService.updateAdminByName(adminName,adminPassword);
			if(rtn > 0){
				return "redirect:/adminLogin";
			}else{
				return "/admin/admin_editPass";
			}
		}else{
				model.addAttribute("msg", "密码不能为空！");
				return "/admin/admin_editPass";
		}
		
		
	}
}
