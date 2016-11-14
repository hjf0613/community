package cn.edu.nuc.community.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.edu.nuc.community.dao.RinfoMapper;
import cn.edu.nuc.community.dto.Page;
import cn.edu.nuc.community.entity.League;
import cn.edu.nuc.community.entity.Rinfo;
import cn.edu.nuc.community.service.Interface.RinfoService;
@Service
public class RinfoServiceImpl implements RinfoService {

	@Autowired
	private RinfoMapper rinfoMapper;
	@Override
	public Integer insert(Rinfo rinfo) {
		Integer rtn = 0;
		if(rinfo.getRinfoDesc() != null && rinfo.getRinfoPrice() != null){
		rtn = rinfoMapper.insert(rinfo);
		}
		return rtn;
	}
	@Override
	public void showRinfoByPage(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		League league = (League)session.getAttribute("league");
		String pageNow = request.getParameter("pageNow");  
		  
	    Page page = null;  
	  
	    List<Rinfo> rinfos = new ArrayList<Rinfo>();  
	  
	    int totalCount = (int)rinfoMapper.getRinfoCountByLeagueId(league.getLeagueId());  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        rinfos = rinfoMapper.listRinfo(league.getLeagueId(),page.getStartPos()+1, page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        rinfos = rinfoMapper.listRinfo(league.getLeagueId(),page.getStartPos(), page.getStartPos()+page.getPageSize());  
	    }  
	  
	    model.addAttribute("rinfoList", rinfos);  
	    model.addAttribute("page", page); 
		
		
	}
	@Override
	public Rinfo selectById(Integer rinfoId) {
		Rinfo rinfo = rinfoMapper.selectByPrimaryKey(rinfoId);
		return rinfo;
	}
	@Override
	public Integer update(Rinfo rinfo) {
		Integer rtn = 0;
		rtn = rinfoMapper.updateByPrimaryKey(rinfo);
		return rtn;
	}
	@Override
	public void initRinfoPage(HttpServletRequest request, Model model,Integer serviceId) {
		String pageNow = request.getParameter("pageNow");  
		  
	    Page page = null;  
	  
	    List<Rinfo> rinfos = new ArrayList<Rinfo>();  
	  
	    int totalCount = (int)rinfoMapper.getRinfoCountByServiceId(serviceId);  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        rinfos = rinfoMapper.initRinfo(serviceId,page.getStartPos()+1, page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        rinfos = rinfoMapper.initRinfo(serviceId,page.getStartPos(), page.getStartPos()+page.getPageSize());  
	    }  
	  
	    model.addAttribute("rinfoList", rinfos);  
	    model.addAttribute("page", page); 
		
	}

}
