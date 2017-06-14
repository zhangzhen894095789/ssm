package me.zhangzhen.service.dwr;

import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.extend.ScriptSessionManager;
import org.directwebremoting.impl.DefaultScriptSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import me.zhangzhen.listener.MyScriptSessionListener;

/**
 * Created by zhangzhen、 on 2017/6/13.
 */
public class MyScriptSeessionManager extends DefaultScriptSessionManager {
    private static final Logger log = LoggerFactory.getLogger(MyScriptSeessionManager.class);
    public MyScriptSeessionManager() {
        //初始化加载脚本session监听器
        this.addScriptSessionListener(new MyScriptSessionListener());
        log.debug("绑定 dwrScriptSessionListener");
    }
}
