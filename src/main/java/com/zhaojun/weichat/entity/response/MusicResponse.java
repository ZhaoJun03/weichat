package com.zhaojun.weichat.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zhaojun.weichat.common.annotaion.XStreamCDATA;
import com.zhaojun.weichat.entity.MessageType;
import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 14:56
 */
@Data
@XStreamAlias("xml")
public class MusicResponse extends BaseResponse {
    @XStreamAlias("Music")
    @XStreamCDATA
    private Music music;
    @XStreamCDATA
    @XStreamAlias("MsgType")
    private String msgType=MessageType.RESPONSE_MUSIC.getMsgType();
    
}
