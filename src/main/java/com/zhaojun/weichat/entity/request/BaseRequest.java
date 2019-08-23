package com.zhaojun.weichat.entity.request;

import lombok.Data;

/**
 * 消息实体基类
 *
 * @author ZhaoJun
 * @date 2019/8/22 10:28
 */
@Data
public class BaseRequest {
    /**
     * 消息接收者
     */
    private String toUserName;
    /**
     * 消息发送者
     */
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private long createTime;
    /**
     * 消息id，64位整型，公众平台为记录识别该消息的一个标记数值, 微信后台系统自动产生
     */
    private long msgId;
    /**
     * 消息类型
     */
    private String msgType;

}
