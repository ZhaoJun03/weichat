package com.zhaojun.weichat.handler.message;

import com.zhaojun.weichat.entity.response.Voice;
import com.zhaojun.weichat.entity.response.VoiceResponse;
import com.zhaojun.weichat.handler.AbstractHandler;

import java.util.Map;

/**
 * @author ZhaoJun
 * @date 2019/8/23 17:00
 */

public class VoiceMessageHandler extends AbstractHandler {
    @Override
    public String handle(Map<String, String> map) {
        System.out.println(map);
        VoiceResponse voiceResponse = new VoiceResponse();
        fillBaseData(map, voiceResponse);
        Voice voice = new Voice();
        voice.setMediaId(map.get("MediaId"));
        voiceResponse.setVoice(voice);
        return convertToString(voiceResponse);
    }
}
