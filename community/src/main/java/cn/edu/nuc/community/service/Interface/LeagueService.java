package cn.edu.nuc.community.service.Interface;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import cn.edu.nuc.community.entity.League;

@Transactional
public interface LeagueService {
	
	League selectByName(String leagueName);
	
	League selectByName1(String leagueName,String leaguePassword,Model model);
	
	League selectById(Integer leagueId);
	
	Integer insert(League league);
	
	Integer update(League league);
	
		/**
		 * 分页显示功能0
		 * @param request
		 * @param model
		 */
	  void showLeagueByPage(HttpServletRequest request,Model model);
	  /**
		  * 分页查询功能0
		  * @param request
		  * @param model
		  */
	  void selectLeagueByPage(String leagueCompany,HttpServletRequest request,Model model);
	 /**
		  * 分页显示功能1
		  * @param request
		  * @param model
		  */
	  void showLeagueByPage1(HttpServletRequest request,Model model);
	  /**
		  * 分页查询功能1
		  * @param request
		  * @param model
		  */
	  void selectLeagueByPage1(String leagueCompany,HttpServletRequest request,Model model);
}
