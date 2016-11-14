package cn.edu.nuc.community.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.edu.nuc.community.dao.ServiceMapper;
import cn.edu.nuc.community.dto.Page;
import cn.edu.nuc.community.entity.Services;
import cn.edu.nuc.community.service.Interface.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceMapper serviceMapper;
	@Override
	public void showServiceByPage(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");  
		  
	    Page page = null;  
	  
	    List<Services> services = new ArrayList<Services>();  
	  
	    int totalCount = (int)serviceMapper.getServiceCount1();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        services = serviceMapper.listLifeService(page.getStartPos()+1, page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        services = serviceMapper.listLifeService(page.getStartPos(), page.getStartPos()+page.getPageSize());  
	    }  
	  
	    model.addAttribute("serviceList", services);  
	    model.addAttribute("page", page); 
	}

	@Override
	public void selectServiceByPage(String serviceName, HttpServletRequest request, Model model) {
		Services service = null;
		service = serviceMapper.selectByServiceName(serviceName);
		if(service == null){
			model.addAttribute("errors", " 服务不存在");
			return ;
		}
		
		
		String pageNow = request.getParameter("pageNow");  
	  
	    Page page = null;  
	  
	    List<Services> services = new ArrayList<Services>();  
	  
	    int totalCount = (int)serviceMapper.getServiceCount1();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        services = serviceMapper.selectLifeService(service.getServiceId(), page.getStartPos(),page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        services = serviceMapper.selectLifeService(service.getServiceId(), page.getStartPos(),page.getStartPos()+page.getPageSize());
	    }  
	    System.out.println(services);
	    if(services.size() == 0){
	    	model.addAttribute("errors", "此服务不属于就生活类服务！");
	    }
	    model.addAttribute("serviceList", services);  
	    model.addAttribute("page", page); 
	}

	@Override
	public void showFinanceByPage(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");  
		  
	    Page page = null;  
	  
	    List<Services> services = new ArrayList<Services>();  
	  
	    int totalCount = (int)serviceMapper.getServiceCount2();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        services = serviceMapper.listFinanceService(page.getStartPos()+1, page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        services = serviceMapper.listFinanceService(page.getStartPos(), page.getStartPos()+page.getPageSize());  
	    }  
	  
	    model.addAttribute("serviceList1", services);  
	    model.addAttribute("page", page); 
		
	}

	@Override
	public void selectFinanceByPage(String serviceName, HttpServletRequest request, Model model) {
		Services service = null;
		service = serviceMapper.selectByServiceName(serviceName);
		if(service == null){
			model.addAttribute("errors", " 服务不存在");
			return ;
		}
		
		
		String pageNow = request.getParameter("pageNow");  
	  
	    Page page = null;  
	  
	    List<Services> services = new ArrayList<Services>();  
	  
	    int totalCount = (int)serviceMapper.getServiceCount2();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        services = serviceMapper.selectFinanceService(service.getServiceId(), page.getStartPos(),page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        services = serviceMapper.selectFinanceService(service.getServiceId(), page.getStartPos(),page.getStartPos()+page.getPageSize());
	    }  
	    System.out.println(services);
	    if(services.size() == 0){
	    	model.addAttribute("errors", "此服务不属于金融类服务！");
	    }
	    model.addAttribute("serviceList1", services);  
	    model.addAttribute("page", page); 
		
	}

	@Override
	public Services selectByServiceId(Integer serviceId) {
		Services services = serviceMapper.selectByPrimaryKey(serviceId);
		return services;
	}

	@Override
	public Integer updateService(Services services) {
		Integer rtn = 0;
		rtn = serviceMapper.updateByPrimaryKey(services);
		return rtn;
	}

	@Override
	public Integer insertService(Services services) {
		Integer rtn = 0;
		if(services.getServiceName() != null && !"".equals(services.getServiceName())){
			rtn = serviceMapper.insert(services);
		}
		return rtn;
	}

	@Override
	public List<Services> selectByservicePid(Integer servicePid) {
		List<Services> list = serviceMapper.listService(new BigDecimal(servicePid));
		return list;
	}

}
