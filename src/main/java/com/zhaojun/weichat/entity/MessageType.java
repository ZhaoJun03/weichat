package com.zhaojun.weichat.entity;


import java.util.Arrays;

/**
 * 消息类型
 *
 * @author ZhaoJun
 * @date 2019/8/22 14:00
 */
public enum MessageType {
    //类型
    REQUEST_TEXT("text", "文本消息"),
    REQUEST_IMAGE("image", "图片消息"),
    REQUEST_VOICE("voice", "语音消息"),
    REQUEST_VIDEO("video", "视频消息"),
    REQUEST_SHORT_VIDEO("shortvideo", "小视频消息"),
    REQUEST_LOCATION("location", "地理位置消息"),
    REQUEST_LINK("link", "链接信息"),
    REQUEST_EVENT("event", "事件信息"),
    EVENT_SUBSCRIBE("subscribe", "订阅事件"),
    EVENT_UNSUBSCRIBE("unsubscribe", "取消订阅事件"),
    EVENT_SCAN("scan", "用户已关注时的扫描带参数二维码事件"),
    EVENT_LOCATION("location", "地理位置事件"),
    EVENT_CLICK("click", "自定义菜单事件"),
    RESPONSE_TEXT("text", "文本响应"),
    RESPONSE_IMAGE("image", "图片响应"),
    RESPONSE_VOICE("voice", "语言响应"),
    RESPONSE_VIDEO("video", "视频响应"),
    RESPONSE_MUSIC("music", "音乐响应"),
    RESPONSE_NEWS("news", "图文响应")
    ;
    private String msgType;
    private String description;

    MessageType(String msgType, String description) {
        this.msgType = msgType;
        this.description = description;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getDescription() {
        return description;
    }

    public static MessageType ofMsgType(String msgType) {
        MessageType[] values = values();
        return Arrays.stream(values).filter(type -> type.getMsgType().equals(msgType)).findAny().get();
    }
}
