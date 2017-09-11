package me.zhangzhen.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件工具类
 * @author dell、
 *
 */
public class FileUtils {
	
	private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

	/***
	 * 生成多层级目录
	 * @param filename  文件名称
	 * @param savepath  文件要要保存服务器的根目录（或者起始目录）
	 * @return  返回String类型的分级路径
	 */
	public static String  makePath(String filename,String savepath){  
	    int hashcode=filename.hashCode();  
	    int dir1=hashcode&0xf;//生成一级目录取哈希码的后4为值范围：0-15  
	    int dir2=(hashcode&0xf0)>>4;//二级目录  可以根据需要多分级  
	    String path=savepath+"\\"+dir1+"\\"+dir2;  
	    log.info("生成的文件的完整路径：" + path);
	    File file=new File(path);  
	    if(!file.exists()){  
	        file.mkdirs();//创建目录  
	    }  
	    return dir1+"\\"+dir2+"";//返回分级目录路径（注意不是全路径）
	}
	
	
	public static void main(String[] args) {
		String filename = "测测测";
		String savepath = "\\存放的路径";
		String makePath = makePath(filename, savepath );
		System.out.println(makePath);
		
	}
}
