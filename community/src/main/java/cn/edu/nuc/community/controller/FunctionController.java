package cn.edu.nuc.community.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.nuc.community.entity.Admin;
import cn.edu.nuc.community.entity.Function;
import cn.edu.nuc.community.entity.League;
import cn.edu.nuc.community.service.Interface.FunctionService;

@Controller
public class FunctionController {

	@Autowired
	private FunctionService functionService;
	
	@RequestMapping(value="/initPage",method=RequestMethod.GET)
	public ModelAndView initPage(HttpServletRequest request){
		List<Function> list = null;
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		League league = (League)session.getAttribute("league");
		if(admin != null){	
			 list = functionService.selectFunctionByRoleId(admin.getRoleId());
		}else if(league != null){
			list = functionService.selectFunctionByRoleId(league.getRoleId());
		}
		String viewName = "/admin/admin_index";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("list", list);
		modelAndView.addObject("admin", admin);
		return modelAndView;
		
	}
	/**
	 * 分页显示功能
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listFunction", method = RequestMethod.GET)  
	public String listFunction(HttpServletRequest request, Model model) {  
	    // 取得SESSION中的loginUser  
	   Admin admin = (Admin) request.getSession().getAttribute("admin");  
	    // 判断SESSION是否失效  
	    if (admin == null || "".equals(admin)) {  
	        return "redirect:/adminLogin";  
	    }  
	    
	    functionService.showFunctionByPage(request, model); 
	  
	    return "/admin/listFunction";  
	}
	/**
	 * 分页查询功能
	 * @param funName
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectFunction", method = RequestMethod.POST)  
	public String selectFunction(@RequestParam("funName") String funName,HttpServletRequest request, Model model) {  
	    // 取得SESSION中的loginUser  
	   Admin admin = (Admin) request.getSession().getAttribute("admin");  
	    // 判断SESSION是否失效  
	    if (admin == null || "".equals(admin)) {  
	        return "redirect:/adminLogin";  
	    }  
	    if(funName == null || funName.isEmpty()){
	    	 
	    	return "redirect:/listFunction";
	    }else{
	    		functionService.selectFunctionByPage(funName,request, model); 
	    	    		
	    		return "/admin/listFunction"; 
	 
	    	
	    }
	    
	}
	/**
	 * 获取功能详细信息
	 * @param funId
	 * @return
	 */
	@RequestMapping(value="/detailFunction/{funId}",method=RequestMethod.GET)
	public ModelAndView detailFunction(@PathVariable(value="funId") Integer funId){
		
		Function function = functionService.detailFunction(funId);
		String viewName = "/admin/detailFunction";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("item", function);
		return modelAndView;
	}
	/**
	 * 修改功能
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editFunction",method=RequestMethod.POST)
	public String editFunction(Function function,Model model){
		functionService.editFunction(function, model);
		return "redirect:/listFunction";
	}
	/**
	 * 跳转添加顶级功能页面
	 * @return
	 */
	@RequestMapping(value="/toAddPfunction",method=RequestMethod.GET)
	public ModelAndView toAddPfunction(){
		Function function = new Function();
		function.setFunPid(new BigDecimal(-1));
		function.setFunPname("无");
		String viewName = "/admin/AddFunction";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("function", function);
		return modelAndView;
	}
	@RequestMapping(value="/sonFunction/{funId}/{funName}",method=RequestMethod.GET)
	public ModelAndView toAddSonFunction(@PathVariable(value="funId") Integer funId,@PathVariable(value="funName") String funName){
		Function function = new Function();
		function.setFunPid(new BigDecimal(funId));
		function.setFunPname(funName);
		String viewName = "/admin/AddFunction";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("function", function);
		return modelAndView;
	}
	/**
	 * 添加子功能
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addFunction",method=RequestMethod.POST)
	public String addFunction(Function function,Model model){
		Integer rtn = 0;
		rtn = functionService.insertFunction(function, model);
		if(rtn > 0){
			return "redirect:/listFunction";
		}else{
			return "/admin/AddFunction";
		}
		
	}
}
