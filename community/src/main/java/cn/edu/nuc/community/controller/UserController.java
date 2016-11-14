package cn.edu.nuc.community.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.nuc.community.entity.User;
import cn.edu.nuc.community.service.Interface.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public User getUser(){
		return new User();
	}
	
	/**
	 * 进入首页
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	/**
	 * 进入登录页面
	 * @return
	 */
	@RequestMapping(value="/userLogin",method=RequestMethod.GET)
	public String userLoginGet(){
		return "/user/login";
	}
	/**
	 * 登录
	 * @param userPhone
	 * @param userPassword
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	public String userLogin(@RequestParam(value="userPhone") String userPhone,
			@RequestParam(value="userPassword") String userPassword,Model model,HttpSession session){
		User user = userService.selectByPhone(userPhone, userPassword,model);
		if(user != null ){
			session.setAttribute("user", user);
			return "index";
		}else{
			return "/user/login";
		}
		
	}
	/**
	 * 进入注册页面
	 * @return
	 */
	@RequestMapping(value="/userRegist",method=RequestMethod.GET)
	public String userRegistGet(){
		return "/user/regist";
	}
	
	@ResponseBody
    @RequestMapping(value="/queryByUser", method=RequestMethod.POST,produces="application/json;charset=UTF-8")  
   public String queryByName(User user,HttpServletRequest request){
        
       User user1 = new User();
       user1 = userService.selectByName(user.getUserName());
       return user1==null?"false":"true";
   }
	
	@RequestMapping(value="/userRegist",method=RequestMethod.POST)
	public String userRegist(@Valid User user,BindingResult result,Model model){
	
		if(result.hasErrors()){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			return "/user/regist";
		}else{
			userService.insert(user);
			user = userService.selectByName(user.getUserName());
			model.addAttribute("user", user);
			return "/user/authentication";
		}
		
	}
	
	@RequestMapping(value="/authentication",method=RequestMethod.POST)
	public String authentication(@Valid User user,BindingResult result,Model model){
			Integer rtn = 0;
			if(result.hasErrors()){
				for(FieldError error:result.getFieldErrors()){
					System.out.println(error.getField() + ":" + error.getDefaultMessage());
				}
				return "/user/authentication";
			}else{
				rtn = userService.update(user);
				if(rtn > 0){
					return "redirect:/userLogin";
				}else{
					return "/user/authentication";
				}
			}
	}
	
	/**
	 * 分页用户列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userList",method=RequestMethod.GET)
	public String userList(HttpServletRequest request, Model model){
		userService.showUserByPage(request, model); 
		  
	    return "/user/listUser";
	}
	/**
	 * 分页查询用户
	 * @param userPhone
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectUser", method = RequestMethod.POST)  
	public String selectUser(@RequestParam("userPhone") String userPhone,HttpServletRequest request, Model model) {  
	      
	    if(userPhone == null || userPhone.isEmpty()){
	    	 
	    	return "redirect:/userList";
	    }else{
	    		userService.selectUserByPage(userPhone,request, model); 
	    	    		
	    		return "/user/listUser"; 
	    }
	    
	}
	/**
	 * 分页用户列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userList1",method=RequestMethod.GET)
	public String userList1(HttpServletRequest request, Model model){
		userService.showUserByPage1(request, model); 
		  
	    return "/user/listUser1";
	}
	/**
	 * 分页查询用户
	 * @param userPhone
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectUser1", method = RequestMethod.POST)  
	public String selectUser1(@RequestParam("userPhone") String userPhone,HttpServletRequest request, Model model) {  
	      
	    if(userPhone == null || userPhone.isEmpty()){
	    	 
	    	return "redirect:/userList1";
	    }else{
	    		userService.selectUserByPage1(userPhone,request, model); 
	    	    		
	    		return "/user/listUser1"; 
	    }
	    
	}
	/**
	 * 转向 实名认证页面
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/authentication/{userId}",method=RequestMethod.GET)
	public ModelAndView authenticationGet(@PathVariable("userId") Integer userId){
		User user = userService.selectByUserId(userId);
		String viewName = "/user/authUser";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	/**
	 * 实名认证用户
	 * @param userId
	 * @param userState
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	public String authenticationPost(@RequestParam("userId") Integer userId,@RequestParam("userState") Integer userState,Model model){
		Integer rtn = 0;
		rtn = userService.updateByUserId(userId,userState);
		if(rtn > 0){
			return "redirect:/userList";
		}else{
			model.addAttribute("msg", "保存失败！");
			return "/user/authUser";
		}
	}
	/**
	 * 返回用户详细信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/userDetail/{userId}",method=RequestMethod.GET)
	public ModelAndView userDetail(@PathVariable("userId") Integer userId){
		User user = new User();
		user = userService.selectByUserId(userId);
		String viewName = "/user/userDetail";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value="/editUser",method=RequestMethod.POST)
	public String editUser(User user,Model model){
		Integer rtn = 0;
				rtn = userService.update(user);
				if(rtn > 0){
					return "redirect:userList1";
				}else{
					model.addAttribute("msg", "修改失败");
					return "/user/userDetail";
				}
	}
}
