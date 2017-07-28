package me.zhangzhen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import me.zhangzhen.domian.User;

public interface UserMapper extends BaseMapper<User> {
	
//	@Select("selectList")
	List<User> selectList();
	
}
