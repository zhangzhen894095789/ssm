package me.zhangzhen.random.test;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import me.zhangzhen.util.JsonUtil;

public class TestRandomNum {

	@Test
	public void test() {

		/*
		 * System.out.println(Math.random());
		 * 
		 * long x = (long) (Math.random()*900000 + 100000);
		 * 
		 * long num = new Date().getTime() + x;
		 * 
		 * System.out.println(num);
		 */

		String ss = "{\"code\":\"200\",\"msg\":\"成功\",\"model\":{\"stepSize\":10,\"totalPage\":3,\"pageCount\":26,\"page\":1,\"pageIndex\":0,\"pageResult\":"
				+ "["
				+ "{\"userId\":345,\"userName\":\"15711667873\",\"mobile\":\"15711667873\",\"realName\":\"王海\",\"idCard\":\"6123241988****5239\",\"province\":\"上海\",\"city\":\"上海\",\"area\":\"浦东新区\",\"createTime\":\"2017-05-27 11:58:22\",\"borrowNid\":\"ST28932239829323\",\"borrowUse\":\"222\",\"borrowAmount\":300,\"rate\":5.00,\"status\":\"1\",\"productId\":\"0\",\"duration\":\"7\",\"durationType\":\"1\",\"verifyDay\":null,\"repaymentType\":\"0\"},"
				+ "{\"userId\":345,\"userName\":\"15711667873\",\"mobile\":\"15711667873\",\"realName\":\"王海\",\"idCard\":\"6123241988****5239\",\"province\":\"上海\",\"city\":\"上海\",\"area\":\"浦东新区\",\"createTime\":\"2017-05-27 13:12:32\",\"borrowNid\":\"ST28932239829384\",\"borrowUse\":\"222\",\"borrowAmount\":300,\"rate\":5.00,\"status\":\"1\",\"productId\":\"0\",\"duration\":\"7\",\"durationType\":\"1\",\"verifyDay\":null,\"repaymentType\":\"0\"},"
				+ "{\"userId\":350,\"userName\":\"18721409352\",\"mobile\":\"18721409352\",\"realName\":\"印林泉\",\"idCard\":\"3411221992****0025\",\"province\":\"北京\",\"city\":\"北京\",\"area\":\"海淀区\",\"createTime\":\"2017-05-27 11:03:40\",\"borrowNid\":\"S3501495854222323\",\"borrowUse\":\"资金周转\",\"borrowAmount\":500,\"rate\":5.50,\"status\":\"1\",\"productId\":\"JRXJ005810216638\",\"duration\":\"15\",\"durationType\":\"1\",\"verifyDay\":null,\"repaymentType\":\"2\"},"
				+ "{\"userId\":350,\"userName\":\"18721409352\",\"mobile\":\"18721409352\",\"realName\":\"印林泉\",\"idCard\":\"3411221992****0025\",\"province\":\"北京\",\"city\":\"北京\",\"area\":\"海淀区\",\"createTime\":\"2017-05-27 13:48:36\",\"borrowNid\":\"S3501495864117703\",\"borrowUse\":\"信用卡还款\",\"borrowAmount\":500,\"rate\":5.50,\"status\":\"1\",\"productId\":\"JRXJ005810216638\",\"duration\":\"15\",\"durationType\":\"1\",\"verifyDay\":null,\"repaymentType\":\"2\"}"
				+ "]" + "}" + "}";

		Map jsonToMap = (Map) JsonUtil.jsonToMap(ss);
		System.out.println(jsonToMap);
		Map object = (Map) jsonToMap.get("model");
		System.out.println(object);
		System.out.println(next());

	}

	private static Date date = new Date();
	private static StringBuilder buf = new StringBuilder();
	private static int seq = 0;
	private static final int ROTATION = 99999;

	
	public static synchronized long next() {
		if (seq > ROTATION)
			seq = 0;
		buf.delete(0, buf.length());
		date.setTime(System.currentTimeMillis());
		String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);
		System.out.println(str);
		return Long.parseLong(str);
	}
}