package com.zhaojun.weichat.entity.event;

import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 11:21
 */
@Data
public class BaseEvent {
    /**
     * 消息接收者
     */
    private String toUserName;
    /**
     * 消息发送者
     */
    private String fromUserName;
    /**
     * 	消息类型，event
     */
    private String msgType;
    /**
     * 事件类型
     */
    private String event;

}
