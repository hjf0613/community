package cn.edu.nuc.community.service.Interface;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import cn.edu.nuc.community.entity.Function;

@Transactional
public interface FunctionService {
	/**
	 * 根据roleId查询功能
	 * @param funState
	 * @return
	 */
	List<Function> selectFunctionByRoleId(Integer roleId);
	
	 /**
	  * 分页显示功能
	  * @param request
	  * @param model
	  */
    void showFunctionByPage(HttpServletRequest request,Model model);
    /**
	  * 分页查询功能
	  * @param request
	  * @param model
	  */
   void selectFunctionByPage(String funName,HttpServletRequest request,Model model); 
   /**
    * 根据ID查询功能详细信息
    * @param funId
    * @return
    */
   Function detailFunction(Integer funId);
  /**
   * 更新功能 
   * @param function
   * @return
   */
   Integer editFunction(Function function,Model model);
   /**
    * 添加功能
    * @param function
    * @param model
    * @return
    */
   Integer insertFunction(Function function,Model model);
}
