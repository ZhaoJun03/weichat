package com.zhaojun.weichat.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zhaojun.weichat.common.annotaion.XStreamCDATA;
import com.zhaojun.weichat.entity.MessageType;
import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 14:27
 */
@Data
@XStreamAlias("xml")
public class VoiceResponse extends BaseResponse {
    @XStreamAlias("Voice")
    @XStreamCDATA
    private Voice voice;

    @XStreamCDATA
    @XStreamAlias("MsgType")
    private String msgType = MessageType.RESPONSE_VOICE.getMsgType();

}
