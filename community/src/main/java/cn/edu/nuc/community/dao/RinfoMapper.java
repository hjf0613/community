package cn.edu.nuc.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.community.entity.Rinfo;

public interface RinfoMapper {
    int deleteByPrimaryKey(Integer rinfoId);

    int insert(Rinfo record);

    int insertSelective(Rinfo record);

    Rinfo selectByPrimaryKey(Integer rinfoId);

    int updateByPrimaryKeySelective(Rinfo record);

    int updateByPrimaryKey(Rinfo record);
    
    public List<Rinfo> listRinfo(@Param(value="leagueId") Integer leagueId,@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    public List<Rinfo> initRinfo(@Param(value="serviceId") Integer serviceId,@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    public long getRinfoCount();
    
    public long getRinfoCountByLeagueId(@Param(value="leagueId") Integer leagueId);
    
    public long getRinfoCountByServiceId(@Param(value="serviceId") Integer serviceId);
}