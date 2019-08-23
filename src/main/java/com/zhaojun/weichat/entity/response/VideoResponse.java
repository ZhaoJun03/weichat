package com.zhaojun.weichat.entity.response;

import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 14:30
 */
@Data
public class VideoResponse extends BaseResponse {

    private Video video;

    @Override
    public String getMsgType() {
        return null;
    }
}
