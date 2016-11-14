package cn.edu.nuc.community.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.edu.nuc.community.dao.LeagueMapper;
import cn.edu.nuc.community.dto.Page;
import cn.edu.nuc.community.entity.League;
import cn.edu.nuc.community.entity.User;
import cn.edu.nuc.community.service.Interface.LeagueService;

@Service
public class LeagueServiceImpl implements LeagueService {
	
	@Autowired
	private LeagueMapper leagueMapper;

	@Override
	public League selectByName1(String leagueName,String leaguePassword,Model model) {
		League league = null;
		league = leagueMapper.selectByName(leagueName);
		System.out.println("haha"+league);
		if(league != null){
					System.out.println(league.getLeaguePassword());
					if(league.getLeaguePassword().equals(leaguePassword)){
						model.addAttribute("league", league);
					}else{
						league=null;
						model.addAttribute("error", "login error!");
					}
				}else{
					model.addAttribute("error", "login error!");
				}
		return league;
		
	}

	@Override
	public League selectByName(String leagueName) {
		League league = null;
		league = leagueMapper.selectByName(leagueName);
		return league;
	}

	@Override
	public Integer insert(League league) {
		Integer rtn = 0;
		league.setRoleId(4);
		rtn =leagueMapper.insert(league);
		
		return rtn;
		
	}

	@Override
	public void showLeagueByPage(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");  
		  
	    Page page = null;  
	  
	    List<League> leagues = new ArrayList<League>();  
	  
	    int totalCount = (int)leagueMapper.getLeagueCount();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        leagues = leagueMapper.listLeague(page.getStartPos()+1, page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        leagues = leagueMapper.listLeague(page.getStartPos(), page.getStartPos()+page.getPageSize());  
	    }  
	  
	    model.addAttribute("leagueList", leagues);  
	    model.addAttribute("page", page); 
		
	}

	@Override
	public void selectLeagueByPage(String leagueCompany, HttpServletRequest request, Model model) {
		League league = null;
		league = leagueMapper.selectByCompany(leagueCompany);
		if(league == null){
			model.addAttribute("errors", " 公司不存在");
			return ;
		}
		
		
		String pageNow = request.getParameter("pageNow");  
	  
	    Page page = null;  
	  
	    List<League> leagues = new ArrayList<League>();  
	  
	    int totalCount = (int)leagueMapper.getLeagueCount();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        leagues = leagueMapper.selectLeague(league.getLeagueId(), page.getStartPos(),page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        leagues = leagueMapper.selectLeague(league.getLeagueId(), page.getStartPos(),page.getStartPos()+page.getPageSize());
	    }  
	    System.out.println(leagues);
	    if(leagues.size() == 0){
	    	model.addAttribute("errors", "公司已审核！");
	    }
	    model.addAttribute("leagueList", leagues);  
	    model.addAttribute("page", page);
		
	}

	@Override
	public void showLeagueByPage1(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");  
		  
	    Page page = null;  
	  
	    List<League> leagues = new ArrayList<League>();  
	  
	    int totalCount = (int)leagueMapper.getLeagueCount();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        leagues = leagueMapper.listLeague1(page.getStartPos()+1, page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        leagues = leagueMapper.listLeague1(page.getStartPos(), page.getStartPos()+page.getPageSize());  
	    }  
	  
	    model.addAttribute("leagueList1", leagues);  
	    model.addAttribute("page", page); 
		
	}

	@Override
	public void selectLeagueByPage1(String leagueCompany, HttpServletRequest request, Model model) {
		League league = null;
		league = leagueMapper.selectByCompany(leagueCompany);
		if(league == null){
			model.addAttribute("errors", " 公司不存在");
			return ;
		}
		
		
		String pageNow = request.getParameter("pageNow");  
	  
	    Page page = null;  
	  
	    List<League> leagues = new ArrayList<League>();  
	  
	    int totalCount = (int)leagueMapper.getLeagueCount();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        leagues = leagueMapper.selectLeague1(league.getLeagueId(), page.getStartPos(),page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        leagues = leagueMapper.selectLeague1(league.getLeagueId(), page.getStartPos(),page.getStartPos()+page.getPageSize());
	    }  
	    System.out.println(leagues);
	    if(leagues.size() == 0){
	    	model.addAttribute("errors", "公司未审核！");
	    }
	    model.addAttribute("leagueList1", leagues);  
	    model.addAttribute("page", page);
		
	}

	@Override
	public Integer update(League league) {
		Integer rtn = 0;
		rtn = leagueMapper.updateByPrimaryKey(league);
		return rtn;
	}

	@Override
	public League selectById(Integer leagueId) {
		League league = leagueMapper.selectByPrimaryKey(leagueId);
		return league;
	}



}
