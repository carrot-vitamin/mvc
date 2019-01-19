package com.project.common.dwr;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by yinshaobo on 2018/5/25
 */
@Component
public class DwrHelper {

    public void sendMessageAuto(String userid, String message) {
        final String userId = userid;
        final String autoMessage = message;
        ScriptBuffer script = new ScriptBuffer();
        Browser.withAllSessionsFiltered(session -> {
            if (session.getAttribute("userId") == null) return false;
            else return (session.getAttribute("userId")).equals(userId);
        }, () -> {
            script.appendCall("showMessage", autoMessage);
            Collection<ScriptSession> sessions = Browser.getTargetSessions();
            for (ScriptSession scriptSession : sessions) {
                scriptSession.addScript(script);
            }
        });
    }
}
