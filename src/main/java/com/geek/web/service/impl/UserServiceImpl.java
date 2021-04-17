package com.geek.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geek.web.dao.mapper.UserMapper;
import com.geek.web.model.entity.SysUser;
import com.geek.web.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @description: 用户 Service
 * @author: geek
 * @date 2021/04/16
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {
}
