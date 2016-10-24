package com.demo.web.mapper;

import com.demo.web.model.User;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by dxk on 2016/10/24.
 */
@MapperScan
public interface UserMapper {

    User getUserById(@Param("id") Integer id);

}
