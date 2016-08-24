package com.lambdaDemo.mode;

import java.io.Closeable;
import java.io.IOException;

public class CommandTest {

	public static void main(String[] args) throws IOException {
//		Editor editor=null; 
//		Macro macro=new Macro();
//		
//		macro.record(new Save(editor));
//		macro.record(editor::save);
		
		//自动调用CloseResource的close方法
		try(CloseResource editor=new CloseResource()){
			System.out.println("处理资源");
		}
	}
	
	public static class CloseResource implements Closeable{

		@Override
		public void close() throws IOException {
			System.out.println("资源关闭了");
		}
		
	}
	
}
