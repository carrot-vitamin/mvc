package com.project.bean.bean;


import com.project.common.entity.YesOrNo;

import java.io.Serializable;

/**
 * Created by yinshaobo on 2018/5/20
 * 邮件信息
 */
public class MailInfo implements Serializable {

    private static final long serialVersionUID = 4962856609116350743L;

    private Long id;
    private String fromUser;// 发件人姓名
    private String fromAddr;// 发件人地址
    private String to;// 收件人地址
    private String cc;// 抄送人地址
    private String subject;// 主题
    private String sendDate;// 发送日期
    private String content;// 正文内容
    private YesOrNo isNeedToRead;// 是否已读
    private YesOrNo containFiles;// 是否包含附件
    private YesOrNo isNeedReply;// 是否需要回执

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getFromAddr() {
        return fromAddr;
    }

    public void setFromAddr(String fromAddr) {
        this.fromAddr = fromAddr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public YesOrNo getIsNeedToRead() {
        return isNeedToRead;
    }

    public void setIsNeedToRead(YesOrNo isNeedToRead) {
        this.isNeedToRead = isNeedToRead;
    }

    public YesOrNo getContainFiles() {
        return containFiles;
    }

    public void setContainFiles(YesOrNo containFiles) {
        this.containFiles = containFiles;
    }

    public YesOrNo getIsNeedReply() {
        return isNeedReply;
    }

    public void setIsNeedReply(YesOrNo isNeedReply) {
        this.isNeedReply = isNeedReply;
    }
}
