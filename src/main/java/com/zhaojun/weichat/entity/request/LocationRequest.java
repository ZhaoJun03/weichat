package com.zhaojun.weichat.entity.request;

import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 11:13
 */
@Data
public class LocationRequest extends BaseRequest {
    /**
     * 	消息类型，地理位置为location
     */
    private String msgType = "location";
    /**
     * 地理位置维度
     */

    private String locationX;
    /**
     * 地理位置经度
     */
    private String locationY;
    /**
     * 地图缩放大小
     */
    private String scale;
    /**
     * 	地理位置信息
     */
    private String label;
    

}
