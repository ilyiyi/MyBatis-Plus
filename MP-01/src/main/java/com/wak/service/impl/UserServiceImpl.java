package com.wak.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wak.domain.User;
import com.wak.mapper.UserMapper;
import com.wak.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wak
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
