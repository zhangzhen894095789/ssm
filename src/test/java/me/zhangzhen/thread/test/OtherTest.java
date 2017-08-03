package me.zhangzhen.thread.test;

import java.util.HashMap;

public class OtherTest {
	public static void main(String[] args) {
		System.out.println(10 / 20 );
		HashMap<String, String> hm = new HashMap<>();
		String object = hm.get("hello");
		System.out.println(object.equals(null));
	}
}
