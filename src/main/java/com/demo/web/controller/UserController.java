package com.demo.web.controller;

import com.demo.web.constant.Urls;
import com.demo.model.User;
import com.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by dxk on 2016/10/24.
 */
@RestController
@Api(value = "user", description = "与用户有关")
@RequestMapping(value = Urls.User.ROOT)
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息接口 xiaokang", notes = "根据用户id获取用户信息")
    @GetMapping(value = Urls.User.GET_USER_BY_ID)
    @ResponseBody
    public User getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return user;
    }

}
