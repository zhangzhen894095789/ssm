package me.zhangzhen.mapper;

import java.util.List;

import me.zhangzhen.domian.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
	
	List<User> findUsers();
	
	int createUser(User user);
	
	int updateUser(User user);
	
	int deleteUserById(Integer id);
}
