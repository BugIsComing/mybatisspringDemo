package com.lc.dao;

import com.lc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author ifly_lc
 */
@Component
public class UserDao {

    @Autowired
    private BaseDao baseDao;

    public UserDao() {
    }

    public UserDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    /**
     * 获取对应条件的记录
     * @param params 查询条件
     * @return 记录表
     */
    public List<User> getUserByParam(Map<String,Object> params){
        //userMapper是userMapper.xml中的namespace
        return baseDao.getList("userMapper.getUserByParam",params);
    }

    /**
     * 插入一条记录
     * @param user 插入对象
     */
    public void saveUser(User user){
        baseDao.save("userMapper.saveUser",user);
    }


}
