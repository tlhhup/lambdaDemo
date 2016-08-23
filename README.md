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
			Predicate<T> 	T 		boolean 	这张唱片已经发行了吗，断言
			Consumer<T> 	T 		void 		输出一个值
			Function<T,R> 	T R 	获得Artist 	对象的名字，值得转换
			Supplier<T> 	None 	T 			工厂方法
			UnaryOperator<T> T 		T 			逻辑非（ !）
			BinaryOperator<T> (T, T) T 			求两个数的乘积（ *）
4. 注意事项
	1. 在使用lambda表达式时，对应的函数接口中只能有一个抽象方法
	2. lambda表达式主体由多条语句组成时，如果相应的函数接口具有返回值，则需要手动的返回数据。
	3. lambda表达式中使用外部变量，如同匿名内部类是否外部变量方式一致，但在lambda表达式中该变量可以省略修饰符final，但是该**变量在实际意义上必须表示为final修饰的**
***
### 流 Stream 对集合api的新增操作
1. 在集合顶层接口Collection中定义了一个默认方法

		default Stream<E> stream() {
	        return StreamSupport.stream(spliterator(), false);
	    }
	该方法用于返回一个Stream对象
2. **及早最值**：像filter 这样只描述Stream，最终不产生新集合的方法叫作惰性求值方法；而像count 这样**最终会从Stream 产生值的方法叫作及早求值方法**。
2. 常用的流操作
	1. collect(toList())：Stream 里的值生成一个列表，是一个及早求值操作。
	2. map：如果有一个函数可以将一种类型的值转换成另外一种类型，map 操作就可以使用该函数，将一个流中的值转换成一个新的流。map接收一个function类型的参数
	3. filter：过滤，接收一个Predicate类型的参数
	4. flatMap：然后将多个Stream 连接成一个Stream
	5. max和min：求最大值和最小值
	6. of:将多个元素转换成Stream
	6. reduce：reduce 操作可以实现从一组值中生成一个值

			//使用reduce求和
			int count = Stream.of(1, 2, 3)
					.reduce(0, (acc, element) -> acc + element);
			//展开reduce操作
			BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
			int count = accumulator.apply(
				accumulator.apply(
					accumulator.apply(0, 1),
					2),
				3);