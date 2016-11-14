package cn.edu.nuc.community.service.Interface;


import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import cn.edu.nuc.community.entity.Rinfo;

@Transactional
public interface RinfoService {
	Integer insert(Rinfo rinfo);
	
	 void initRinfoPage(HttpServletRequest request,Model model,Integer serviceId);
	
	/**
	 * 分页显示功能0
	 * @param request
	 * @param model
	 */
	void showRinfoByPage(HttpServletRequest request,Model model);
	/**
	 * 查询发布信息
	 * @param rinfoId
	 * @return
	 */
	Rinfo selectById(Integer rinfoId);
	/**
	 * 修改发布信息
	 * @param rinfo
	 * @return
	 */
	Integer update(Rinfo rinfo);
}
