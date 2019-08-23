package com.zhaojun.weichat.handler.message;

import com.zhaojun.weichat.entity.response.Image;
import com.zhaojun.weichat.entity.response.ImageResponse;
import com.zhaojun.weichat.handler.AbstractHandler;

import java.util.Map;

/**
 * @author ZhaoJun
 * @date 2019/8/23 16:55
 */

public class ImageMessageHandler extends AbstractHandler {
    @Override
    public String handle(Map<String, String> map) {
        System.out.println(map);
        ImageResponse imageResponse = new ImageResponse();
        fillBaseData(map, imageResponse);
        Image image = new Image();
        image.setMediaId(map.get("MediaId"));
        imageResponse.setImage(image);
        return convertToString(imageResponse);
    }
}
