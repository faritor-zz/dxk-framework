package com.demo.service;

import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import com.demo.web.vo.UserVo;
import com.dxk.customercenter.model.User;
import com.dxk.customercenter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dxk on 2016/10/24.
 */
@Service
public class CustomerService {

    @DubboConsumer
    private UserService userService;

    public List<User> getUserList(Integer pageNum, Integer pageSize) {
        Map<String, Integer> params = new HashMap<>();
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        return userService.getUserList(params);
    }

    public User getUserById(Integer id) {
        return userService.getUserById(id);
    }

    public Integer saveUser(UserVo userVo) {
        User user = new User();
        user.setName(userVo.getName());
        user.setAge(userVo.getAge());
        user.setSex(userVo.getSex());
        user.setCreateAt(new Date());
        user.setUpdateAt(new Date());
        user.setEnable(true);
        return userService.saveUser(user);
    }

    public Integer updateUser(UserVo userVo) {
        User user = new User();
        user.setId(userVo.getId());
        user.setName(userVo.getName());
        user.setAge(userVo.getAge());
        user.setSex(userVo.getSex());
        user.setUpdateAt(new Date());
        return userService.updateUser(user);
    }

    public Integer deleteUserById(Integer userId) {
        return userService.deleteUser(userId);
    }

}
