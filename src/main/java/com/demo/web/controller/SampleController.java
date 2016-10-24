package com.demo.web.controller;

import com.demo.web.constant.Urls;
import com.demo.web.service.Producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by dxk on 2016/10/19.
 */
@Controller
@Api(value = "samples", description = "一些示例")
@RequestMapping(value = Urls.Sample.ROOT)
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private Producer producer;

    @ApiOperation(value = "demo接口 xiaokang", notes = "测试小示例")
    @GetMapping(value = Urls.Sample.DEMO)
    @ResponseBody
    public String demo(@PathVariable String msg) {
        return "hello " + msg;
    }

    @ApiOperation(value = "发送mq接口 xiaokang", notes = "发送mq")
    @GetMapping(value = Urls.Sample.SEND_MQ)
    @ResponseBody
    public String sender() {
        logger.debug("-------------开始发送mq");
        try {
            producer.sender();
            logger.debug("-------------发送mq成功");
            return "ok";
        } catch (Exception e) {
            logger.debug("-------------发送mq失败，错误原因 e：" + e);
        }
        return null;
    }

}
