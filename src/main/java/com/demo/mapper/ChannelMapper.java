package com.demo.mapper;

import com.demo.model.Channel;
import com.demo.model.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dxk on 2016/11/3.
 */
@Mapper
public interface ChannelMapper {

    Integer saveChannel(@Param("channel") Channel channel);

}