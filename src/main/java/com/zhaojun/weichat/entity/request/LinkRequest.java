package com.zhaojun.weichat.entity.request;

import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 11:16
 */
@Data
public class LinkRequest extends BaseRequest {
    /**
     * MsgType	消息类型，链接为link
     */
    private String msgType = "link";
    /**
     * 	消息标题
     */
    private String title;
    /**
     * 	消息描述
     */
    private String description;
    /**
     * 	消息链接
     */
    private String url;
    
    
}
