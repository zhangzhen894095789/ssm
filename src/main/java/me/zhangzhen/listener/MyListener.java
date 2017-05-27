package me.zhangzhen.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent>{
	public static int i = 0;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent evdnt) {
		//上下文刷新时触发
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File("D:/repository/projects-test/ssm/src/main/webapp/ApplicationInitOrFlushTimes.properties")));
			p.setProperty("time", String.valueOf(Integer.parseInt(p.getProperty("time"))+1));
			String comments = "hello";
			FileOutputStream out = new FileOutputStream(new File("D:/repository/projects-test/ssm/src/main/webapp/ApplicationInitOrFlushTimes.properties"));
			p.store(out, comments );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
