package cn.edu.nuc.community.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.community.entity.Function;

public interface FunctionMapper {
    int deleteByPrimaryKey(Integer funId);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Integer funId);
    
    List<Function> selectAllFunction();
    
    List<Function> selectFunctionByRoleId(@Param(value="roleId") BigDecimal roleId);
    
    List<Function> selectFunByRoleId(@Param(value="roleId") BigDecimal roleId);
    
    Function selectFunctionByName(String funName);
    

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
     
    public List<Function> listFunction(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    public List<Function> selectFunction(@Param(value="funId") Integer funId,@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);  
      
    public long getFunctionCount(); 
}