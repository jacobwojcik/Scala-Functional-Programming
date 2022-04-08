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

// It is about using tail-recursive function to sum fractions 1/(2^n):
// 1, 1/2, 1/4, 1/8, 1/16 etc...

// The summation should stop when the value of the fraction to be added in the next recursion
// is less than a precision parameter passed as an argument.
// example invocation:

// val sum1 = sumfrac( 1e-3 )
// val sum2 = sumfrac( 1e-9 )

// A technique using default parameters or inner function can be used.