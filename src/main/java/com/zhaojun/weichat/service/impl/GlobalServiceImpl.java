package com.zhaojun.weichat.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.zhaojun.weichat.handler.DefaultMessageHandler;
import com.zhaojun.weichat.service.GlobalService;
import com.zhaojun.weichat.common.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author ZhaoJun
 * @date 2019/8/22 10:21
 */
@Service
public class GlobalServiceImpl implements GlobalService {
    @Value("${weichat.check.token}")
    private String token;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String check(String signature, String timestamp, String nonce, String echostr) {
        boolean checkIsFromWeiChat = checkIsFromWeiChat(signature, timestamp, nonce, echostr);
        return checkIsFromWeiChat ? echostr : "";
    }

    @Override
    public String post(String signature, String timestamp, String nonce, String echostr, HttpServletRequest request) {
        boolean checkIsFromWeiChat = checkIsFromWeiChat(signature, timestamp, nonce, echostr);
        if (!checkIsFromWeiChat) {
            return "";
        }
        Map<String, String> map = XmlUtil.parseXml(request);
        DefaultMessageHandler defaultMessageHandler = new DefaultMessageHandler();
        return defaultMessageHandler.handle(map);
    }

    private boolean checkIsFromWeiChat(String signature, String timestamp, String nonce, String echostr) {
        List<String> list = new ArrayList<>();
        list.add(token);
        list.add(timestamp);
        list.add(nonce);
        Collections.sort(list);
        String s = DigestUtil.sha1Hex(list.get(0) + list.get(1) + list.get(2));
        return Objects.equals(s, signature);
    }
}
