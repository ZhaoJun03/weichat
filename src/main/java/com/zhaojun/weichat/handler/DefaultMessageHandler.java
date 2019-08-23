package com.zhaojun.weichat.handler;

import com.zhaojun.weichat.entity.MessageType;
import com.zhaojun.weichat.handler.event.DefaultEventHandler;
import com.zhaojun.weichat.handler.message.ImageMessageHandler;
import com.zhaojun.weichat.handler.message.TextMessageHandler;
import com.zhaojun.weichat.handler.message.VoiceMessageHandler;

import java.util.Map;

/**
 * @author ZhaoJun
 * @date 2019/8/23 9:53
 */

public class DefaultMessageHandler extends AbstractHandler {

    @Override
    public String handle(Map<String, String> map) {
        String msgType = map.getOrDefault("MsgType", "");
        MessageType messageType = MessageType.ofMsgType(msgType);
        AbstractHandler handler = null;
        switch (messageType) {
            case REQUEST_TEXT:
                handler = new TextMessageHandler();
                break;
            case REQUEST_EVENT:
                handler = new DefaultEventHandler();
                break;
            case REQUEST_IMAGE:
                handler = new ImageMessageHandler();
                break;
            case REQUEST_VOICE:
                handler = new VoiceMessageHandler();
                break;
            default:
                break;
        }
        return handler.handle(map);
    }
}
