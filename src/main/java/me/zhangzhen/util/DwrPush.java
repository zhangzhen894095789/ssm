package me.zhangzhen.util;
import java.util.Collection;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.annotations.ScriptScope;
import org.directwebremoting.proxy.dwr.Util;
import org.directwebremoting.spring.SpringCreator;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
@Component
@RemoteProxy(name="dwrPush",scope=ScriptScope.APPLICATION)
@SuppressWarnings("deprecation")
public class DwrPush {

    @RemoteMethod
    public static String Send(String msg){
        WebContext webContext = WebContextFactory.get();
//        String currentPage = "/01.jsp";
        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();
        // 构建发送所需的JS脚本
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        // 调用客户端的js脚本函数
        scriptBuffer.appendScript("callback(");
        // 这个msg可以被过滤处理一下，或者做其他的处理操作。这视需求而定。
        scriptBuffer.appendData(msg);
        scriptBuffer.appendScript(")");
        // 为所有的用户服务
        Util util = new Util(sessions);
        util.addScript(scriptBuffer);
        
        return "ok";

    }
    
    class PushThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			
		}}

}
