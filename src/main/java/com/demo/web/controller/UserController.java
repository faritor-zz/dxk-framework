package com.demo.web.controller;

import com.demo.web.constant.Urls;
import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.web.vo.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by dxk on 2016/10/24.
 */
@RestController
@Api(value = "user", description = "与用户有关")
@RequestMapping(Urls.User.ROOT)
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户列表接口 xiaokang", notes = "获取用户列表信息")
    @GetMapping(Urls.User.GET_USER_LIST)
    @ResponseBody
    public List<User> getUserList(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize) {
        return userService.getUserList(pageNum, pageSize);
    }

    @ApiOperation(value = "查询用户详情接口", notes = "根据用户id获取用户信息")
    @GetMapping(Urls.User.GET_USER)
    @ResponseBody
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @ApiOperation(value = "保存用户接口", notes = "保存用户信息")
    @PostMapping(value = Urls.User.SAVE_USER)
    public Integer saveUser(@RequestBody UserVo userVo) {
        if (userVo == null) {
            return null;
        }
        return userService.saveUser(userVo);
    }

    @ApiOperation(value = "更新用户接口", notes = "更新用户信息")
    @PutMapping(Urls.User.UPDATE_USER)
    public Integer updateUser(@RequestBody UserVo userVo) {
        if (userVo == null || userVo.getId() == null) {
            return null;
        }
        return userService.updateUser(userVo);
    }

    @ApiOperation(value = "删除用户接口", notes = "根据id删除用户")
    @DeleteMapping(Urls.User.DELETE_USER)
    public Integer deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }

}
