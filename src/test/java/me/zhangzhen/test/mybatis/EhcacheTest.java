package me.zhangzhen.test.mybatis;

import org.junit.Test;

import me.zhangzhen.util.EhcacheUtil;

public class EhcacheTest extends BaseTest{

	@Test
	public void testGet(){
		EhcacheUtil instance = EhcacheUtil.getInstance();
		//cache缓存的数据是在上下文启动的时候放进去的
		Object object = instance.get("cacheDemo", "zhangsan");
		System.out.println(object);
		instance.remove("cacheDemo", "zhangsan");
		Object object1 = instance.get("cacheDemo", "zhangsan");
		System.out.println("移除缓存数据后：" + object1);
	}
}
