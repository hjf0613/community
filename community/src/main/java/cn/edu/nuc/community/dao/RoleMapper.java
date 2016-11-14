package cn.edu.nuc.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.community.entity.Role;


public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);
    
    Role selectRoleByName(String roleName);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    public List<Role> listRole(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    public List<Role> selectRole(@Param(value="roleId") Integer roleId,@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);  
      
    public long getRoleCount(); 
}