package cn.edu.nuc.community.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import cn.edu.nuc.community.entity.Rinfo;
import cn.edu.nuc.community.service.Interface.RinfoService;

@Controller
public class RinfoController {
	
	@Autowired
	private RinfoService rinfoService;
/**
 * 发布生活服务
 * @param serviceId
 * @param leagueId
 * @return
 */
	@RequestMapping(value="/publishLifeService/{serviceId}/{leagueId}",method=RequestMethod.GET)
	public ModelAndView toPublishLifeService(@PathVariable("serviceId") Integer serviceId,
			@PathVariable("leagueId") Integer leagueId){
		Rinfo rinfo = new Rinfo();
		rinfo.setServiceId(serviceId);
		rinfo.setLeagueId(leagueId);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		rinfo.setRinfoDate(df.format(new Date()));
		String viewName = "/rinfo/publishLifeService";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("rinfo", rinfo);
		return modelAndView;
	}
	
	@RequestMapping(value="/publishLifeService",method=RequestMethod.POST)
	public String publishLifeService(Rinfo rinfo,Model model){
		Integer rtn = 0;
		rtn = rinfoService.insert(rinfo);
		if(rtn > 0){
			return "redirect:/lifeServiceList";
		}else{
			model.addAttribute("msg", "发布失败，信息要完整！");
			return "/rinfo/publishLifeService";
		}
	}
	
	/**
	 * 发布金融服务
	 * @param serviceId
	 * @param leagueId
	 * @return
	 */
	@RequestMapping(value="/publishFinanceService/{serviceId}/{leagueId}",method=RequestMethod.GET)
	public ModelAndView toPublishFinanceService(@PathVariable("serviceId") Integer serviceId,
			@PathVariable("leagueId") Integer leagueId){
		Rinfo rinfo = new Rinfo();
		rinfo.setServiceId(serviceId);
		rinfo.setLeagueId(leagueId);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		rinfo.setRinfoDate(df.format(new Date()));
		String viewName = "/rinfo/publishFinanceService";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("rinfo", rinfo);
		return modelAndView;
	}
	
	@RequestMapping(value="/publishFinanceService",method=RequestMethod.POST)
	public String publishFinanceService(Rinfo rinfo,Model model){
		Integer rtn = 0;
		rtn = rinfoService.insert(rinfo);
		if(rtn > 0){
			return "redirect:/financeServiceList";
		}else{
			model.addAttribute("msg", "发布失败，信息要完整！");
			return "/rinfo/publishFinanceService";
		}
	}
	
	
	/**
	 * 分页已发布服务
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/publishServiceList",method=RequestMethod.GET)
	public String lifeServiceList(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin == null){
			rinfoService.showRinfoByPage(request, model);
		}else{
			model.addAttribute("rolemessage", "您没有这个权限");
		}
		  
	    return "/rinfo/listPublishService";
	}
	
	@RequestMapping(value="/editPublishService/{rinfoId}",method=RequestMethod.GET)
	public ModelAndView toEditPublishService(@PathVariable("rinfoId") Integer rinfoId){
		Rinfo rinfo = rinfoService.selectById(rinfoId);
		String viewName = "/rinfo/detailRinfo";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("rinfo", rinfo);
		return modelAndView;
	}
	
	@RequestMapping(value="/editRinfo",method=RequestMethod.POST)
	public String editPublishService(Rinfo rinfo,Model model){
		Integer rtn  = rinfoService.update(rinfo);
		if(rtn > 0){
			return "redirect:/publishServiceList";
		}else{
			model.addAttribute("msg", "修改失败！");
			return "rinfo/detailRinfo";
		}
	}
	
}
