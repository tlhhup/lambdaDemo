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
		
		//�Զ�����CloseResource��close����
		try(CloseResource editor=new CloseResource()){
			System.out.println("������Դ");
		}
	}
	
	public static class CloseResource implements Closeable{

		@Override
		public void close() throws IOException {
			System.out.println("��Դ�ر���");
		}
		
	}
	
}
