package com.zhaojun.weichat.handler.event;

import com.zhaojun.weichat.entity.MessageType;
import com.zhaojun.weichat.handler.AbstractHandler;

import java.util.Map;

/**
 * @author ZhaoJun
 * @date 2019/8/23 10:49
 */

public class DefaultEventHandler extends AbstractHandler {
    @Override
    public String handle(Map<String, String> map) {
        String eventType = map.getOrDefault("Event", "");
        MessageType messageType = MessageType.ofMsgType(eventType);
        AbstractHandler handler = null;
        switch (messageType) {
            case EVENT_SUBSCRIBE:
                handler = new SubscribeEventHandler();
                break;
            case EVENT_UNSUBSCRIBE:
                handler = new UnsubscribeEventHandler();
            default:
                break;
        }
        return handler.handle(map);
    }
}
