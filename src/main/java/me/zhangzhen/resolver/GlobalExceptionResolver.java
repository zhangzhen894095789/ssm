package me.zhangzhen.resolver;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.alibaba.fastjson.JSONObject;

import me.zhangzhen.util.R;
/**
 * spring mvc全局异常处理 @ControllerAdvice注解 被mvc扫描到 该注解下的类 @ExceptiionHandler 说明被拦截的异常 方法内 对拦截到的异常进行处理
 * @author dell、
 *
 */
@ControllerAdvice
public class GlobalExceptionResolver extends DefaultHandlerExceptionResolver {

	  @ExceptionHandler(value = Exception.class)
	    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	        String url = request.getServletPath();
	        if (url.startsWith("/")) {
	            if (ex instanceof HttpRequestMethodNotSupportedException) {
	                setResponseParam(response, 405, "请求方式错误！",ex);
	                return null;
	            }

	            if (ex instanceof MissingServletRequestParameterException) {
	                setResponseParam(response, 400, "错误请求！",ex);
	                return null;
	            }

	            if (ex instanceof NoHandlerFoundException) {
	                setResponseParam(response, 404, "请求路径错误！",ex);
	                return null;
	            }
	            if (ex instanceof DuplicateKeyException) {
	                setResponseParam(response, -1, "数据库已存在改记录！",ex);
	                return null;
	            }
	            /*if (ex instanceof ArrayIndexOutOfBoundsException) {
	            	setResponseParam(response, 001, "数组越界！");
	            	return null;
	            }
	            
	            if (ex instanceof NullPointerException) {
	            	setResponseParam(response, 002, "缺少参数！");
	            	return null;
	            }*/
	            
	            setResponseParam(response, 500, "服务器内部错误！服务暂时不可用！",ex);
	            return null;
	        }

	        return super.doResolveException(request, response, handler, ex);
	    }

	    private void setResponseParam(HttpServletResponse response, int code, String msg,Exception ex) throws IOException {
	      
	        response.setContentType("application/json");
	        response.setCharacterEncoding("utf-8");
	        response.getWriter().print(JSONObject.toJSONString(R.error(code, msg)));
	        ex.printStackTrace();
	    }
	}
