package me.zhangzhen.test.mybatis.plus;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import me.zhangzhen.domian.UserPlus;
import me.zhangzhen.service.UserServicePlus;
import me.zhangzhen.test.mybatis.BaseTest;

@SuppressWarnings("unchecked")
public class MybatisPlus extends BaseTest {
	
	@Autowired
	private UserServicePlus userServicePlusImpl;

	@Test//测试mybatis-plus核心之三条件构造器
	public void test(){
	       EntityWrapper ew=new EntityWrapper();
	       ew.setEntity(new UserPlus());
	       String name="test";
	       Integer age=16;
	       ew.like("name", name ).and(" age > {0} ", age );
	       List<UserPlus> result = userServicePlusImpl.selectList(ew);
	       
	       System.out.println(result.size());
	    }
}
