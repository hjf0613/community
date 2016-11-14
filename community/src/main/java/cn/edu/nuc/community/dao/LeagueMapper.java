package cn.edu.nuc.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.community.entity.League;

public interface LeagueMapper {
    int deleteByPrimaryKey(Integer leagueId);

    int insert(League record);

    int insertSelective(League record);

    League selectByPrimaryKey(Integer leagueId);
    
    League selectByName(String leagueName);
    
    League selectByCompany(String leaguePhone);
    

    int updateByPrimaryKeySelective(League record);

    int updateByPrimaryKey(League record);
    /**
     * 查询状态为 0的
     * @param startPos
     * @param pageSize
     * @return
     */
    public List<League> listLeague(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    public List<League> selectLeague(@Param(value="leagueId") Integer leagueId,@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    /**
     * 查询状态为1的
     * @param startPos
     * @param pageSize
     * @return
     */
    public List<League> listLeague1(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    public List<League> selectLeague1(@Param(value="leagueId") Integer leagueId,@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);  
      
      
    public long getLeagueCount(); 
}