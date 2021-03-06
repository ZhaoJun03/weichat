package com.zhaojun.weichat.handler;

import com.zhaojun.weichat.common.util.XmlUtil;
import com.zhaojun.weichat.entity.response.BaseResponse;

import java.util.Map;

/**
 * @author ZhaoJun
 * @date 2019/8/23 9:45
 */

public abstract class AbstractHandler {

    //todo  改成自己的外网地址
    public static final String LOCALHOST = "http://aau8ew.natappfree.cc";

    /**
     * 处理
     *
     * @param map
     * @return
     */
    public abstract String handle(Map<String, String> map);

    /**
     * 填充基本数据
     *
     * @param map
     * @param response
     * @return
     */
    protected BaseResponse fillBaseData(Map<String, String> map, BaseResponse response) {
        response.setCreateTime(System.currentTimeMillis());
        response.setFromUserName(map.get("ToUserName"));
        response.setToUserName(map.get("FromUserName"));
        return response;
    }

    /**
     * 转换为string
     *
     * @param response
     * @return
     */
    protected String convertToString(BaseResponse response) {
        String s = XmlUtil.toXml(response);
        System.out.println(s);
        return s;
    }
}
