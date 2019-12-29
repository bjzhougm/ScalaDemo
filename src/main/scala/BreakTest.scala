import scala.util.control.Breaks

object BreakTest {
  def main(args: Array[String]): Unit = {
    breakTest
    //doubleBreak
  }

  /**
  1.导入以下包
    import scala.util.control._
  2.创建 Breaks 对象
    val loop = new Breaks;
  3.在 breakable 中循环
    loop.breakable{
        // 循环
        for(...){
          ....
        // 循环中断
          loop.break;
        }
    }
    */
  def breakTest(): Unit ={
    //定义常量list
    val list =List(1,2,3,4,5,6,7,8,9);
    //创建Breaks的对象
    val loop =new Breaks;

    loop.breakable{
      //把list的值循环赋给变量a ，a无需定义类型
      //通过a来打印list的各个值
      for(a<-list){
        println("value of a"+a)
        if(a==4){
          loop.break();
        }
      }
    }
    println("after the loop")
  }

  /**
    * 嵌套跳出循环
    */

  def doubleBreak(): Unit ={
    //定义两个list
    val oneList = List(1,2,3,4,5)
    val twoList = List(11,12,13)

    //定义两个breaks
    val out =new Breaks
    val inner =new Breaks

    out.breakable{
      for(a<-oneList){
          println("value of a= "+a)
          inner.breakable{
            for(b<-twoList) {
              println("value of b= "+b)
              if(b==12){
                inner.break()
              }
            }
          }//内嵌循环中断
      }
    }//外循环中断
  }
}
