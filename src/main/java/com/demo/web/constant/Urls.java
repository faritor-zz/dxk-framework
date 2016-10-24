package com.demo.web.constant;

/**
 * Created by dxk on 2016/10/19.
 */
public interface Urls {

    interface Sample {
        String ROOT = "/sample";
        String DEMO = "/demo/{msg}";
        String SEND_MQ = "/send";
    }

    interface User {
        String ROOT = "/user";
        String GET_USER_BY_ID = "/{id}";
    }

}
