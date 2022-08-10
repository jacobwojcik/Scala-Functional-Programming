// The idea is to provide traits that can be used to decorate strings that, when printed,
// show additional HTML tags or modified in some other way. 

//   // example code
//   class StringWrap (val s: String ) {
//     override def toString() = s
//   }

//   class Pre( val text: String)  extends StringWrap(text) with htmlH2 with htmlI {}
//   val h = new Pre("Pargraph heading")
//   println(h)

//   class X(val text:String, override val llen: Int) extends StringWrap(text) with Capitalisation with PageStretch
//   println(new X("abra ka dabra", 50))
//   println(new X("abra ka dabra", 30))
//   println(new X("abra ka dabra", 20))
//   val z = new StringWrap("a tricky text with tricky content") with PageStretch
//   println(z)

//   /* spodziewany wynik
// <I><H2>Paragraph heading</H2></I>
// Abra            ka            dabra
// Abra     ka     dabra
// Abra  ka  dabra
// a       tricky       text       with       tricky       content
//    */

object Main {
  def main(args: Array[String]): Unit = {
    class Pre( val text: String)  extends StringWrap(text) with htmlH2 with htmlI {}
    val h = new Pre("Pargraph heading")
    println(h)

    class X(val text:String, override val llen: Int) extends StringWrap(text) with Capitalisation with PageStretch
    println(new X("abra ka dabra", 50))
    println(new X("abra ka dabra", 30))
    println(new X("abra ka dabra", 20))
    val z = new StringWrap("a tricky text with tricky content") with PageStretch

    println(z)
  }

  trait htmlH2{
    override def toString: String = "<H2>"  + super.toString+ "</H2>"
  }
  trait htmlI{
    override def toString: String = "<I>"  + super.toString+ "</I>"
  }

  trait Capitalisation{
    override def toString: String = {
      super.toString.capitalize
    }
  }
  trait PageStretch{
    val llen = 50
    override def toString: String = {{
        val spacesToAdd = llen - super.toString.length
        val strSpaces = super.toString.split(" ").length - 1
        val spaces: String= (" " * (spacesToAdd/strSpaces + 1))
        return super.toString.split(" ").mkString(spaces)
      }
    }

  }
  class StringWrap(val s: String){
    override def toString: String = {
      s
    }
  }
  object StringWrap {
    def apply(s: String): StringWrap= new StringWrap(s);
  }
}

