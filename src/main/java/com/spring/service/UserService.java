package com.spring.service;

import com.spring.model.User;

import java.util.List;

/**
 * @Author :xiaozou
 * @Date : 2022/3/11- 14:07
 **/
public interface UserService {

    /**
     * 查询所有的用户
     * @return
     */
    List<User> findAllUser();
}
