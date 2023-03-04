package com.wak.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wak.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wak
 */
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper mapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = mapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("wak");
        user.setAge(21);
        user.setEmail("wak@it.com");

        int count = mapper.insert(user);
        Long id = user.getId();
        System.out.println("受影响行数：" + count);
        System.out.println("自增id：" + id);
    }

    @Test
    public void testDeleteById() {
        int i = mapper.deleteById(6L);
        System.out.println("受影响行数:" + i);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Billie");
        int i = mapper.deleteByMap(map);
        System.out.println("受影响行数:" + i);
    }

    @Test
    public void testDelete() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "Sandy");

        int i = mapper.delete(wrapper);
        System.out.println("受影响行数:" + i);
    }

    @Test
    public void testDeleteBatchIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);

        int i = mapper.deleteBatchIds(ids);
        System.out.println("受影响行数:" + i);
    }

    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(5L);
        user.setName("zs");
        user.setEmail("zs@qq.com");

        int i = mapper.updateById(user);
        System.out.println("受影响行数:" + i);

    }

    @Test
    public void testUpdate() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("name", "zs");
        wrapper.set("age", 18);

        int i = mapper.update(null, wrapper);
        System.out.println("受影响行数:" + i);
    }

    @Test
    public void testSelectById() {
        User user = mapper.selectById(5L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(3L);
        ids.add(5L);

        List<User> users = mapper.selectBatchIds(ids);
        System.out.println(users);
    }

    @Test
    public void testSelectOne() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName, "zs").eq(User::getAge, 18);

        User user = mapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void testSelectCount() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.le(User::getAge, 20);

        Long count = mapper.selectCount(wrapper);
        System.out.println(count);
    }

    @Test
    public void testSelectList() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("age", 18);
        List<User> users = mapper.selectList(wrapper);
        System.out.println(users);
    }

    @Test
    public void testSelectPage() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("age", "18");

        IPage<User> page = new Page<>(1, 2);
        IPage<User> userPage = mapper.selectPage(page, wrapper);

        System.out.println("总条数：" + userPage.getTotal());
        System.out.println("总页数：" + userPage.getPages());
        System.out.println("记录：" + userPage.getRecords());
    }

    @Test
    public void testAllEq() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> params = new HashMap<>();
        params.put("name", "Jone");
        params.put("age", 18);
        params.put("email", null);
        //wrapper.allEq(params);
        //SELECT id,name,age,email FROM user WHERE (name = ? AND age = ? AND email IS NULL)
        wrapper.allEq(params, false);
        //SELECT id,name,age,email FROM user WHERE (name = ? AND age = ?)
        List<User> users = mapper.selectList(wrapper);
        System.out.println(users);
    }

    @Test
    public void testCompare() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "tom").ge("age", 18);

        List<User> users = mapper.selectList(wrapper);
        System.out.println(users);
    }
}
