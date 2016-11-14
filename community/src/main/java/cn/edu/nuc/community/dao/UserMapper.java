package cn.edu.nuc.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.community.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);
    
    User selectByPhone(String userPhone);
    
    User selectByName(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int updateByUserId(User user);
    /**
     * 查询状态为 0的
     * @param startPos
     * @param pageSize
     * @return
     */
    public List<User> listUser(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    public List<User> selectUser(@Param(value="userId") Integer userId,@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    /**
     * 查询状态为1的
     * @param startPos
     * @param pageSize
     * @return
     */
    public List<User> listUser1(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    public List<User> selectUser1(@Param(value="userId") Integer userId,@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);  
      
      
    public long getUserCount(); 
}