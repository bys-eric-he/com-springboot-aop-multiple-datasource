package com.springboot.aop.multiple.datasource.service;

import com.springboot.aop.multiple.datasource.annotation.TargetDataSource;
import com.springboot.aop.multiple.datasource.config.DataSourceKey;
import com.springboot.aop.multiple.datasource.entity.User;
import com.springboot.aop.multiple.datasource.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户操作业务实现
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 获取所有用户信息
     *
     * @return
     */
    @TargetDataSource(value = DataSourceKey.SLAVE)
    public List<User> list() {
        List<User> users;
        users = userMapper.list();
        return users;
    }

    /**
     * 插入用户信息
     *
     * @param user
     * @return
     */
    @TargetDataSource(value = DataSourceKey.MASTER)
    public int insert(User user) {
        log.info("插入用户信息:{}", user.toString());
        return userMapper.insert(user);
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @TargetDataSource(value = DataSourceKey.MASTER)
    public int update(User user) {
        log.info("更新用户信息:{}", user.toString());
        return userMapper.update(user);
    }

    /**
     * 根据ID删除用户信息
     *
     * @param id
     * @return
     */
    @TargetDataSource(value = DataSourceKey.MASTER)
    public int delete(Long id) {
        log.info("删除用户 {} 信息", id);
        return userMapper.deleteById(id);
    }

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return
     */
    @TargetDataSource(value = DataSourceKey.SLAVE)
    public User find(Long id) {
        return userMapper.selectById(id);
    }
}
