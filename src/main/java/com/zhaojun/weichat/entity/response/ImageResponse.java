package com.zhaojun.weichat.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zhaojun.weichat.common.annotaion.XStreamCDATA;
import com.zhaojun.weichat.entity.MessageType;
import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 14:24
 */
@Data
@XStreamAlias("xml")
public class ImageResponse extends BaseResponse {
    @XStreamAlias("Image")
    private Image image;
    @XStreamCDATA
    @XStreamAlias("MsgType")
    private String msgType = MessageType.RESPONSE_IMAGE.getMsgType();
    @Override
    public String getMsgType() {
        return MessageType.RESPONSE_IMAGE.getMsgType();
    }
}
