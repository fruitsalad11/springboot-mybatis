package com.fruitsalad.demo;

import com.fruitsalad.demo.common.jdbc.JdbcTemplateConnection;
import com.fruitsalad.demo.model.sys.User;
import com.fruitsalad.demo.service.sys.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private JdbcTemplateConnection jdbcTemplate;

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        jdbcTemplate.getConnection();
    }

    @Test
    public void test1(){
        User user = new User();

        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setUsername("zs");
        user.setPassword("123456");
        userService.insert(user);
    }
}
