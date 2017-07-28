package me.zhangzhen.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;

import me.zhangzhen.domian.UserPlus;
import me.zhangzhen.service.UserServicePlus;
import me.zhangzhen.service.impl.UserServicePlusImpl;
import me.zhangzhen.util.R;

@Controller
public class UserControllerPlus extends BaseController {

    @Autowired
    private UserServicePlus userServicePlusImpl;

    @ResponseBody
    @RequestMapping("/page")
    public Object selectPage(Model model){

        Page page=new Page(1,10);
        page = userServicePlusImpl.selectUserPage(page, "NORMAL");
        return page;
    }
    
    @ResponseBody
    @RequestMapping("/saveUserPlus")
    public Object saveUserPlus(){
    UserPlus userPlus = new UserPlus();	
    	userPlus.setId(new Long(4));
    	userPlus.setName("test4");
    	userPlus.setAge(111);
    	userPlus.setState("Normal");
    	boolean b = userPlus.insert();
    	System.out.println(b);
    	return R.ok();
    }
    
}