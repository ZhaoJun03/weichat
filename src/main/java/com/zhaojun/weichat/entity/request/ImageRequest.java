package com.zhaojun.weichat.entity.request;

import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 11:03
 */
@Data
public class ImageRequest extends BaseRequest {

    /**
     * 图片链接（由系统生成）
     */
    private String picUrl;
    /**
     * 消息类型，图片为image
     */
    private String msgType = "image";


}
