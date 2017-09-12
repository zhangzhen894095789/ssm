package me.zhangzhen.util;

public enum Common {

	ORDERLIST(1,"orderList");
	private String key;
	private int index;
	private Common (int index,String key ){
		this.key = key;
		this.index = index;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public static void main(String[] args) {
		System.out.println(Common.ORDERLIST.getKey());
		
		System.out.println(Common.ORDERLIST.key);
	}
}
