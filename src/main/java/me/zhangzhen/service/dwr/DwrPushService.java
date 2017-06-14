package me.zhangzhen.service.dwr;

import java.util.Collection;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.shiro.SecurityUtils;
import org.directwebremoting.*;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.annotations.ScriptScope;
import org.directwebremoting.proxy.dwr.Util;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import me.zhangzhen.domian.User;
import me.zhangzhen.listener.MyScriptSessionListener;

/**
 * 提供消息推送服务 dwrPushService
 *
 * @Author zhangzhen
 */
@Service
public class DwrPushService {

    public static String test(String msg) {
        //从scriptSessionListener中获取scriptionSession
        Collection<ScriptSession> sessions = MyScriptSessionListener.getScriptionSessions();
        // 构建发送所需的JS脚本
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // 调用客户端的js脚本函数
//        scriptBuffer.appendScript("callback(");
//        scriptBuffer.appendData(msg);
//        scriptBuffer.appendScript(")");
        scriptBuffer.appendCall("callback", msg);
        // 为所有的用户服务
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);
        return "ok";
    }

    /**
     * 获取当前脚本session 设置属性
     *
     * @param userId
     */
    public static void onPageLoad(String userId) {
        //获取当前的scriptSsession设置属性
        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
        scriptSession.setAttribute(userId, userId);
    }

    /**
     * 匹配指定用户推送消息
     *
     * @param userid
     * @param message
     * @return
     */
    public static void sendMessageAuto(String userid, String message) {
        final String userId = userid;
        final String autoMessage = message;

        Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
            Collection<User> allLoginUser = MyScriptSessionListener.getAllLoginUser();
            public boolean match(ScriptSession session) {
                if (session.getAttribute("admin") == null)//此处根据需求可以改
                    return false;
                else
                    return (session.getAttribute("admin")).equals(userId);
//                for (User u : allLoginUser) {
//                        if (u.getUserName().equals("admin") || u.getUserName().equals("test001"))
//                            return true;
//                        else continue;
//                }
//                return false;
            }
        }, new Runnable() {
            private ScriptBuffer script = new ScriptBuffer();
//            volatile int a ;//保证线程内存中的值是从主内存中拿到的最新的，如果线程同时都读取最新的修改后放回住内存还是会出现并发修改错误
//            ReentrantLock reentrantLock = new ReentrantLock();//互斥锁
//            ReadWriteLock readWriteLock = new ReentrantReadWriteLock();//读写锁
            public synchronized void run() {
//                String username = (String) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USERNAME);
                script.appendCall("callback","刚刚进行了：" + autoMessage );
                Collection<ScriptSession> sessions = MyScriptSessionListener.getScriptionSessions();
                for (ScriptSession scriptSession : sessions) {
                    scriptSession.addScript(script);
                }
            }
        });
    }
}
