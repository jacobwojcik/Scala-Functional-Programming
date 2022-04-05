object Main {
  def main(args: Array[String]): Unit = {
    val sum1 = sumfrac( 1e-3 );
    println(sum1);

    val sum2 = sumfrac( 1e-9 );
    println(sum2);
  }
  def sumfrac(precision:Double): Double = {
    @scala.annotation.tailrec
    def innerSum(sum: Double, n: Int): Double={
      val newValue = 1/Math.pow(2,n);
      if(newValue < precision) return sum;
      innerSum( sum + newValue, n+1);
    }
    innerSum(0,0);
  }
}