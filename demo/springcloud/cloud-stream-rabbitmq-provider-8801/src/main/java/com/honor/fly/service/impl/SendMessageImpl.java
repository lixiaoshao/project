package com.honor.fly.service.impl;

import com.honor.fly.entity.RabbitConstant;
import com.honor.fly.service.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * com.honor.fly.service.impl
 *
 * @author honor-ljp
 * 2023/1/23 20:51
 */
@Component
public class SendMessageImpl implements SendMessage {
    @Autowired
    StreamBridge streamBridge;

    @Override
    public void sendMsg() {
        streamBridge.send(RabbitConstant.BIND_KEY_TEST, "this is a msg!!!" + UUID.randomUUID());
    }
}
