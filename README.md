# jdk 1.8 新特性
### lambda表达式：匿名内部类的另一种表现形式
1. swing中队控件添加点击事件

		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("点击了按钮");
			}
		});
	1. 该匿名内部类中只有一个方法，且方法的参数类型为ActionEvent

			//e 表示参数  ->  后表示函数体
			button.addActionListener(e->System.out.println("使用lambda表达式"));
		1. e：是参数名，和上面匿名内部类示例中的是同一个参数。
		2. -> 将参数和Lambda 表达式的主体分开，而主体是用户点击按钮时会运行的一些代码。
3. Lambda表达式几种形式
	1. 不带参数：
	
			//内这样写的原因是Runnable接口中具有一个不带参数的run方法
			Runnable noArguments = () -> System.out.println("Hello World");
	2. 带参数：

			ActionListener oneArgument = event -> System.out.println("button clicked");

	3. 表达式主体包含多条语句：使用"{}"(花括号包裹)

			Runnable noArguments = () -> {
				System.out.println("这个使用lambda表达式处理生成的runnable的子类");
				System.out.println("Hello World");
			};
	4. 带参数带返回值：
			
			//代表的是BiFunction中apply方法的实现
			BinaryOperator<Long> add = (x, y) -> x + y;//没指定参数的类型，通过类型推断
			BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
3. 函数式接口：只有一个抽象方法的接口，用作Lambda 表达式的类型。
	1. java中重要的函数接口

		
			接口			参数		返回类型		示例
			Predicate<T> 	T 		boolean 	这张唱片已经发行了吗
			Consumer<T> 	T 		void 		输出一个值
			Function<T,R> 	T R 	获得Artist 	对象的名字
			Supplier<T> 	None 	T 			工厂方法
			UnaryOperator<T> T 		T 			逻辑非（ !）
			BinaryOperator<T> (T, T) T 			求两个数的乘积（ *）
***
### 流 Stream
1. 