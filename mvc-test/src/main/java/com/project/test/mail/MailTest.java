package com.project.test.mail;

import com.alibaba.fastjson.JSON;
import com.project.bean.bean.MailInfo;
import com.project.bean.service.IMailService;
import com.project.common.entity.YesOrNo;
import com.project.test.core.AbstractTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yinshaobo on 2018/5/23
 */
public class MailTest extends AbstractTest {

    @Autowired
    private IMailService mailService;

    @Override
    public void test() throws Exception {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setFromAddr("a");
        mailInfo.setContent("aaa");
        mailInfo.setIsNeedReply(YesOrNo.YES);
        this.mailService.insert(mailInfo);

//        MailInfo mailInfo = this.mailService.selectByPrimaryKey(3l);
        System.out.println(JSON.toJSONString(mailInfo));
    }
}
