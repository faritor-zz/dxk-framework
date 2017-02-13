package com.demo.service;

import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.web.vo.UserVo;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dxk on 2016/10/24.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.getUserList();
    }

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public Integer saveUser(UserVo userVo) {
        User user = new User();
        user.setName(userVo.getName());
        user.setCreateAt(new Date());
        return userMapper.saveUser(user);
    }

    public Integer updateUser(UserVo userVo) {
        User user = new User();
        user.setId(userVo.getId());
        user.setName(userVo.getName());
        user.setCreateAt(new Date());
        return userMapper.updateUser(user);
    }

    public Integer deleteUserById(Integer userId) {
        return userMapper.deleteUserById(userId);
    }

}
