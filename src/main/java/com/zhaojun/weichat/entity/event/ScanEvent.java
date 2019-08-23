package com.zhaojun.weichat.entity.event;

import lombok.Data;

/**
 * @author ZhaoJun
 * @date 2019/8/22 11:35
 */
@Data
public class ScanEvent extends BaseEvent {
    /**
     * 事件KEY值，
     * qrscene_为前缀，后面为二维码的参数值
     * 用户未关注时，进行关注后的事件推送:用户已关注时的事件推送:是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    private String eventKey;
    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    private String ticket;

}
