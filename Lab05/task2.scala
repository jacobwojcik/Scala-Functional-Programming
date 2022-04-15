object Main {
  class Angle(ang:Double){
    val value: Double = ang;
    def +(that: Angle) = new Angle(Angle.norm(this.value + that.value));
    override def toString: String = "Angle=" + this.value;
  }
  object Angle{
    def apply(ang: Double) = new Angle(norm(ang));
    @scala.annotation.tailrec
    def norm(value: Double): Double = {
      if(value > math.Pi) norm(value - 2*math.Pi)
      else if(value < -math.Pi) norm(value + 2*math.Pi)
      else return value;
    }
  }
  def main(args: Array[String]): Unit = {
    val fi1 =  Angle(1.5);
    val fi2 =  Angle(2.5);
    val fi3 = fi1 + fi2;
    println(fi1 + " "+ fi2 +" "+fi3);
  }
}

//The challenge of the second exercise is to write Angle functional class.
//It should describe the angular distance. The allowed range is between -pi and +pi.
//  That means whenever the angle with the value > +pi is requested the wrapping should happen.
//  Operations like, +, -, * by Double, / by Double need to be supported.
//  The class needs a companion object implementing factory method.

//val fi1 = Angle(1.5)
//val fi2 = Angle(2.5)
//val fi3 = fi1+fi2
//println(fi1 + " "+ fi2 +" "+fi3)
// result: Angle=1.5 Angle=2.5 Angle=-2.2831853071795862