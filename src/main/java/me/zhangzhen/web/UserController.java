package me.zhangzhen.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import me.zhangzhen.domian.User;
import me.zhangzhen.mapper.UserMapper;
import me.zhangzhen.util.DwrPush;


@Controller
public class UserController {
	@Autowired
	private UserMapper userMapper;
	
//	@RequestMapping(value = "/findUsers.do",produces = "application/json")
	@RequestMapping(value = "/findUsers")
    @ResponseBody
    public List<User> findUsers(){
		DwrPush.Send("查询用户");
		List<User> findUsers = userMapper.findUsers();
		System.out.println(findUsers);
        return findUsers;
    }
    
//	@RequestMapping(value = "/findUser.do",produces="application/json")
	@RequestMapping(value = "/findUser")
    @ResponseBody
    public User findUser(){
		List<User> findUsers = userMapper.findUsers();
		System.out.println(findUsers);
        return findUsers.get(0);
    }
	
//	@RequestMapping(value = "/zhongwen",produces = "text/json;charset=UTF-8")
	@RequestMapping(value = "/zhongwen")
    @ResponseBody
    public String zhognwen(){
        return "哈哈哈";
    }
	
}
