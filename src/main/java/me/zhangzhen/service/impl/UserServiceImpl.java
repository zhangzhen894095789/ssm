package me.zhangzhen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import me.zhangzhen.domian.User;
import me.zhangzhen.mapper.UserMapper;
import me.zhangzhen.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> findUsers() {
		// TODO Auto-generated method stub
		// 查询姓名为‘张三’的所有用户记录
		List<User> userList = userMapper.selectList(
		        new EntityWrapper<User>().eq("111", "222")
		);

		return userList;
	}
}
