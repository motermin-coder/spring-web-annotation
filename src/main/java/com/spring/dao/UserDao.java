package com.spring.dao;

import com.spring.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author :xiaozou
 * @Date : 2022/3/11- 14:05
 **/
@Mapper
public interface UserDao {

    /**
     * 查询所有的用户
     * @return
     */
    List<User> findAllUser();
}
