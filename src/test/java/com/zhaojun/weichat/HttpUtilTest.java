package com.zhaojun.weichat;

import cn.hutool.http.HttpUtil;
import com.zhaojun.weichat.entity.robot.RobotResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author ZhaoJun
 * @date 2019/8/23 9:05
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HttpUtilTest {
    public static final String url = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=";
    public static final String uri = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=";

    @Test
    public void testHuHttpUtil() {
        String msg = null;
        try {
            msg = URLEncoder.encode("我不喜欢你", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String s = HttpUtil.get(url + msg);
        System.out.println(s);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test() {
        String msg = null;
        try {
            msg = URLEncoder.encode("我不喜欢你", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        RobotResponse forEntity = restTemplate.getForObject(url + msg, RobotResponse.class);
        System.out.println(forEntity);
    }
}
