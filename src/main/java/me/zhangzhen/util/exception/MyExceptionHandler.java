//package me.zhangzhen.util.exception;
//
//import org.apache.shiro.authz.AuthorizationException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;
//
//import me.zhangzhen.util.R;
//
///**
// * 异常处理器
// * 
// * @author chenshun
// * @email sunlightcs@gmail.com
// * @date 2016年10月27日 下午10:16:19
// */
//@ControllerAdvice
//public class MyExceptionHandler extends DefaultHandlerExceptionResolver {
//	private Logger logger = LoggerFactory.getLogger(getClass());
//
//	/**
//	 * 自定义异常
//	 */
//	@ExceptionHandler(MyException.class)
//	public R handleRRException(MyException e){
//		R r = new R();
//		r.put("code", e.getCode());
//		r.put("msg", e.getMessage());
//
//		return r;
//	}
//
//	@ExceptionHandler(DuplicateKeyException.class)
//	public R handleDuplicateKeyException(DuplicateKeyException e){
//		logger.error(e.getMessage(), e);
//		return R.error("数据库中已存在该记录");
//	}
//
//	@ExceptionHandler(AuthorizationException.class)
//	public R handleAuthorizationException(AuthorizationException e){
//		logger.error(e.getMessage(), e);
//		return R.error("没有权限，请联系管理员授权");
//	}
//
//	@ExceptionHandler(Exception.class)
//	public R handleException(Exception e){
//		logger.error(e.getMessage(), e);
//		return R.error();
//	}
//}
