package com.honor.fly.controller;

import com.honor.fly.service.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/24 9:57
 */
@RestController
public class SendMsgController {
    @Autowired
    SendMessage sendMessage;

    @RequestMapping("/send")
    public void send() {
        sendMessage.sendMsg();
    }
}
