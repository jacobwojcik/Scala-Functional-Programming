// The goal is to write a simple class MyDate and MyPeriod - the later representing two dates in fact. 
// IMPORTANT: Please ignore all the details like number the days per monts etc. i.e. assume we have 12 months, each has 30 days.
// The representation of the data can be anyhting except the system date object.
// You need to make choice whether to make the class functional or not. The rigth choice. 

// object test extends App {

//   val d1 = MyDate(2015, 10, 10)
//   val d2 = MyDate(2015, 11, 10)
//   val d3 = d2.nextDay() 

//   println( d1 +" "+ d2 +" "+ d3 )
//   println( (d1 < d2) + " " + (d2 < d1) )

//   val days: Int = d1 - d2
//   println("dni " + days + " " +(d2 - d1))
//   val period = MyPeriod(begin=d1, end=d2  )
//   println( " " + d1 +" "+ d2 + " " + period + " "+period.days)

//   /* expected result

//    2015-10-10 2015-11-10 2015-11-11
//    true false
//    dni 32 32
//    2015-10-10 2015-11-10 < 2015-10-10 : 2015-11-10 > 32
//    */
// }

object Main {
 def main(args: Array[String]): Unit = {
   val d1 = MyDate(2015, 10, 10)
   val d2 = MyDate(2015, 11, 10)
   val d3 = d2.nextDay()

   println( d1 +" "+ d2 +" "+ d3 )
   println( (d1 < d2) + " " + (d2 < d1) )

   val days: Int = d1 - d2
   println("dni " + days + " " +(d2 - d1))
   val period = MyPeriod(begin=d1, end=d2  )

   println( " " + d1 +" "+ d2 + " " + period + " "+period.days)


 }
 class MyDate(val year: Integer, val month: Integer, val day: Integer){
   override def toString: String = {
     year + "-" + month + "-" + day
   }
   def nextDay(): MyDate = {
      if(day == 30) return MyDate(year, month + 1, 1)
      MyDate(year, month, day + 1)
   }
   def <(a: MyDate): Boolean = {
     if(a.year < this.year) return false
     if(a.month < this.month) return false
     if(a.day < this.day) return false
     return true
   }
   def -(a: MyDate): Integer = {
     var days1 = a.year * 365 + a.month*30 + a.day;
     val days2 = this.year * 365 + this.month*30 + this.day;
     return Math.abs(days1- days2)
   }
 }
 object MyDate {
   def apply(year: Integer, month: Integer, day: Integer): MyDate= new MyDate(year, month, day);
 }

 class MyPeriod(val begin: MyDate, val end: MyDate){
   override def toString: String = {
     "<" + begin + " : " + end + ">"
   }
   def days: Int = end - begin
 }
 object MyPeriod {
   def apply(begin: MyDate, end: MyDate): MyPeriod= new MyPeriod(begin, end);
 }
}
