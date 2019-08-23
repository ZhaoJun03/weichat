package com.zhaojun.weichat.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zhaojun.weichat.common.annotaion.XStreamCDATA;
import com.zhaojun.weichat.entity.MessageType;
import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 13:58
 */
@XStreamAlias("xml")
@Data
public class TextResponse extends BaseResponse {
    @XStreamAlias("Content")
    @XStreamCDATA
    private String content;
    @XStreamCDATA
    @XStreamAlias("MsgType")
    private String msgType = MessageType.RESPONSE_TEXT.getMsgType();
    
}
