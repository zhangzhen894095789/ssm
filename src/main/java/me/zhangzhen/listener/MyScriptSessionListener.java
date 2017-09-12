package me.zhangzhen.listener;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.directwebremoting.*;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import me.zhangzhen.domian.User;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangzhen、 on 2017/6/13.
 *
 * dwr scriptSessiion监听器
 * scriptSession 维护优化
 */
public class MyScriptSessionListener implements ScriptSessionListener {
    private static final Logger log = LoggerFactory.getLogger(MyScriptSessionListener.class);
    //客户端每次请求都会创建一个scriptionSession但是，每次请求页面的httpSession只有一个，除非浏览器关闭，重新创建httsession
    //创建一个map来维护scriptionSession，所有的session从scriptSession的监听器中获取
    private static final Map<String, ScriptSession> scriptSessionMap = new ConcurrentHashMap<>();
    private static final Map<String,User> userMap = new ConcurrentHashMap<>();

    @Override
    public void sessionCreated(ScriptSessionEvent ev) {
        log.debug("scriptSessionListener 监听到scriptsession创建");
        //httpsession sessionId 作为key  scriptionSession 作为value
        HttpSession httpSession = WebContextFactory.get().getSession();
//        User currentUser = (User)httpSession.getAttribute(Const.SESSION_USER);
        scriptSessionMap.put(httpSession.getId(), ev.getSession());
//        userMap.put(currentUser.getUSER_ID(),currentUser);
//        log.debug("当前登录用户： " + WebContextFactory.get().getSession().getAttribute(Const.SESSION_USERNAME));
//        log.debug("当前用户信息： " + WebContextFactory.get().getSession().getAttribute(Const.SESSION_USER));
        log.debug("scriptSessionMap的大小：" + scriptSessionMap.size());
        log.debug("当前登陆的用户数： " + userMap.size());
    }

    @Override
    public void sessionDestroyed(ScriptSessionEvent ev) {
        log.debug("scriptionSessionListenner 监听到scriptsession销毁");
        //销毁时从map中移除 scriptSessionTimeout 默认30mins
        scriptSessionMap.remove(WebContextFactory.get().getSession().getId());
//        userMap.remove(((User)WebContextFactory.get().getSession().getAttribute(Const.SESSION_USER)).getUSER_ID());
        log.debug("从维护sessionMap中移除后的大小： " + scriptSessionMap.size());
        log.debug("当前登陆的用户数： " + userMap.size());
    }

    /**
     * 获取所有的scriptionSession
     *
     * @return
     */
    public static Collection<ScriptSession> getScriptionSessions() {
        return scriptSessionMap.values();
    }

    /**
     * 获取所有的登陆用户
     */
    public static Collection<User> getAllLoginUser(){
        return userMap.values();
    }
}
