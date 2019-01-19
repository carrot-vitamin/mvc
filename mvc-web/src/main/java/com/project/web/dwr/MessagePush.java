package com.project.web.dwr;

import com.project.common.entity.Constants;
import com.project.rbac.entity.User;
import org.directwebremoting.Container;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

/**
 * Created by yinshaobo on 2018/5/25
 */
public class MessagePush {

    private static Logger logger = LoggerFactory.getLogger(MessagePush.class);

    static {
        Container container = ServerContextFactory.get().getContainer();
        ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
        ScriptSessionListener listener = new ScriptSessionListener() {
            public void sessionCreated(ScriptSessionEvent ev) {
                HttpSession session = WebContextFactory.get().getSession();
                String userId = ((User) session.getAttribute(Constants.USER_SESSION_KEY)).getId() + "";
                logger.info("a ScriptSession is created!");
                ev.getSession().setAttribute("userId", userId);
            }

            public void sessionDestroyed(ScriptSessionEvent ev) {
                logger.info("a ScriptSession is destroyed");
            }
        };
        manager.addScriptSessionListener(listener);
        logger.info("DWR构造块初始化！");
    }

    public void onPageLoad(String userId) {
        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
        scriptSession.setAttribute(userId, userId);
    }

}
