package me.zhangzhen.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

import me.zhangzhen.domian.UserPlus;

public interface UserServicePlus {
	 public Page<UserPlus> selectUserPage(Page<UserPlus> page, String state);
	 
	 public List<UserPlus> selectList(Wrapper<UserPlus> ew);
}
