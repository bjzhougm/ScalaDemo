/**
  * Created by IntelliJ IDEA.
  * User: zhougm
  * Date: 2019-04-08
  * Time: 17:00
  */

/**
  * 1.定义不带private 的 var field 此时scala生成的面向jvm的类时，
  * 会定义为private 的name 字段,并提供public的getter和setter方法
  * 2.如果使用private 修饰field,则生成的getter和setter也是private的
  * 3.定义val field ,则只会生成getter方法
  * 4.如果不希望生成getter和setter方法，则将field声明为private[this]
  */
class Student {

  private var myName ="leo";

  def name ="your name is " +myName

  def name_=(newName:String): Unit = println("you can't edit your name")

  def updateName(newName:String): Unit ={
    if(newName =="leo1") myName = newName
    else println("not accept this new name!!!")
  }


  private var myAge = 0

  def age_=(newAge:Int): Unit ={
    if(newAge > 0) myAge = newAge
    else println("illegal age !!!")
  }

  def age = myAge
}
