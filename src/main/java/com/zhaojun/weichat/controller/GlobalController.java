package com.zhaojun.weichat.controller;

import com.zhaojun.weichat.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZhaoJun
 * @date 2019/8/22 10:18
 */
@RestController
@RequestMapping
public class GlobalController {

    @Autowired
    private GlobalService globalService;

    @PostMapping
    public String post(String signature, String timestamp, String nonce, String echostr, HttpServletRequest request, HttpServletResponse response) {
        return globalService.post(signature, timestamp, nonce, echostr, request);
    }

    @GetMapping
    public String get(String signature, String timestamp, String nonce, String echostr) {
        return globalService.check(signature, timestamp, nonce, echostr);
    }
}
