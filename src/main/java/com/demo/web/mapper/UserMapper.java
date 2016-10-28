package com.demo.web.mapper;

import com.demo.web.model.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by dxk on 2016/10/24.
 */
@Mapper
public interface UserMapper {

    User getUserById(@Param("id") Integer id);

}
