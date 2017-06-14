package me.zhangzhen.aop;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import me.zhangzhen.annotation.SysLog;
import me.zhangzhen.domian.User;
import me.zhangzhen.domian.system.SysLogEntity;
import me.zhangzhen.util.HttpContextUtils;
import me.zhangzhen.util.IPUtils;
import me.zhangzhen.web.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志，切面处理类 直接在所需要的方法上添加@SysLog注解即可使用切面保存调用方法的参数返回值等信息
 *
 * @author zhangzhen
 */
@Aspect
@Component
public class SysLogAspect extends BaseController {
	// @Autowired
	// private SysLogMapper sysLogMapper;

	@Pointcut("@annotation(com.fh.annotation.SysLog)")
	public void logPointCut() {

	}

	@Around(value = "logPointCut()")
	public Object saveSysLog(ProceedingJoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysLogEntity sysLog = new SysLogEntity();
		SysLog syslog = method.getAnnotation(SysLog.class);
		if (syslog != null) {
			// 注解上的描述
			sysLog.setOperation(syslog.value());
		}
		// 请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");

		// 请求的参数
		Object[] args = joinPoint.getArgs();
		// 请求参数名称
		String[] parameterNames = signature.getParameterNames();

		// String params = JSON.toJSONString(args[0]);
		StringBuilder params = new StringBuilder();
		if (parameterNames != null && args != null) {
			// 拼接参数名称和参数值
			for (int i = 0; i < parameterNames.length; i++) {
				params.append(parameterNames[i]).append("=").append(args[i]).append(" ");
			}
		}
		sysLog.setParams(params.toString());
		// 获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		// 设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request));
		// 用户名
		// String username = ShiroUtils.getUserEntity().getUSERNAME();
		String url = request.getServletPath();
		if (url.startsWith("/api")) {
			sysLog.setUsername(IPUtils.getIpAddr(request));
		} else {
			Session session = SecurityUtils.getSubject().getSession();
			// User currentUser =
			// (User)session.getAttribute(Const.SESSION_USER);
			// sysLog.setUsername(currentUser.getUSERNAME());
		}
		sysLog.setCreateDate(new Date());
		// 方法返回值
		Object r = null;
		try {
			r = joinPoint.proceed();
			String result = JSON.toJSON(r).toString();
			sysLog.setResult(result);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			logger.error("获取返回值异常！");
		}
		// 保存系统日志
		// sysLogMapper.save(sysLog);
		// System.out.println(sysLog);
		return r;
	}

}
