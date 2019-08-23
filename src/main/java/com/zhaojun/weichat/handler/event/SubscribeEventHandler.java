package com.zhaojun.weichat.handler.event;

import com.zhaojun.weichat.entity.response.TextResponse;
import com.zhaojun.weichat.handler.AbstractHandler;

import java.util.Map;

/**
 * @author ZhaoJun
 * @date 2019/8/23 10:53
 */

public class SubscribeEventHandler extends AbstractHandler {
    @Override
    public String handle(Map<String, String> map) {
        TextResponse textResponse = new TextResponse();
        fillBaseData(map, textResponse);
        textResponse.setContent("想带你去看晴空万里   想大声告诉你我为你着迷~~~~~~~~~~~~~~~ \n欢迎关注  么么哒");
        textResponse.setMsgType("text");
        return convertToString(textResponse);
    }
}
