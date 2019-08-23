package com.zhaojun.weichat.common.util;

import com.zhaojun.weichat.entity.robot.RobotResponse;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author ZhaoJun
 * @date 2019/8/23 10:11
 */
public class RobotUtil {

    /**
     * 机器人api地址
     */
    private static final String URL = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=";

    private static RestTemplate restTemplate = SpringContextUtil.getBean(RestTemplate.class);

    public static String chat(String msg) {
        try {
            msg = URLEncoder.encode(msg, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        RobotResponse response = restTemplate.getForObject(URL + msg, RobotResponse.class);
        return response.getContent().replaceAll("\\{br}","\n");
    }
}
