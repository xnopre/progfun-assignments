object week4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(59); 
  val x = List(('t', 9), ('e', 1), ('x', 3));System.out.println("""x  : List[(Char, Int)] = """ + $show(x ));$skip(11); val res$0 = 
  x.sorted;System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(10); val res$1 = 
  x(0)._1;System.out.println("""res1: Char = """ + $show(res$1));$skip(10); val res$2 = 
  x(0)._2;System.out.println("""res2: Int = """ + $show(res$2));$skip(26); val res$3 = 
  x.sortWith(_._2 < _._2);System.out.println("""res3: List[(Char, Int)] = """ + $show(res$3))}
}
