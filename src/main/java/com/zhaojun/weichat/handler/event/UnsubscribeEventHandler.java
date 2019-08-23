package com.zhaojun.weichat.handler.event;

import com.zhaojun.weichat.entity.response.TextResponse;
import com.zhaojun.weichat.handler.AbstractHandler;

import java.util.Map;

/**
 * @author ZhaoJun
 * @date 2019/8/23 11:18
 */

public class UnsubscribeEventHandler extends AbstractHandler {
    @Override
    public String handle(Map<String, String> map) {
        TextResponse textResponse = new TextResponse();
        fillBaseData(map, textResponse);
        //有什么用嘛 都取消关注了  根本就收不到嘛!!  挽留的机会都不给！！！
        textResponse.setContent("亲，告诉我，我哪里做得不好，我改啊 \n全是我的错\n现在认错有没有用\n" +
                "你说你已经不再爱我\n我带你回忆曾经快乐的时空\n你只是劝我别再执着");
        textResponse.setMsgType("text");
        return convertToString(textResponse);
    }
}
