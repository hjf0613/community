package cn.edu.nuc.community.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.nuc.community.entity.Services;
import cn.edu.nuc.community.service.Interface.ServiceService;

@Controller
public class ServicesController {

	@Autowired
	private ServiceService serviceService;
	
	/**
	 * 分页生活服务列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/lifeServiceList",method=RequestMethod.GET)
	public String lifeServiceList(HttpServletRequest request, Model model){
		serviceService.showServiceByPage(request, model); 
		  
	    return "/service/listLifeService";
	}
	/**
	 * 分页查询生活服务
	 * @param serviceName
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectLifeService", method = RequestMethod.POST)  
	public String lifeSelectService(@RequestParam("serviceName") String serviceName,HttpServletRequest request, Model model) {  
	      
	    if(serviceName == null || serviceName.isEmpty()){
	    	 
	    	return "redirect:/lifeServiceList";
	    }else{
	    	serviceService.selectServiceByPage(serviceName,request, model); 
	    	    		
	    		return "/service/listLifeService"; 
	    }
	    
	}
	
	/**
	 * 分页金融服务列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/financeServiceList",method=RequestMethod.GET)
	public String financeServiceList(HttpServletRequest request, Model model){
		serviceService.showFinanceByPage(request, model);
		  
	    return "/service/listFinanceService";
	}
	
	/**
	 * 分页查询金融服务
	 * @param serviceName
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectFinanceService", method = RequestMethod.POST)  
	public String financeSelectService(@RequestParam("serviceName") String serviceName,HttpServletRequest request, Model model) {  
	      
	    if(serviceName == null || serviceName.isEmpty()){
	    	 
	    	return "redirect:/financeServiceList";
	    }else{
	    	serviceService.selectFinanceByPage(serviceName, request, model);
	    	    		
	    		return "/service/listFinanceService"; 
	    }
	    
	}
	/**
	 * 修改生活服务
	 * @param serviceId
	 * @return
	 */
	@RequestMapping(value="/editLifeService/{serviceId}",method=RequestMethod.GET)
	public ModelAndView toEditLifeService(@PathVariable(value="serviceId") Integer serviceId){
		Services services = serviceService.selectByServiceId(serviceId);
		String viewName = "/service/editLifeService";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("services", services);
		return modelAndView;
	}
	
	@RequestMapping(value="/editLifeService",method=RequestMethod.POST)
	public String editLifeService(Services services,Model model){
		Integer rtn = 0;
		rtn = serviceService.updateService(services);
		if(rtn > 0){
			return "redirect:/lifeServiceList";
		}else{
			model.addAttribute("msg", "修改失败");
			return "/service/editLifeService";
		}
	}
	/**
	 * 修改金融服务
	 * @param serviceId
	 * @return
	 */
	@RequestMapping(value="/editFinanceService/{serviceId}",method=RequestMethod.GET)
	public ModelAndView toEditFinanceService(@PathVariable(value="serviceId") Integer serviceId){
		Services services = serviceService.selectByServiceId(serviceId);
		String viewName = "/service/editFinanceService";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("services", services);
		return modelAndView;
	}
	
	@RequestMapping(value="/editFinanceService",method=RequestMethod.POST)
	public String editFinanceService(Services services,Model model){
		Integer rtn = 0;
		rtn = serviceService.updateService(services);
		if(rtn > 0){
			return "redirect:/financeServiceList";
		}else{
			model.addAttribute("msg", "修改失败");
			return "/service/editFinanceService";
		}
	}
	
	@RequestMapping(value="toAddLifeService",method=RequestMethod.GET)
	public String toAddLifeService(){
		return "/service/addLifeService";
	}
	@RequestMapping(value="/addLifeService",method=RequestMethod.POST)
	public String addLifeService(Services services,Model model){
		Integer rtn = serviceService.insertService(services);
		if(rtn > 0){
			return "redirect:/lifeServiceList";
		}else{
			model.addAttribute("msg", "添加失败！");
			return "/service/addLifeService";
		}
	}
	
	@RequestMapping(value="toAddFinanceService",method=RequestMethod.GET)
	public String toFinanceLifeService(){
		return "/service/addFinanceService";
	}
	@RequestMapping(value="/addFinanceService",method=RequestMethod.POST)
	public String addFinanceService(Services services,Model model){
		Integer rtn = serviceService.insertService(services);
		if(rtn > 0){
			return "redirect:/financeServiceList";
		}else{
			model.addAttribute("msg", "添加失败！");
			return "/service/addFinanceService";
		}
	}
}
