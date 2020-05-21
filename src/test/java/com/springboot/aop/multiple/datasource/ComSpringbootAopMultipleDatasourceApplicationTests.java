package com.springboot.aop.multiple.datasource;

import com.springboot.aop.multiple.datasource.entity.User;
import com.springboot.aop.multiple.datasource.service.UserService;
import com.springboot.aop.multiple.datasource.utils.GenerateID;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class ComSpringbootAopMultipleDatasourceApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void insertUser() {

        User user = new User();
        user.setUserId(GenerateID.getGeneratID());
        user.setUserName("heyong");
        user.setUserPhone("13682385900");
        user.setAddress("中国深圳市南山区高新科技南12路长虹科技大厦15楼03室");
        user.setWeight(1);
        userService.insert(user);
    }


    @Test
    void updateUser() {
        User user = new User();
        user.setUserId(2020052111130L);
        user.setUserName("eric.he");
        user.setUserPhone("13682385900");
        user.setAddress("中国.深圳市南山区高新科技南12路.长虹科技大厦15楼03室");
        user.setWeight(1);
        userService.update(user);
    }

    @Test
    void delete(){
        userService.delete(2020052111130L);
    }

    @Test
    void list() {
        List<User> users = userService.list();
        log.info("----------------------------------------------------------------------");
        for (User user:users){
            log.info(user.toString());
        }
        log.info("----------------------------------------------------------------------");
    }
}
