package org.augustus.plus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.augustus.plus.entity.User;
import org.augustus.plus.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author: linyongjin
 * @create: 2020-08-29 15:17:47
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> {
}
