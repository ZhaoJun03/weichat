package com.zhaojun.weichat.entity.request;

/**
 * @author ZhaoJun
 * @date 2019/8/22 11:10
 */

public class VideoRequest extends BaseRequest {

    /**
     * 消息类型 视频为video
     */
    private String msgType = "video";
    /**
     * 视频消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    private String mediaId;
    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String thumbMediaId;


}
