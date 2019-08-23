package com.zhaojun.weichat.entity.request;

import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 11:04
 */
@Data
public class VoiceRequest extends BaseRequest {
    /**
     * 语音格式，如amr，speex等
     */
    private String format;
    /**
     * 语音消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    private String mediaId;
    /**
     * 语音为voice
     */
    private String msgType = "voice";
    /**
     * 语音识别结果，UTF8编码
     */
    private String recognition;

}
