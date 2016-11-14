package cn.edu.nuc.community.service.Interface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import cn.edu.nuc.community.entity.Services;

@Transactional
public interface ServiceService {


	/**
	  * 分页显示生活服务
	  * @param request
	  * @param model
	  */
   void showServiceByPage(HttpServletRequest request,Model model);
   /**
	  * 分页查询生活服务
	  * @param request
	  * @param model
	  */
  void selectServiceByPage(String serviceName,HttpServletRequest request,Model model);
  
  /**
	  * 分页显示金融服务
	  * @param request
	  * @param model
	  */
  void showFinanceByPage(HttpServletRequest request,Model model);
/**
	  * 分页查询金融服务
	  * @param request
	  * @param model
	  */
  void selectFinanceByPage(String serviceName,HttpServletRequest request,Model model);
  
  /**
   * 根据ID查询service
   * @param serviceId
   * @return
   */
  Services selectByServiceId(Integer serviceId);
  /**
   * 根据Pid查询服务
   * @param servicePid
   * @return
   */
  List<Services> selectByservicePid(Integer servicePid);
  /**
   * 修改服务
   * @param services
   * @return
   */
  Integer updateService(Services services);
  /**
   * 添加服务
   * @param services
   * @return
   */
  Integer insertService(Services services);
}
