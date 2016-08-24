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
3. 在**1.8之后Iterable接口**中添加了forEach和spliterator方法
4. 在**1.7之后utisl包中提供了一个Objects**工具类可对对象进行非空校验
5. **针对实现了Closeable(继承AutoCloseable)接口的类**，在使用try-catch语句块的时候可以简写为以下格式
			
		//省略在finally语句块中的关闭资源
		try(CloseResource editor=new CloseResource()){
			System.out.println("处理资源");
		}

		public static class CloseResource implements Closeable{

			@Override
			public void close() throws IOException {//在try语句执行之后会自动调用
				System.out.println("资源关闭了");
			}
			
		}
***
### 类库
1. Java 8 中的另一个变化是引入了**默认方法和接口的静态方法**
2. 基本类型：在java8 中仅对整形、长整形和双精度浮点型做了特殊处理，返回一个特殊的Stream
3. 方法重载：
	1. 方法重载时，**参数为某个函数接口以及其子类时**，调用重载的方法时，lambda表达式的类型是最具体的函数接口的类型(及子类)
	2. Lambda 表达式作为参数时，其类型由它的目标类型推导得出，推导过程遵循
如下规则：
		1. 如果只有一个可能的目标类型，由相应函数接口里的参数类型推导得出；
		2. 如果有多个可能的目标类型，由最具体的类型推导得出；
		3. 如果有多个可能的目标类型且最具体的类型不明确，则需人为指定类型。
4. @FunctionalInterface注解的作用：将代码块作为数据打包起来，可作为lambda表达式进行使用
5. 默认方法：如果子类中没有**实现**(重写)父接口中的抽象方法，就使用父类默认的方法。
	1. 默认方法只能通过调用子类的方法来修改子类本身，避免了对子类的实现做出各种假设。
	2. 类中重写方法的优先级高于默认方法，及如果子类中重写了接口中的默认方法，则调用时调用的是子类更为具体的方法
	3. 接口的多继承，当继承的多个接口中存在**签名一致的默认方法**时
		1. 子接口中必须强制重写该默认方法(还是为默认方法)

				public interface MusicalCarriage extends Carriage, Jukebox {

					@Override
					default void rock() {
						Carriage.super.rock();
					}
				
				}
		2. 子类中必须强制重写该默认方法

				public class MusicalCarriage implements Carriage, Jukebox {
	
					@Override
					public void rock() {
						Carriage.super.rock();
					}
				
				}
	4. 三定律
		1. 类胜于接口。如果在继承链中有方法体或抽象的方法声明，那么就可以忽略接口中定义
的方法。
		2. 子类胜于父类。如果一个接口继承了另一个接口，且两个接口都定义了一个默认方法，
那么子类中定义的方法胜出
		3. 没有规则三。如果上面两条规则不适用，子类要么需要实现该方法，要么将该方法声明
为抽象方法。
3. 接口中的静态方法
4. Optional：Optional 是为核心类库新设计的一个数据类型，用来替换null 值，并提供了一些列额外的方法。该类为final修饰的类，且构造函数私有化
	1. of：方法创建一个Optional对象，其值存放在value属性中
	2. empty:创建一个空的Optional对象，其value属性为null
	3. isPresent：判断是否为一个空对象
***
###高级集合类和收集器
1. 方法引用：语法`Classname::methodName`
	
		artist -> artist.getName()改为方法引用---->Artist::getName
	1. 构造函数：类名::new    如：Artist::new
	2. 创建数组:类名[]::new	如：String[]::new
2. 元素顺序：
3. 收集器：Collectors 一个及早求值的方法，从流中生成复杂值得结构
	1. Comparator接口中提供了一些静态方法，用于比较
	2. 转换成其他集合

			artists.collect(Collectors.toCollection(TreeSet::new));
	3. 转换成值
			
			//定义一个方法
			Function<Artist, Integer> getCount=artist->artist.getMembers().size();
			return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
	4. 数据分块：调用 Collectors的partitioningBy方法将数据分成true和false映射的map数据
	5. 数据分组：调用 Collectors的groupingBy方法
	6. 格式化字符串：调用 Collectors的joining方法
	7. 自定义收集器：实现Collector接口
***
###数据并行化
1. 并行和并发
	1. 并行：多个任务在同一时间发生(将同一任务分块同一时间一起执行)
	2. 并发：多个任务共享时间段
3. 数据的并行化：将数据分块，为每块数据分配单独的处理单元
	1. 如果是Stream则调用parallel方法使得stream就有并行化能力
	2. 如果想从一个集合类创建一个流，调用parallelStream 就能立即获得一个拥有并行能力的流
3. 并行化数组
	1. 在Arrays工具类中提供了以下方法
		1. parallelPrefix 任意给定一个函数，计算数组的和
		2. parallelSetAll 使用Lambda 表达式更新数组元素
		3. parallelSort 并行化对数组元素排序