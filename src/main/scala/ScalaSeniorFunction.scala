object ScalaSeniorFunction {

  def main(args: Array[String]): Unit = {
    /**
      * 1、求值策略
      * scala里有两种求值策略
      * Call By Value -先对函数实参求值，在函数体中用这个求出的参数值。
      * Call By Name -先不对函数实参求值，而是函数实参每次在函数体内被用到时都会求值。
      * scala通常使用Call By Value
      * 如果函数形参类型以 =>开头，那么就是在使用Call By Name
      * def foo（x : Int）= x             //Call By Value
      * def foo（x : => Int）= x          //Call By Name
      * def loop():Int = loop //递归函数    //> loop: ()Int
      * def bar(x : Int,y : =>Int) =1      //> bar: (x: Int, y: => Int)Int
      * bar(1,loop)                                //> res3: Int = 1
      * //bar(loop,1)                             //会死循环
      *
      * 2、高阶函数
      * 用函数作为形参或带返回值的函数，称为高阶函数
      * def operate（f: (Int，Int) => Int）={
      * f(4,4)
      * }//形参传入的是一个函数
      * def greeting()= (name: String) =>{"hello "+name}//返回一个匿名函数
      *
      * 3、匿名函数
      * 匿名函数就是函数常量，也称为函数文字量
      * 在scala里，匿名函数的定义格式为（形参列表）=>{函数体}
      *
      * 4、柯理化
      * 柯理化函数把具有多个参数的函数转换为一条函数链，每个节点上是单一参数
      * def add（x: Int,y: Int）= x + y //常规函数写成
      * def add(x: Int)(y: Int) = x + y //scala中柯理化的语法
      * 5、递归函数
      * 在函数式编程中是实现循环的一种技术。
      * 缺陷:递归的层数越深，栈就越多。
      * 6、尾递归函数
      * 尾递归函数中所有递归形式的调用都出现在函数的末尾。
      * 当编译器检测到一个函数调用的是尾递归的时候，它就覆盖当前的活动记录而不是在栈中去创建一个新的。
      * def factorial(n: Int):Int = {
      * if(n<=0) 1
      * else n*factorial(n)
      * }
      * \@annotation.tailrec // \@转义
      * def factorial(n: Int,m: Int):Int = {
      * if(n<=0) m
      * else
      * factorial(n-1,m*n)
      * }
      * -----------下面是scala中常用函数的使用------------
      * val multiplier = (i: Int, m: Int) => i * m   //> multiplier : (Int, Int) => Int = <function2>
      * def function1(n: Int): Int = {
      *   multiplier.apply(n, 2)    //等价于multiplier(n,2)
      * } //> function1: (n: Int)Int
      * function1(1)                           //> res4: Int = 2
      * def function2(m: (Int) => Int) = m      //> function2: (m: Int => Int)Int => Int
      * def funint2(m: Int): Int = m               //> funint2: (m: Int)Int
      * function2(funint2)(2)                        //> res5: Int = 2
      * def function3(f: (Int, Int) => Int) = f       //> function3: (f: (Int, Int) => Int)(Int, Int) => Int
      * def funint3(m: Int,n: Int): Int= m*n       //> funint3: (m: Int, n: Int)Int
      * function3(funint3)(2,3)                        //> res6: Int = 6
      * def greeting()= (name: String) => {"hello "+ name}    //> greeting: ()String => String
      * greeting()("xiaoming")            //> res7: String = hello xiaoming
      * val function4 = (x: Int) => x + 1        //> function4 : Int => Int = <function1>
      * function4(4)                                     //>res8: Int = 5
      * val function5 = (x:Int) => {
      *   if(x > 1){
      *     "x>1 and x=" +x
      *   }else{
      *     "x<1 and x = " +x
      *   }
      * }
      * //> function5 : Int => String = <function1>
      * function5(5)            //> res9: String = x>1 and x=5
      * val function6 = (_ : Int) + ( _ :Int)       //> function6 : (Int, Int) => Int = <function2>
      * function6(5,6)                                   //> res10: Int = 11
      * def function7(a:Int, b:Int, c:Int) = a+b+c     //> function7: (a: Int, b: Int, c: Int)Int
      * val function8 = function7 _                         //> function8 : (Int, Int, Int) => Int = <function3>
      * function8(1,2,3)                                       //> res11: Int = 6
      * def function9(args: Int*) = for (arg <- args) println(arg) //> function9: (args: Int*)Unit
      * function9(1,2,3) //1,2,3
      */
  }

}
