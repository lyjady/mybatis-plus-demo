package org.augustus.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.augustus.plus.entity.User;
import org.augustus.plus.service.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    @DisplayName("保存用户")
    void saveTest() {
        User user = new User();
        user.setName("凯撒");
        user.setAge(2000);
        user.setEmail("123@roma.com");
        userService.save(user);
    }

    @Test
    @DisplayName("更新用户, 乐观锁")
    public void updateTest() {
        User user = userService.getById(1L);
        user.setUpdateTime(new Date());
        user.setName("拿破仑");
        userService.updateById(user);
    }

    @Test
    @DisplayName("分页测试")
    public void pageTest() {
        Page<User> page = new Page<>(2, 3);
        Page<User> userPage = userService.page(page, null);
        log.info("数据总量: {}", userPage.getTotal());
        log.info("数据: {}", userPage.getRecords());
        log.info("总页数: {}", userPage.getPages());
        log.info("一页的数量: {}", userPage.getSize());
        log.info("是否有上一页: {}, 是否有下一页: {}", userPage.hasPrevious(), userPage.hasNext());
    }

    @Test
    @DisplayName("测试逻辑删除")
    public void deletedTest() {
        userService.removeById(2L);
        List<User> list = userService.list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    @DisplayName("查询测试")
    public void queryTest() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("email", "test1@baomidou.com")
                .between("age", 20, 25)
                .orderByDesc("id")
                .select("id", "name", "age");
        List<User> list = userService.list(wrapper);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
