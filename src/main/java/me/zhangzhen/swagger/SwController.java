package me.zhangzhen.swagger;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhangzhen.common.JsonResult;
import me.zhangzhen.domian.User;

@Api(value = "api")
@Controller
@RequestMapping("/api")
public class SwController {

//	@Autowired
//	private HttpServletResponse response;
//
//	@Autowired
//	private HttpServletRequest request;

	private static final Logger log = Logger.getLogger(SwController.class);
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "测试方法", httpMethod = "POST")
	public JsonResult testIgnoreAuth(HttpServletRequest req,@RequestParam String test,@RequestBody User user) {
		user.setId(2);
		user.setUserName("test");
		user.setPassword("test");
		user.setGender("test");
		JsonResult result = new JsonResult();
		String _token = req.getParameter("test");
		return result.ok().put("test", _token).put("user", user);
	}
}