package com.demo.mapper;

import com.demo.model.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by dxk on 2016/11/3.
 */
@Mapper
public interface UserMapper {

    User getUserById(@Param("id") Integer id);

}