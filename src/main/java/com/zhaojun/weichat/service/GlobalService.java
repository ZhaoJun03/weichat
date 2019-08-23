package com.zhaojun.weichat.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZhaoJun
 * @date 2019/8/22 10:19
 */

public interface GlobalService {

    /**
     * 校验是否来自微信服务器
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    String check(String signature, String timestamp, String nonce, String echostr);

    /**
     * 消息处理
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @param request
     * @return
     */
    String post(String signature, String timestamp, String nonce, String echostr, HttpServletRequest request);

}
