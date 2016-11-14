package cn.edu.nuc.community.dao;

import cn.edu.nuc.community.entity.RolesRight;

public interface RolesRightMapper {
    int deleteByPrimaryKey(Integer rolerightId);
    
    int deleteByRoleId(Integer roleId);

    int insert(RolesRight record);

    int insertSelective(RolesRight record);

    RolesRight selectByPrimaryKey(Integer rolerightId);

    int updateByPrimaryKeySelective(RolesRight record);

    int updateByPrimaryKey(RolesRight record);
}