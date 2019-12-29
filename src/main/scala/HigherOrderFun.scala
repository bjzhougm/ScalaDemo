object HigherOrderFun {

  def main(args: Array[String]): Unit = {

    /**
      * 1、高阶函数实例
      */
    println( apply( layout, 10))
    println( apply( layout1) )

    /** 2、变量转化成函数
      * fun1 为函数
      * 函数也是对象
      * 所以可以赋值给变量
      * 格式: val 变量名 = 函数名+空格+_
      * 这样变量就是函数了
      * fun_v可以接收string类型的参数
      * 对参数作用会返回unit类型的返回值
      * 符号=>相当于对左边的参数进行右边的加工
      *
      */


    val fun_v = fun1 _

    fun1("spark")
    fun_v("spark")

    /** 3、高阶函数传参
      * 定义一个匿名函数
      * 把匿名函数传入到定义的BigData的高阶函数里
      */
    val HiSpark = (content:String)=>println(content)

    BigData(HiSpark,"Spark")

    val func=(name:String) =>println(name)
    BigData(func,"Scala")


    val f=(name:String) =>println(name)
    BigData(f,"Scala")


    /** 4、集合map函数
      * Array.map()作用,他会遍历array中每一个元素,并将每个元素作为具体的值传给map中的作为参数的函数.
      * 把Array的对象赋给array
      * map是函数,把item=>item*2左右函数传入map里
      */
    val array =Array(1,2,3,4,5,6,7,8)

    array.map(item=>2*item)

    /**
      * 5、高阶函数返回值为函数
      * 定义func_Returned函数作为返回值的函数，
      * func_Returned返回符串类型。
      * 输入func_Returned(“Spark”),
      * 生成了一个名为Spark的函数。
      *
      * 首先我们定义了一个返回值为函数的函数func_Returned,
      * 然后我们将其返回值也就是一个函数赋值了变量returned,
      * 这样就得到了一个名为returned的函数,
      * 然后我们调用returned函数得到了打印结果。
      * func_Returned("Spark")("Scala")
      */

    val returned=func_Returned("Spark")

    returned("Scala")

    /**
      * 6.单参数无返回值的简化
      * 可以定义一个匿名函数传入
      * 或者直接传入函数本身不通过函数的变量
      * val printlnName =(name :String)=>println(name)
      * spark(printlnName,"Scala")
      * 或
      * spark((name:String)=>println(name),"Scala")
      *
      * scala可以类型推断,
      * 而且func只有一个参数,
      * 由于在spark定义是只有一个变量类型,
      * 所以我们就可以把name后的类型String去掉
      * 就变成
      * spark((name)=>println(name),"Scala")
      * 由于只有一个参数故小括号也可以去掉
      * 就变成
      * spark(name=>println(name),"Scala")
      * 又由于只有一个参数，所以其参数可以省略，用下划线代替
      * spark(println(_),"Scala")
      *
      * array.map(item =>item*2)
      * array.map(_ *2)
      * array.map(_ *2).foreach(println(_))
      * array.map(_ *2).foreach(println _)
      * array.map(_ *2).foreach(println)
      * array.map(_ *2).filter(_ >10).foreach(println)
      */


    spark(println(_),"Scala")


    /**
      * 6.函数的闭包
      *
      * 在这里我们首先定义了返回值为函数的一个函数，
      * 然后我们调用了该函数，传入的参数为Spark，
      * 通常当函数scala运行结束后，我们是不能在访问该参数了，
      * 因为局部变量Spark的作用域也就是生命周期结束了，
      * 但是当我们调用funcResult函数后，
      * 发现它是能访问参数Spark的。
      * 这就是函数的闭包。
      * scala内部是创建了一个函数的内部对象，
      * 将参数Spark作为一个成员保留在了这个对象中。
      */

    val funcResult=scala("Spark")

    funcResult("Hadoop")




  }

  /**
    * 函数 f 和 值 v 作为参数，而函数 f 又调用了参数 v
    * 因为单行函数所以相当于
    * def apply(f: Int => String, v: Int) ={f(v)}
    * 意思是定义了一个apply函数
    * 参数是函数f(参数类型) => 结果类型,参数v
    * 函数体为函数取值为v时的返回值
    * 这里的函数f为layout
    * 这里[A]是数据类型 其中A可为任何类型
    *
    */

  def apply(f:Int => String, v: Int) =f(v)

  def layout[A](x: A) = "[" + x.toString() + "]"

  /**
    * 调用apply函数的时候就相识相当于把layout整体看成函数f(x)=layout(x)
    * 而函数体部分是当f取值为10时f(x)的返回值
    * 此时函数layout的取值为10
    * @param f
    * @return
    */
  def apply(f: Int => String) = f(10)

  def layout1[DDD](x: DDD) = "[" + x.toString() + "]"


  def fun1(name:String) = println(name)


  /**
    * 定义了一个函数BigData,
    * 这个函数有两个参数，
    * 第一个参数是一个函数，函数名是func，他有一个String类型的参数并且返回值是unit空值
    * 第二个参数是String类型的变量名为content的变量,
    * 函数体是将第二个参数作为第一个参数也就是函数func的参数,
    * 来调用第一个函数,
    * 整个函数返回值为unit空。
    * @param func
    * @param content
    */
  def BigData(func:(String)=>Unit,content:String)=func(content)


  /**
    * 高阶函数的返回值是函数
    *
    * func_Returned 相当于一个val的变量名
    * 传入spark相当于 val =
    * 把func_Returned直接付给另一个val的
    *
    * @param content
    * @return
    */

  def func_Returned(content:String) =(message:String)=>println(message)


  /**
    * 高阶函数有个非常有用的特性是类型推断。
    * 其可以自动推断出参数的类型,
    * 而且对于只有一个的参数的函数,
    * 可以省略掉小括号,
    * 并且在函数的参数作用的函数体内只是用一次函数的输入参数的值话,
    * 就可省略掉函数名,用下划线（_）代替。
    * 在main函数里定义匿名函数，传入高阶函数
    */

  def spark(func:(String)=>Unit,name:String)=func(name)


  /**
    * 函数的闭包就是当函数的参数超出其作用域时，
    * 我们还能对参数进行访问
    *
    *
    * 在这里我们首先定义了返回值为函数的一个函数,
    * 然后我们调用了该函数,
    * 传入的参数为Spark,
    * 通常当函数scala运行结束后,
    * 我们是不能在访问该参数了,
    * 因为局部变量Spark的作用域也就是生命周期结束了.
    * 但是当我们调用funcResult函数后.
    * 发现它是能访问参数Spark的.
    * 这就是函数的闭包。
    * scala内部是创建了一个函数的内部对象，
    * 将参数Spark作为一个成员保留在了这个对象中。
    * @param content
    * @return
    */
  def scala(content:String)=(message:String)=>println(content+"   "+message)


}
