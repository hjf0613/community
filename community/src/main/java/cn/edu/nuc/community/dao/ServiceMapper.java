package cn.edu.nuc.community.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.community.entity.Services;


public interface ServiceMapper {
    int deleteByPrimaryKey(Integer serviceId);

    int insert(Services record);

    int insertSelective(Services record);

    Services selectByPrimaryKey(Integer serviceId);
    
    Services selectByServiceName(String serviceName);

    int updateByPrimaryKeySelective(Services record);

    int updateByPrimaryKey(Services record);
    
    List<Services> listService(BigDecimal servicePid);
    
    /**
     * 查询生活服务，PID为1
     * @param startPos
     * @param pageSize
     * @return
     */
    public List<Services> listLifeService(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    public List<Services> selectLifeService(@Param(value="serviceId") Integer serviceId,@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
      
    /**
     * 查询金融服务，PID为2
     * @param startPos
     * @param pageSize
     * @return
     */
    public List<Services> listFinanceService(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    public List<Services> selectFinanceService(@Param(value="serviceId") Integer serviceId,@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    
    public long getServiceCount1(); 
    public long getServiceCount2(); 
}