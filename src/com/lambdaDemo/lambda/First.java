package com.lambdaDemo.lambda;

import java.util.function.BinaryOperator;

public class First {

	public static void main(String[] args) {
		/*
		JFrame frame=new JFrame("��ť");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		//���ð�ť
		JButton button=new JButton("����");
		frame.add(button);
		
		/*button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����˰�ť");
			}
		});
		button.addActionListener(e->System.out.println("ʹ��lambda���ʽ"));
		
		//��ʾ
		frame.setVisible(true);
		*/
		//Runnable��ֻ��һ��run������Ϊ���������ķ���
		Runnable noArguments = () -> {
			System.out.println("���ʹ��lambda���ʽ�������ɵ�runnable������");
			System.out.println("Hello World");
		};
		//ʵ����BiFunction�е�apply����
		BinaryOperator<Long> add =(x,y)->x+y;
		Long apply = add.apply(90L, 90L);
		System.out.println(apply);
	}

}
