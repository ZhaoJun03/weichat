package com.zhaojun.weichat.core;

import com.zhaojun.weichat.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * 监听redis数据过期事件
 *
 * @author ZhaoJun
 * @date 2019/8/23 15:36
 */
@Component
@Slf4j
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Autowired
    private AccessTokenStartUpRunner accessTokenStartUpRunner;

    /**
     * 针对redis数据失效事件，进行处理
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // message.toString()可以获取失效的key
        String expiredKey = message.toString();
        if (expiredKey.startsWith(Constant.WEICHAT_ACCESS_TOKEN_KEY)) {
            try {
                accessTokenStartUpRunner.run();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
