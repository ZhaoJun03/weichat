package com.zhaojun.weichat.entity.response;

import com.zhaojun.weichat.entity.MessageType;
import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 14:56
 */
@Data
public class MusicResponse extends BaseResponse {
    private Music music;
    @Override
    public String getMsgType() {
        return MessageType.RESPONSE_MUSIC.getMsgType();
    }
}
