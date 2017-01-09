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
        String GET_USER_LIST = "";
        String GET_USER = "/{id}";
        String SAVE_USER = "/save";
        String UPDATE_USER = "/update";
        String DELETE_USER = "/{id}/delete";
    }

}
