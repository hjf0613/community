package cn.edu.nuc.community.service.Impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.edu.nuc.community.dao.UserMapper;
import cn.edu.nuc.community.dto.Page;
import cn.edu.nuc.community.entity.User;
import cn.edu.nuc.community.service.Interface.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectByPhone(String userPhone,String userPassword,Model model) {
		User user = null;
		user = userMapper.selectByPhone(userPhone);
		if(user != null){
			
			if(user.getUserPassword().equals(userPassword)){
				model.addAttribute("user", user);
			}else{
				user=null;
				model.addAttribute("error", "login error!");
			}
		}else{
			model.addAttribute("error", "login error!");
		}
		return user;
	}

	@Override
	public User selectByName(String userName) {
		User user = null;
		user = userMapper.selectByName(userName);
		return user;
	}

	@Override
	public Integer insert(User user) {
		Integer rtn = 0;
		user.setRoleId(3);
		rtn = userMapper.insert(user);
		
		return rtn;
	}

	@Override
	public Integer update(User user) {
		Integer rtn = 0;
		rtn = userMapper.updateByPrimaryKey(user);
		return rtn;
	}

	@Override
	public void showUserByPage(HttpServletRequest request, Model model) {
		 String pageNow = request.getParameter("pageNow");  
		  
		    Page page = null;  
		  
		    List<User> users = new ArrayList<User>();  
		  
		    int totalCount = (int)userMapper.getUserCount();  
		  
		    if (pageNow != null) {  
		        page = new Page(totalCount, Integer.parseInt(pageNow));  
		        users = userMapper.listUser(page.getStartPos()+1, page.getStartPos()+page.getPageSize()); 
		    } else {  
		        page = new Page(totalCount, 1);  
		        users = userMapper.listUser(page.getStartPos(), page.getStartPos()+page.getPageSize());  
		    }  
		  
		    model.addAttribute("userList", users);  
		    model.addAttribute("page", page); 
		
	}

	@Override
	public void selectUserByPage(String userPhone, HttpServletRequest request, Model model) {
		User user = null;
		user = userMapper.selectByPhone(userPhone);
		if(user == null){
			model.addAttribute("errors", " 用户不存在");
			return ;
		}
		
		
		String pageNow = request.getParameter("pageNow");  
	  
	    Page page = null;  
	  
	    List<User> users = new ArrayList<User>();  
	  
	    int totalCount = (int)userMapper.getUserCount();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        users = userMapper.selectUser(user.getUserId(), page.getStartPos(),page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        users = userMapper.selectUser(user.getUserId(), page.getStartPos(),page.getStartPos()+page.getPageSize());
	    }  
	    System.out.println(users);
	    if(users.size() == 0){
	    	model.addAttribute("errors", "用户已认证！");
	    }
	    model.addAttribute("userList", users);  
	    model.addAttribute("page", page); 
		
	}

	@Override
	public User selectByUserId(Integer userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}

	@Override
	public Integer updateByUserId(Integer userId,Integer userState) {
		User user = new User();
		user.setUserId(userId);
		user.setUserState(new BigDecimal(userState));
		Integer rtn = userMapper.updateByUserId(user);
		return rtn;
	}

	@Override
	public void showUserByPage1(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");  
		  
	    Page page = null;  
	  
	    List<User> users = new ArrayList<User>();  
	  
	    int totalCount = (int)userMapper.getUserCount();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        users = userMapper.listUser1(page.getStartPos()+1, page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        users = userMapper.listUser1(page.getStartPos(), page.getStartPos()+page.getPageSize());  
	    }  
	  System.out.println(users);
	    model.addAttribute("userList1", users);  
	    model.addAttribute("page", page); 
		
	}

	@Override
	public void selectUserByPage1(String userPhone, HttpServletRequest request, Model model) {
		User user = null;
		user = userMapper.selectByPhone(userPhone);
		if(user == null){
			model.addAttribute("errors", " 用户不存在");
			return ;
		}
		
		
		String pageNow = request.getParameter("pageNow");  
	  
	    Page page = null;  
	  
	    List<User> users = new ArrayList<User>();  
	  
	    int totalCount = (int)userMapper.getUserCount();  
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        users = userMapper.selectUser1(user.getUserId(), page.getStartPos(),page.getStartPos()+page.getPageSize()); 
	    } else {  
	        page = new Page(totalCount, 1);  
	        users = userMapper.selectUser1(user.getUserId(), page.getStartPos(),page.getStartPos()+page.getPageSize());
	    }  
	    System.out.println(users);
	    if(users.size() == 0){
	    	model.addAttribute("errors", "用户未认证！");
	    }
	    model.addAttribute("userList1", users);  
	    model.addAttribute("page", page); 
		
	}

}
