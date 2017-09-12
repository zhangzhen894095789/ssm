package test.javanio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.junit.Test;
/**
 * java nio test
 * @author dell、
 * 
 * java 非阻塞io api 通道 channel 缓冲区 buffer 
 * 
 * 从通道读取数据到缓冲区，通过缓冲区将数据写入通道
 * 
 * 当线程从通道读取数据到缓冲区时，线程还是可以进行其他事情。当数据被写入到缓冲区时，线程可以继续处理它。从缓冲区写入通道也类似。
 *
 */
public class FileChannel {
	@Test
	public void testFileChannel() throws IOException {
		
		RandomAccessFile file = new RandomAccessFile("D:/repository/projects-test/ssm/src/main/webapp/ApplicationInitOrFlushTimes.properties", "rw");
		//获取文件通道
		java.nio.channels.FileChannel channel = file.getChannel();
		//创建缓冲区大小50字节
		ByteBuffer dst = ByteBuffer.allocate(50);
//		int i = dst.compareTo(ByteBuffer.allocate(30));
//		System.out.println(i);
//		System.out.println(ByteBuffer.allocate(30).compareTo(dst));
//		dst.put("1".getBytes());
		System.out.println("实际缓冲区的大小：" + dst.capacity());
		//将数据从通道读入缓冲区
		int read = channel.read(dst);
		
		//read 读入到缓冲区数据字节大小
		while (read != -1) {
			System.out.println("读取到缓冲区数据的大小:  " + read);
			dst.flip();//使缓冲区准备好读取
			while (dst.hasRemaining()) {
				//输出缓冲区读取的数据
				System.out.print((char) dst.get());
			}
			dst.clear();//清空整个缓冲区 make sure buffer for writing
//			dst.compact();//清空缓冲区中已经读取过的数据，未读取的数据将被放到缓冲区的开头
			read = channel.read(dst);//继续从通道中读取数据到缓冲区
		}
		file.close();
		

	}
	
	
}
