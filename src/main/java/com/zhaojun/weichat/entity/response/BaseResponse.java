package com.zhaojun.weichat.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zhaojun.weichat.common.annotaion.XStreamCDATA;
import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 13:55
 */
@Data
public abstract class BaseResponse {
    /**
     * 接收方
     */
    @XStreamAlias("ToUserName")
    @XStreamCDATA
    private String toUserName;
    /**
     * 发送方
     */
    @XStreamAlias("FromUserName")
    @XStreamCDATA
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    @XStreamAlias("CreateTime")
    private long createTime;

    /**
     * 获取消息类型
     * @return
     */
    public abstract String getMsgType();
}
