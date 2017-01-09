package com.demo.mapper;

import com.demo.model.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dxk on 2016/11/3.
 */
@Mapper
public interface UserMapper {

    List<User> getUserList();

    User getUserById(@Param("id") Integer id);

    Integer saveUser(@Param("user") User user);

    Integer updateUser(@Param("user") User user);

    Integer deleteUserById(@Param("id") Integer id);

}