package com.wak.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wak.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.nio.cs.US_ASCII;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wak
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService service;

    @Test
    public void testSaveOrUpdate() {
        User user = new User();
        user.setId(5L);
        user.setName("ls");
        boolean b = service.saveOrUpdate(user);
        System.out.println(b);
    }

    @Test
    public void testDelete() {
        boolean b = service.removeById(5L);
        System.out.println(b);
    }

    @Test
    public void testGet() {
        List<User> users = service.list();
        System.out.println(users);
    }

    @Test
    public void testPage() {
        IPage<User> page = new Page<>(2, 2);
        IPage<User> p = service.page(page, null);
        System.out.println(p.getTotal());
        System.out.println(p.getPages());
        System.out.println(p.getRecords());
    }
}
