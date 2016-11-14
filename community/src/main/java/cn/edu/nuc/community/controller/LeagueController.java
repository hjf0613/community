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

import cn.edu.nuc.community.entity.League;
import cn.edu.nuc.community.service.Interface.LeagueService;


@Controller
public class LeagueController {

	
	@Autowired
	private LeagueService leagueService;
	
	@ModelAttribute
	public League getLeague(){
		return new League();
	}
	
	/**
	 * 进入登录页面
	 * @return
	 */
	@RequestMapping(value="/leagueLogin",method=RequestMethod.GET)
	public String leagueLoginGet(){
		return "/league/login";
	}
	/**
	 * 登录
	 * @param leagueName
	 * @param leaguePassword
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/leagueLogin",method=RequestMethod.POST)
	public String leagueLogin(@RequestParam(value="leagueName") String leagueName,
			@RequestParam(value="leaguePassword") String leaguePassword,Model model,HttpSession session){
		League league = leagueService.selectByName1(leagueName, leaguePassword,model);
		if(league != null ){
			session.setAttribute("league", league);
			return "redirect:/initPage";
		}else{
			return "/league/login";
		}
		
	}
	/**
	 * 进入注册页面
	 * @return
	 */
	@RequestMapping(value="/leagueRegist",method=RequestMethod.GET)
	public String leagueRegistGet(){
		return "/league/regist";
	}
	
	@ResponseBody
    @RequestMapping(value="/queryByLeague", method=RequestMethod.POST,produces="application/json;charset=UTF-8")  
   public String queryByName(League league,HttpServletRequest request){
        
		League league1 = new League();
		league1 = leagueService.selectByName(league.getLeagueName());
		return league1==null?"false":"true";
   }
	
	@RequestMapping(value="leagueRegist",method=RequestMethod.POST)
	public String leagueRegist(@Valid League league,BindingResult result,Model model){
	
		if(result.hasErrors()){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			return "/league/regist";
		}else{
			leagueService.insert(league);
			league = leagueService.selectByName(league.getLeagueName());
			model.addAttribute("league", league);
			return "/league/login";
		}
		
	}
	
	/**
	 * 分页加盟商列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/leagueList",method=RequestMethod.GET)
	public String leagueList(HttpServletRequest request, Model model){
		leagueService.showLeagueByPage(request, model); 
		  
	    return "/league/listLeague";
	}
	/**
	 * 分页查询用户
	 * @param leagueCompany
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectLeague", method = RequestMethod.POST)  
	public String selectLeague(@RequestParam("leagueCompany") String leagueCompany,HttpServletRequest request, Model model) {  
	      
	    if(leagueCompany == null || leagueCompany.isEmpty()){
	    	 
	    	return "redirect:/leagueList";
	    }else{
	    		leagueService.selectLeagueByPage(leagueCompany,request, model); 
	    	    		
	    		return "/league/listLeague"; 
	    }
	    
	}
	/**
	 * 分页用户列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/leagueList1",method=RequestMethod.GET)
	public String leagueList1(HttpServletRequest request, Model model){
		leagueService.showLeagueByPage1(request, model); 
		  
	    return "/league/listLeague1";
	}
	/**
	 * 分页查询用户
	 * @param leagueCompany
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectLeague1", method = RequestMethod.POST)  
	public String selectLeague1(@RequestParam("leagueCompany") String leagueCompany,HttpServletRequest request, Model model) {  
	      
	    if(leagueCompany == null || leagueCompany.isEmpty()){
	    	 
	    	return "redirect:/leagueList1";
	    }else{
	    		leagueService.selectLeagueByPage1(leagueCompany,request, model); 
	    	    		
	    		return "/league/listLeague1"; 
	    }
	    
	}
	
	@RequestMapping(value="/audit/{leagueName}",method=RequestMethod.GET)
	public ModelAndView auditGet(@PathVariable("leagueName") String leagueName){
		League league = leagueService.selectByName(leagueName);
		String viewName = "/league/leagueAudit";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("league", league);
		return modelAndView;
	}
	@RequestMapping(value="audit",method=RequestMethod.POST)
	public String auditPost(League league,Model model){
		Integer rtn = 0;
		rtn = leagueService.update(league);
		if(rtn > 0){
			return "redirect:leagueList";
		}else{
			model.addAttribute("msg", "审核失败！");
			return "/league/leagueAudit";
		}
	}
	
	@RequestMapping(value="/leagueDetail/{leagueName}",method=RequestMethod.GET)
	public ModelAndView leagueDetailGet(@PathVariable("leagueName") String leagueName){
		League league = leagueService.selectByName(leagueName);
		String viewName = "/league/leagueDetail";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("league", league);
		return modelAndView;
	}
	@RequestMapping(value="detail",method=RequestMethod.POST)
	public String leagueDetailPost(League league,Model model){
		Integer rtn = 0;
		rtn = leagueService.update(league);
		if(rtn > 0){
			return "redirect:leagueList1";
		}else{
			model.addAttribute("msg", "修改失败！");
			return "/league/leagueDetail";
		}
	}
}
