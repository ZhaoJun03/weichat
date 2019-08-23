package com.zhaojun.weichat.entity.response;

import com.zhaojun.weichat.entity.MessageType;
import lombok.Data;

import java.util.List;

/**
 * @author ZhaoJun
 * @date 2019/8/22 14:58
 */
@Data
public class NewsResponse extends BaseResponse {
    private List<Articles> articles;
    private int articleCount;
    @Override
    public String getMsgType() {
        return MessageType.RESPONSE_NEWS.getMsgType();
    }


}
