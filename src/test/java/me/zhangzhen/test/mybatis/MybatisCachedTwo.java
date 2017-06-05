package me.zhangzhen.test.mybatis;

import org.junit.Test;

/**
 * 手动开启mybatis二级缓存测试
 * 
 * @author dell、
 *
 */
public class MybatisCachedTwo {

	/**
	 * 二级缓存是mapper级别的。Mybatis默认是没有开启二级缓存。
	 * 
	 * 第一次调用mapper下的SQL去查询用户信息。查询到的信息会存到该mapper对应的二级缓存区域内。
	 * 
	 * 第二次调用相同namespace下的mapper映射文件中相同的SQL去查询用户信息。会去对应的二级缓存内取结果。
	 * 
	 * 如果调用相同namespace下的mapper映射文件中的增删改SQL，并执行了commit操作。此时会清空该namespace下的二级缓存。
	 */

	// 查询第一次缓存sql语句和结果，HashMap缓存数据，key为hashcode+statementId+sql语句。Value为查询出来的结果集映射成的java对象
	// 第二次查询直接去缓存中取，如果没有再发送生sql取数据库里拿
	@Test
	public void testSelect() {

	}

	// 增加 清空二级缓存
	@Test
	public void testCreate() {
	}

	// 更新 清空二级缓存
	@Test
	public void testUpdate() {
	}

	// 删除 清空二级缓存
	@Test
	public void testDelete() {
	}
}
