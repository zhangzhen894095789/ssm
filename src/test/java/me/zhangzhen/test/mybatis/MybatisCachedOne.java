package me.zhangzhen.test.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
/**
 * mybatis默认开启的一级缓存测试
 */
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import me.zhangzhen.domian.User;
import me.zhangzhen.service.UserService;

public class MybatisCachedOne extends BaseTest {
	
//	@Resource
	@Autowired
	private UserService userService ;
	
	@Before
	public void before(){
		System.out.println("junit执行之前 ---创建userService");
	}
	/**
	 * 一级缓存区域是根据SqlSession为单位划分的。
	 * 
	 * 
	 * 
	 * 每次查询会先去缓存中找，如果找不到，再去数据库查询，然后把结果写到缓存中。Mybatis的内部缓存使用一个HashMap，key为hashcode
	 * +statementId+sql语句。Value为查询出来的结果集映射成的java对象。
	 * 
	 * 
	 * 
	 * SqlSession执行insert、update、delete等操作commit后会清空该SQLSession缓存。
	 */

	// 查询第一次缓存sql语句和结果，HashMap缓存数据，key为hashcode+statementId+sql语句。Value为查询出来的结果集映射成的java对象
	// 第二次查询直接去缓存中取，如果没有再发送生sql取数据库里拿
	@Test
	public void testSelect() {
		List<User> findUsers = userService.findUsers();
		System.out.println("findUsers执行了");
		if (findUsers.size() > 0) {
			System.out.println(findUsers);
		}
	}

	// 增加 清空缓存
	@Test
	public void testCreate() {
	}

	// 更新 清空缓存
	@Test
	public void testUpdate() {
	}

	// 删除 清空缓存
	@Test
	public void testDelete() {
	}

}
