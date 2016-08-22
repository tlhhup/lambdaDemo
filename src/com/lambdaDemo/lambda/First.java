package com.lambdaDemo.lambda;

import java.util.function.BinaryOperator;

public class First {

	public static void main(String[] args) {
		/*
		JFrame frame=new JFrame("按钮");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		//设置按钮
		JButton button=new JButton("点我");
		frame.add(button);
		
		/*button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("点击了按钮");
			}
		});
		button.addActionListener(e->System.out.println("使用lambda表达式"));
		
		//显示
		frame.setVisible(true);
		*/
		//Runnable中只有一个run方法且为不带参数的方法
		Runnable noArguments = () -> {
			System.out.println("这个使用lambda表达式处理生成的runnable的子类");
			System.out.println("Hello World");
		};
		//实现了BiFunction中的apply方法
		BinaryOperator<Long> add =(x,y)->x+y;
		Long apply = add.apply(90L, 90L);
		System.out.println(apply);
	}

}
