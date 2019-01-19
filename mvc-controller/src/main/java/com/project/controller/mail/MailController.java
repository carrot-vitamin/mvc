package com.project.controller.mail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yinshaobo on 2018/5/23
 */
@Controller
@RequestMapping(value = "/mail")
public class MailController {

    @GetMapping(value = "/input")
    public String receiveMailView() {
        return "mail/mailbox";
    }

    @GetMapping(value = "/output")
    public String writeMailView() {
        return "mail/writemail";
    }
}
