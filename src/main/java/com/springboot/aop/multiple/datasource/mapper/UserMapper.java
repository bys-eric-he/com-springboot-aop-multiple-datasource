package com.springboot.aop.multiple.datasource.mapper;

import com.springboot.aop.multiple.datasource.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User selectById(Long id);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

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
     * 查询所有用户
     *
     * @return
     */
    List<User> list();
}
