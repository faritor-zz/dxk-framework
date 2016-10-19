package com.demo.web.controller;

import com.demo.web.constant.Urls;
import com.demo.web.service.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dxk on 2016/10/19.
 */
@Controller
@RequestMapping(value = Urls.Sample.ROOT)
public class SampleController {

    @Autowired
    private Producer producer;

    @RequestMapping(value = Urls.Sample.SEND_MQ, method = RequestMethod.GET)
    @ResponseBody
    public String sender() {
        try {
            producer.sender();
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
