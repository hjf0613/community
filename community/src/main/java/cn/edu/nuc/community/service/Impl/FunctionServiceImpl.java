package cn.edu.nuc.community.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.edu.nuc.community.dao.FunctionMapper;
import cn.edu.nuc.community.dto.Page;
import cn.edu.nuc.community.entity.Function;
import cn.edu.nuc.community.service.Interface.FunctionService;

@Service
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	private FunctionMapper functionMapper;
	@Override
	public List<Function> selectFunctionByRoleId(Integer roleId) {
		List<Function> listFunction = null;
		if(roleId == -1){
			listFunction= functionMapper.selectAllFunction();
			
		}else{
			listFunction= functionMapper.selectFunctionByRoleId(new BigDecimal(roleId));
		}
		return listFunction;
	}
	@Override
	public void showFunctionByPage(HttpServletRequest request, Model model) {
		 String pageNow = request.getParameter("pageNow");  
		  
		    Page page = null;  
		  
		    List<Function> function = new ArrayList<Function>();  
		  
		    int totalCount = (int)functionMapper.getFunctionCount();  
		  
		    if (pageNow != null) {  
		        page = new Page(totalCount, Integer.parseInt(pageNow));  
		        function = functionMapper.listFunction(page.getStartPos()+1, page.getStartPos()+page.getPageSize()); 
		    } else {  
		        page = new Page(totalCount, 1);  
		        function = functionMapper.listFunction(page.getStartPos(), page.getStartPos()+page.getPageSize());  
		    }  
		  
		    model.addAttribute("function", function);  
		    model.addAttribute("page", page); 
	}
	@Override
	public void selectFunctionByPage(String funName,HttpServletRequest request, Model model) {
			
			Function function = functionMapper.selectFunctionByName(funName);
			if(function == null){
				model.addAttribute("error", "    查询功能不存在");
				return ;
			}
			System.out.println(function);
			
			String pageNow = request.getParameter("pageNow");  
		  
		    Page page = null;  
		  
		    List<Function> products = new ArrayList<Function>();  
		  
		    int totalCount = (int)functionMapper.getFunctionCount();  
		  
		    if (pageNow != null) {  
		        page = new Page(totalCount, Integer.parseInt(pageNow));  
		        products = functionMapper.selectFunction(function.getFunId(), page.getStartPos(),page.getStartPos()+page.getPageSize()); 
		    } else {  
		        page = new Page(totalCount, 1);  
		        products = functionMapper.selectFunction(function.getFunId(), page.getStartPos(),page.getStartPos()+page.getPageSize());
		    }  
		  
		    model.addAttribute("products", products);  
		    model.addAttribute("page", page); 
		   
	}
	@Override
	public Function detailFunction(Integer funId) {
		Function function = functionMapper.selectByPrimaryKey(funId);
		return function;
	}
	@Override
	public Integer editFunction(Function function,Model model) {
		Integer rtn = functionMapper.updateByPrimaryKey(function);
		if(rtn == 0){
			model.addAttribute("msg", "修改失败");
		}
		return rtn;
	}
	@Override
	public Integer insertFunction(Function function, Model model) {
		Integer rtn = 0;
		rtn = functionMapper.insert(function);
		if(rtn == 0){
			model.addAttribute("msg", "添加失败！");
		}
		return rtn;
	}
	

}
