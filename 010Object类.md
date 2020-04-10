需要掌握的内容：

- Object类中的方法：

  - ​	 toString（）

  
- ​	 equals（）
  

- 匿名内部类






1.Object类中的方法：

------

- toString（）


​	1、源代码：
​		public String toString() {
​			return this.getClass().getName() + "@" + Integer.toHexString(hashCode());
​		}
​		源代码上toString()方法的默认实现是：
​			类名@对象的内存地址转换为十六进制的形式

​	2、SUN公司设计toString()方法的目的：
​		toString()方法的作用：
​			toString()方法的设计目的是：通过调用这个方法可以将一个“java对象”转换成“字符串表示形			式”

​	3、其实SUN公司开发java语言的时候，建议所有的子类都去重写toString()方法。
​		  toString()方法应该是一个简洁的、详实的、易阅读的.



- equals（）


​	1、equals方法的源代码
​			public boolean equals(Object obj) {
​				return (this == obj);
​			}
​			以上这个方法是Object类的默认实现。

​	2、SUN公司设计equals方法的目的：
​		以后编程的过程当中，都要通过equals方法来判断两个对象是否相等。
​		equals方法是判断两个对象是否相等的。
​	3、我们需要研究一下Object类给的这个默认的equals方法够不够用！！！！
​			在Object类中的equals方法当中，默认采用的是“==”判断两个java对象
​			是否相等。而“**==**”判断的是**两个java对象的内存地址**，我们应该判断
​			两个java**对象的内容是否相等**。所以Object的equals方法不够用，
​			**需要子类重写equals**。
​	4、判断两个java对象是否相等，不能使用“==”，因为“==”比较的是两个
​	对象的内存地址。

java语言当中的字符串String有没有重写toString方法，有没有重写equals方法。

总结：
	1、String类已经重写了equals方法，比较两个字符串不能使用==，必须使用equals。
	equals是通用的。

​	2、String类已经重写了toString方法。

大结论：
	java中什么类型的数据可以使用“==”判断
		java中**基本数据类型**比较是否相等，**使用==**

​	java中什么类型的数据需要使用equals判断
​		java中所有的**引用数据类型**统一使用**equals方法**来判断是否相等。



- finalize()（非重点  了解即可）

​	1、在Object类中的源代码：
​		protected void finalize() throws Throwable { }

​		**GC**：**负责调用**finalize()方法。

​	2、finalize()方法只有一个方法体，里面没有代码，而且这个方法是**protected修饰**的。

​	3、这个方法不需要程序员手动调用，JVM的垃圾回收器负责调用这个方法。
​	不像equals toString，equals和toString()方法是需要你写代码调用的。
​	**finalize()只需要重写，重写完将来自动会有程序来调用**。

​	4、finalize()方法的执行时机：
​		当一个java对象**即将被垃圾回收器回收**的时候，垃圾回收器负责调用
​		finalize()方法。
​	
​	5、finalize()方法实际上是SUN公司为java程序员准备的一个时机，垃圾销毁时机。
​	如果希望**在对象销毁时机执行一段代码**的话，这段代码要写到finalize()方法当中。

​	6、静态代码块在类加载时刻执行，并且只执行一次。
​		  这是一个SUN准备的类加载时机。

​		  finalize()方法同样也是SUN为程序员准备的一个时机。
​		  这个时机是垃圾回收时机。

​	7、提示：	
​		java中的**垃圾回收器不是轻易启动**的，
​		垃圾太少，或者时间没到，种种条件下，
​		有可能启动，也有可能不启动。



- hashCode（）（非重点  了解即可）
  1、在Object中的hashCode方法是怎样的？
  			public native int hashCode();

  ​	  这个方法不是抽象方法，带有native关键字，底层调用C++程序。
  2、hashCode()方法返回的是哈希码：
  ​		实际上就是一个java对象的内存地址，经过哈希算法，得出的一个值。
  ​		所以hashCode()方法的执行结果可以等同看做一个java对象的内存地址。



- 对以上知识点的大总结：


​	Object类当中有哪些常用的方法？
​		我们去哪里找这些方法呢？
​			第一种方法：去源代码当中。（但是这种方式比较麻烦，源代码也比较难）
​			第二种方法：去查阅**java的类库的帮助文档**。

​	什么是API？
​		应用程序编程接口。（Application Program Interface）
​		整个JDK的类库就是一个javase的API。
​		每一个API都会配置一套API帮助文档。
​		SUN公司提前写好的这套类库就是API。（一般每一份API都对应一份API帮助文档。）
​	
​	目前为止我们只需要知道这几个方法即可：
​			protected Object clone()   // 负责对象克隆的。

 		   int hashCode()	// 获取对象哈希值的一个方法。
			boolean equals(Object obj)  // 判断两个对象是否相等
			String toString()  // 将对象转换成字符串形式
			protected void finalize()  // 垃圾回收器负责调用的方法



​	toString()方法
​		以后所有类的toString()方法是需要重写的。
​		重写规则，越简单越明了就好。

​		System.out.println(引用); 这里会自动调用“引用”的toString()方法。

​		String类是SUN写的，toString方法已经重写了。



​	equals()方法
​		以后所有类的equals方法也需要重写，因为Object中的equals方法比较
​		的是两个对象的内存地址，我们应该比较内容，所以需要重写。

​		重写规则：自己定，主要看是什么和什么相等时表示两个对象相等。

​		基本数据类型比较实用：==
​		对象和对象比较：调用equals方法

​		String类是SUN编写的，所以String类的equals方法重写了。
​		以后判断两个字符串是否相等，最好不要使用==，要调用字符串对象的equals方法。

​		注意：重写equals方法的时候要彻底。



​	finalize()方法
​		这个方法是protected修饰的，在Object类中这个方法的源代码是？
​		protected void finalize() throws Throwable { }

------



2.匿名内部类：

------

​	2.1、什么是内部类？
​		内部类：在类的内部又定义了一个新的类。被称为内部类。

​	2.2、内部类的分类：
​		静态内部类：类似于静态变量
​		实例内部类：类似于实例变量
​		局部内部类：类似于局部变量

​	2.3、使用内部类编写的代码，可读性很差。能不用尽量不用。

​	2.4、匿名内部类是局部内部类的一种。
​		因为这个类没有名字而得名，叫做匿名内部类。

​	2.5、学习匿名内部类主要是以后在阅读别人代码的时候，能够理解。
​		并不代表以后都要这样写。因为匿名内部类有两个缺点：
​		缺点1：太复杂，太乱，可读性差。
​		缺点2：类没有名字，以后想重复使用，不能用。

​	2.6、例子：

```java
	mm.mySum(new Compute(){
		public int sum(int a, int b){
			return a + b;
		}
	}, 200, 300);
```
------

