package com.zhaojun.weichat.entity.request;

import lombok.Data;

/**
 * 文本消息
 *
 * @author ZhaoJun
 * @date 2019/8/22 10:34
 */
@Data
public class TextRequest extends BaseRequest {

    /**
     * 消息类型，文本为text
     */
    private String msgType = "text";
}
