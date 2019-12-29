import scala.math._

class HigherOrderFunClass {
  /**
    * math类的方法ceil 取整
    *
    * 从技术上讲，_将ceil方法转成了函数。
    * 在Scala中，你无法直接操纵方法，
    * 而只能直接操纵函数。
    * 当你在REPL中尝试这段代码时，并不意外，
    * num的类型是Double。
    * fun的类型被报告为(Double) => Double，
    * 也就是说，接受并返回Double的函数。
    * 你能对函数做些什么呢？两件事：
    * 调用它。
    * 传递它，存放在变量中，或者作为参数传递给另一个函数。
    */


  val fun=ceil _
  val num =3.14

  fun(num)

  /**
    * 正如你所看到的，这里用的是普通的函数调用语法。唯一的区别是，fun是一个包含函数的变量，而不是一个固定的函数。
    */

  Array(3.14,1.42,2.0).map(fun) // Array(4.0, 2.0, 2.0)

  /**
    * map方法接受一个函数参数，将它应用到数组中的所有值，然后返回结果的数组。在本章中，你将会看到许多其他接受函数参数的方法。
     */


  /**
    * 匿名函数
    * 在Scala中，你不需要给每一个函数命名，
    * 正如你不需要给每个数字命名一样。以下是一个匿名函数：
    * (x: Double) => 3 * x
    * 该函数将传给它的参数乘以3。
    * 你当然可以将这个函数存放到变量中：
    */

  val triple = (x: Double) => 3 * x

  def triple(x: Double) = 3 * x

  /**
    * 但是你不需要给函数命名。你可以直接将它传递给另一个函数
    */

  Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x) // Array(9.42, 4.26, 6.0)

  /**
    * 在这里，我们告诉map方法：“将每个元素乘以3”。
    * 说明：如果你愿意，也可以将函数参数包在花括号当中而不是用圆括号，例如：
    * Array(3.14, 1.42, 2.0).map{ (x: Double) => 3 * x }
    * 在使用中置表示法时（没有句点），这样的写法比较常见。
    * Array(3.14, 1.42, 2.0) map { (x: Double) => 3 * x }
    * 注意，这里的参数可以是任何接受Double并返回Double的函数。valueAtOneQuarter函数将计算那个函数在0.25位置的值。
    */

  /**
    * 带函数参数的函数
    * 实现接受另一个函数作为参数的函数。以下是一个示例：
    */
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

  valueAtOneQuarter(ceil _) // 1.0
  valueAtOneQuarter(sqrt _) // 0.5

  /**
    * valueAtOneQuarter的类型是什么呢？它是一个带有单个参数的函数,
    * 因为它的类型写做：(参数类型) => 结果类型
    * 结果类型很显然是Double,
    * 而参数类型已经在函数头部以 (Double) => Double给出了。
    * 因此，valueAtOneQuarter的类型为：((Double) => Double) => Double
    * 由于valueAtOneQuarter是一个接受函数参数的函数,
    * 因此它被称做高阶函数（higher-order function.
    */

  /**
    * 高阶函数也可以产出另一个函数。
    * 一个函数的返回值可以是一个变量还可以是定义的函数
    * @param factor
    * @return
    */

  def mulBy(factor: Double) = (x: Double) => factor * x

  /**
    * 举例来说，mulBy(3)返回函数(x: Double) => 3 * x,
    * 这个函数在前一节你已经见过了。
    * mulBy的威力在于，它可以产出能够乘以任何数额的函数：
    * val quintuple = mulBy(5)
    * quintuple(20) // 100
    * mulBy函数有一个类型为Double的参数，
    * 返回一个类型为 (Double) => Double 的函数。
    * 因此，它的类型为：(Double) => ((Double) => Double)
    */


  /**
    * 参数（类型）推断
    *
    * 当你将一个匿名函数传递给另一个函数或方法时,
    * Scala会尽可能帮助你推断出类型信息。
    * 举例来说，你不需要将代码写成：
    * valueAtOneQuarter((x: Double) => 3 * x) // 0.75
    * 由于valueAtOneQuarter方法知道你会传入一个类型为 (Double) => Double 的函数，
    * 你可以简单地写成：valueAtOneQuarter((x) => 3 * x)
    * 作为额外奖励，对于只有一个参数的函数，你可以略去参数外围的()：
    * valueAtOneQuarter(x => 3 * x)
    * 这样更好了。如果参数在=>右侧只出现一次，你可以用_替换掉它：
    * valueAtOneQuarter(3 * _)
    */


  /**
    * 请注意这些简写方式仅在参数类型已知的情况下有效。
    */

  //val fun_1 = 3 * _ // 错误：无法推断出类型
  val fun_2 = 3 * (_: Double) // OK
  val fun_3: (Double) => Double = 3 * _ // OK，因为我们给出了fun的类型


}
