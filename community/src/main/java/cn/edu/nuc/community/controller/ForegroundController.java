package cn.edu.nuc.community.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.nuc.community.entity.League;
import cn.edu.nuc.community.entity.Rinfo;
import cn.edu.nuc.community.entity.Services;
import cn.edu.nuc.community.service.Interface.LeagueService;
import cn.edu.nuc.community.service.Interface.RinfoService;
import cn.edu.nuc.community.service.Interface.ServiceService;

@Controller
public class ForegroundController {
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private RinfoService rinfoService;
	@Autowired
	private LeagueService leagueService;
	
	@RequestMapping(value="/toIndex",method=RequestMethod.GET)
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping(value="/initLife",method=RequestMethod.GET)
	public ModelAndView initLife(HttpServletRequest request,Model model){
		List<Services> listLifeService = serviceService.selectByservicePid(1);
		Services service = serviceService.selectByServiceId(2);
		rinfoService.initRinfoPage(request, model, 2);
		String viewName = "subLifeService";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("listLifeService", listLifeService);
		modelAndView.addObject("service", service);
		return modelAndView;
	}
	
	@RequestMapping(value="/initFinance",method=RequestMethod.GET)
	public ModelAndView initFinance(HttpServletRequest request,Model model){
		List<Services> listFinanceService = serviceService.selectByservicePid(2);
		Services service = serviceService.selectByServiceId(3);
		rinfoService.initRinfoPage(request, model, 3);
		String viewName = "subFinanceService";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("listFinanceService", listFinanceService);
		modelAndView.addObject("service", service);
		return modelAndView;
	}
	
	@RequestMapping(value="/listOneLifeService/{serviceId}",method=RequestMethod.GET)
	public ModelAndView listOneLifeService(@PathVariable("serviceId") Integer serviceId,HttpServletRequest request,Model model){
		List<Services> listLifeService = serviceService.selectByservicePid(1);
		Services service = serviceService.selectByServiceId(serviceId);
		rinfoService.initRinfoPage(request, model, serviceId);
		String viewName = "subLifeService";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("listLifeService", listLifeService);
		modelAndView.addObject("service", service);
		return modelAndView;
	}
	
	@RequestMapping(value="/listOneFinanceService/{serviceId}",method=RequestMethod.GET)
	public ModelAndView listOneFinanceService(@PathVariable("serviceId") Integer serviceId,HttpServletRequest request,Model model){
		List<Services> listFinanceService = serviceService.selectByservicePid(2);
		Services service = serviceService.selectByServiceId(serviceId);
		rinfoService.initRinfoPage(request, model, serviceId);
		String viewName = "subFinanceService";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("listFinanceService", listFinanceService);
		modelAndView.addObject("service", service);
		return modelAndView;
	}
	
	@RequestMapping(value="/oneLifeRinfo/{rinfoId}/{serviceId}/{leagueId}",method=RequestMethod.GET)
	public ModelAndView oneLifeRinfo(@PathVariable("rinfoId") Integer rinfoId,
			@PathVariable("serviceId") Integer serviceId,
			@PathVariable("leagueId") Integer leagueId){
		Rinfo rinfo = rinfoService.selectById(rinfoId);
		Services service = serviceService.selectByServiceId(serviceId);
		League league = leagueService.selectById(leagueId);
		
		String viewName = "rinfoLife";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("rinfo", rinfo);
		modelAndView.addObject("service", service);
		modelAndView.addObject("league", league);
		return modelAndView;	
	}
	
	@RequestMapping(value="/oneFinanceRinfo/{rinfoId}/{serviceId}/{leagueId}",method=RequestMethod.GET)
	public ModelAndView oneFinanceinfo(@PathVariable("rinfoId") Integer rinfoId,
			@PathVariable("serviceId") Integer serviceId,
			@PathVariable("leagueId") Integer leagueId){
		Rinfo rinfo = rinfoService.selectById(rinfoId);
		Services service = serviceService.selectByServiceId(serviceId);
		League league = leagueService.selectById(leagueId);
		
		String viewName = "rinfoFinance";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("rinfo", rinfo);
		modelAndView.addObject("service", service);
		modelAndView.addObject("league", league);
		return modelAndView;	
	}
}
