package me.zhangzhen.test.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@WebAppConfiguration
public class BaseTest {

	@Test
	public void test(){
		System.out.println("加载spring配置文件。。。。");
	}
}
