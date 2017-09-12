package me.zhangzhen.test.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import me.zhangzhen.domian.User;

public class TestCollectionsContainsObject {

	List<Object> users = new ArrayList<>();
	List<User> users2 = new ArrayList<>();

	@Test
	public void testCollectionContainsObject() {
		for (int i = 0; i < 100; i++) {
			users.add(new User(i, "zhangsan" + i, "zhangsan" + i, "zhangsan" + i));
		}
		System.out.println(users);
		for (int i = 0; i < 5; i++) {
			users2.add(new User(i, "zhangsan" + i, "zhangsan" + i, "zhangsan" + i));
		}
		System.out.println(users.contains(new User(2,"zhangsan2","zhangsan2","zhangsan2")));
		users.add(users2);
		System.out.println(users.contains(users2));
	}
}
