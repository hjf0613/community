package cn.edu.nuc.community.service.Interface;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import cn.edu.nuc.community.entity.User;

@Transactional
public interface UserService {
	
	User selectByPhone(String userPhone,String userPassword,Model model);
	
	User selectByName(String userName);
	
	User selectByUserId(Integer userId);
	
	Integer insert(User user);
	
	Integer update(User user);
	/**
	 * 实名认证时候只更新用户状态
	 * @param user
	 * @return
	 */
	Integer updateByUserId(Integer userId,Integer userState);
	
	/**
	  * 分页显示功能0
	  * @param request
	  * @param model
	  */
   void showUserByPage(HttpServletRequest request,Model model);
   /**
	  * 分页查询功能0
	  * @param request
	  * @param model
	  */
  void selectUserByPage(String userPhone,HttpServletRequest request,Model model);
  /**
	  * 分页显示功能1
	  * @param request
	  * @param model
	  */
void showUserByPage1(HttpServletRequest request,Model model);
/**
	  * 分页查询功能1
	  * @param request
	  * @param model
	  */
void selectUserByPage1(String userPhone,HttpServletRequest request,Model model);
}
