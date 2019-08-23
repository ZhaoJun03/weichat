package com.zhaojun.weichat.handler.message;

import com.zhaojun.weichat.entity.response.Image;
import com.zhaojun.weichat.entity.response.ImageResponse;
import com.zhaojun.weichat.entity.response.TextResponse;
import com.zhaojun.weichat.common.util.RobotUtil;
import com.zhaojun.weichat.handler.AbstractHandler;

import java.util.Map;

/**
 * @author ZhaoJun
 * @date 2019/8/23 9:51
 */

public class TextMessageHandler extends AbstractHandler {
    @Override
    public String handle(Map<String, String> map) {
        String content = map.get("Content");
        TextResponse textResponse = new TextResponse();
        fillBaseData(map, textResponse);
        String responseContent = "";
        switch (content) {
            case "我喜欢你":
                responseContent = "我也喜欢你！";
                break;
            case "微信":
                responseContent = "什么？你要我微信？？\n那我就告诉你嘛：13320984070";
                break;
            case "图片":
                ImageResponse imageResponse = new ImageResponse();
                fillBaseData(map, imageResponse);
                Image image = new Image();
                image.setMediaId("quYTl5ryOBMC0cYS0dP72sj8UT2slQGV-l2Rm5yEitNxa5TWNHOIkWXFI9_MqgOP");
                imageResponse.setImage(image);
                return convertToString(imageResponse);
            default:
                responseContent = RobotUtil.chat(content);
        }
        textResponse.setContent(responseContent);
        return convertToString(textResponse);
    }
}
