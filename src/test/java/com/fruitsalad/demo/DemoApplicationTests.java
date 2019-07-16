package com.fruitsalad.demo;

import com.fruitsalad.demo.common.jdbc.JdbcTemplateConnection;
import com.fruitsalad.demo.model.sys.User;
import com.fruitsalad.demo.service.sys.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
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
    public void testSelect(){
        PageHelper.startPage(1,5);
        User user = new User();
        user.setPassword("12345");
        List<User> list = userService.selectList(user);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        System.out.println("總數量：" + pageInfo.getTotal());
        System.out.println("數量：" + pageInfo.getSize());
        System.out.println("頁數：" + pageInfo.getPages());
        System.out.println("是否最後一頁：" + (pageInfo.isIsLastPage() ? "是" : "不是"));
        List<User> userList = pageInfo.getList();
        for (User user1:
             userList) {
            System.out.println(user1);
        }
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setUsername("wuba");
        user.setPassword("123456");
        userService.insert(user);
    }
}
