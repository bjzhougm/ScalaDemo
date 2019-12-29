object FunctionTest {
  /**
    * 传名调用（call-by-name）:将未计算的参数表达式直接应用到函数内部
    * 传值调用（call-by-value）:先计算表达式的值，再应用到函数内部
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {

    //1、传名参数
    println("===========传名参数名开始=========")
    delayed(time())
    println("===========传名参数名结束=========")

    //2、指定函数参数名
    println("===========指定函数参数名开始=========")
    //printInt(b=3,a=5)
    println("===========指定函数参数名结束=========")

    //3、设置可变参数
    println("===========设定可变参数名开始=========")
    //printString("Run", "Scala", "Python")
    println("===========设置可变参数名结束=========")

    //4、递归函数
    println("===========递归函数开始=========")
    /**
        for(i <- 1 to 10){
          println(i +"的阶乘为:="+factorial(i));
        }
      */
    println("===========递归函数结束=========")

    //5、默认参数值
    println("===========默认参数值开始=========")
    //println("返回值："+add())
    println("===========默认参数值结束=========")



  }

  def time() = {
    println("获取时间，单位为纳秒")
    System.nanoTime()
  }

  /**
    * 等价函数
    * def delayed_1 (t: =>Long) =t
    * @param t
    * @return
    */

  def delayed(t: => Long)={
    println("获取时间，单位为纳秒")
    println("参数："+t)//调用t函数
    t //返回t
  }



  /**
    * 指定函数参数名
    * 一般情况下函数调用参数,
    * 就按照函数定义时的参数顺序一个个传递,
    * 但是我们也可以通过指定函数参数名,
    * 并且不需要按照顺序向函数传递参数.
    * @param a
    * @param b
    */
  def printInt(a:Int,b:Int)={
    println("Value of a : " + a)
    println("Value of b : " + b)
  }

  /**
    * 设置可变参数
    * Scala 允许你指明函数的最后一个参数可以是重复的，
    * 即我们不需要指定函数参数的个数，
    * 可以向函数传入可变长度参数列表。
    * Scala 通过在参数的类型之后放一个星号来设置可变参数(可重复的参数)
    * @param args
    */
  def printString(args:String*)={
    var i=0;
    for(arg<-args){
      println("args value ["+i+"] ="+arg)
      i+=1
    }
  }

  /**
    * 递归函数
    * 递归函数来计算阶乘
    */

  def factorial(n:BigInt):BigInt={
    if(n<=1)
      1
    else
      n*factorial(n-1)
  }

  /**
    * 默认参数值
    *
    * Scala可以为函数参数指定默认参数值，
    * 使用了默认参数，
    * 你在调用函数的过程中可以不需要传递参数，
    * 这时函数就会调用它的默认参数值，
    * 如果传递了参数，
    * 则传递值会取代默认值。
    */

  def add(a:BigInt =5,b:BigInt=6): BigInt ={
    var sum:BigInt=0
    sum =a + b
    return sum
  }



}
