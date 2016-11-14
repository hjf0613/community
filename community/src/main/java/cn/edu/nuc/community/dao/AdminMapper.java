package cn.edu.nuc.community.dao;

import cn.edu.nuc.community.entity.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);
    
    Admin selectByName(String adminName);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    int updateByAdminName(Admin admin);
}