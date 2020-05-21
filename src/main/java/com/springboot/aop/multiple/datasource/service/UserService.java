package com.springboot.aop.multiple.datasource.service;

import com.springboot.aop.multiple.datasource.entity.User;

import java.util.List;

/**
 * 用户操作业务接口
 */
public interface UserService {
    /**
     * 获取所有用户信息
     *
     * @return
     */
    List<User> list();

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User find(Long id);

    /**
     * 插入用户信息
     *
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    int delete(Long id);

}
