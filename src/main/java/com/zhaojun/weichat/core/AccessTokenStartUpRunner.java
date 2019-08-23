package com.zhaojun.weichat.core;

import com.zhaojun.weichat.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 启动时将微信accessToken保存如redis
 * 再注册一个监听器，token失效时候再获取一个
 *
 * @author ZhaoJun
 * @date 2019/8/23 15:19
 */
@Component
@Slf4j
public class AccessTokenStartUpRunner implements CommandLineRunner {
    private static final String URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={1}&secret={2}";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${weichat.appId}")
    private String appId;
    @Value("${weichat.appSecret}")
    private String appSecret;
    @Override
    public void run(String... args) throws Exception {
        //返回的对象是LinkedHashMap
        Object forObject = restTemplate.getForObject(URL, Object.class, appId, appSecret);
        Map<String, Object> map = (Map<String, Object>) forObject;
        String accessToken = (String) map.get("access_token");
        Integer expiresIn = (Integer) map.get("expires_in");
        stringRedisTemplate.opsForValue().set(Constant.WEICHAT_ACCESS_TOKEN_KEY, accessToken, expiresIn, TimeUnit.SECONDS);
        log.info("保存AccessToken: {},有效时间： {}秒", accessToken, expiresIn);
    }
}
