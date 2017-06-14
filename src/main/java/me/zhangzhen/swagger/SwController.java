package me.zhangzhen.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhangzhen.common.JsonResult;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public JsonResult testIgnoreAuth(HttpServletRequest req,@RequestParam String test) {
		JsonResult result = new JsonResult();
		String _token = req.getParameter("test");
		return result.ok().put("test", _token);
	}
}