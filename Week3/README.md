#### 一、递归

递归的本质就是函数的自身调用。

一般一个较大的问题能够划分成较小的问题，较小问题又能继续划分成更小的问题，并且这些问题存在个某个递推的关系，那么这种问题可以通过递归的方式解决。

如何写出递归代码? 1、找出递归的结束条件；2、找出问题的递推关系

递归伪代码

```
public void func(level, params){
	//1、递归终止条件.
	if(level){
		return;
	}

	//2、处理当前层的逻辑

	//3、进入下一层
	func(level + 1, params)

	//4、revert current level state
}

```

#### 二、分治与回溯

分治算法：它是一种分而治之算法思想，它主要是将一个大问题分解成较小问题求解，然后根据较小结果的解的到较大问题的解。

算法模版:

```
public void func(level, params){
	//1、递归终止条件.
	if(level){
		return;
	}

	//2、处理当前层的逻辑

	//3、计算子问题的解
	subresult1 = func(level + 1, params)
	subresult2 = func(level + 1, params)
	subresult3 = func(level + 1, params)

	//4 merge sub result 

	//5、revert current level state
}

```

回溯算法：回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。




