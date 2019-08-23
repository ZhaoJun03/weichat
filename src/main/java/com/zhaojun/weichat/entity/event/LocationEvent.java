package com.zhaojun.weichat.entity.event;

/**
 * @author ZhaoJun
 * @date 2019/8/22 11:27
 */

public class LocationEvent extends BaseEvent {
    /**
     * 事件类型，LOCATION
     */
    private String event = "LOCATION";
    /**
     * 地理位置纬度
     */
    private String latitude;
    /**
     * 	地理位置经度
     */
    private String longitude;
    /**
     * 地理位置精度
     */
    private String precision;

    
}
