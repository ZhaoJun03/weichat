package com.zhaojun.weichat.entity.event;

/**
 * @author ZhaoJun
 * @date 2019/8/22 11:29
 */

public class ClickEvent extends BaseEvent {
    /**
     * 	事件类型，CLICK
     */
    private String event="CLICK";
    /**
     * 事件KEY值，与自定义菜单接口中KEY值对应
     */
    private String eventKey;

}
