import patmat.Huffman._

object week4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  val x = List(('t', 9), ('e', 1), ('x', 3));System.out.println("""x  : List[(Char, Int)] = """ + $show(x ));$skip(11); val res$0 = 
  x.sorted;System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(10); val res$1 = 
  x(0)._1;System.out.println("""res1: Char = """ + $show(res$1));$skip(10); val res$2 = 
  x(0)._2;System.out.println("""res2: Int = """ + $show(res$2));$skip(26); val res$3 = 
  x.sortWith(_._2 < _._2);System.out.println("""res3: List[(Char, Int)] = """ + $show(res$3));$skip(77); 
  
  
  def test(l: List[Int]): List[Int] = l match {
  	case Nil => Nil
  };System.out.println("""test: (l: List[Int])List[Int]""");$skip(15); val res$4 = 
  
  test(Nil);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(960); 
  //test(List(1))
  
  val bigtree = Fork(Fork(Leaf('s',121895),Fork(Leaf('d',56269),Fork(Fork(Fork(Leaf('x',5928),Leaf('j',8351),List('x', 'j'),14279),Leaf('f',16351),List('x', 'j', 'f'),30630),Fork(Fork(Fork(Fork(Leaf('z',2093),Fork(Leaf('k',745),Leaf('w',1747),List('k', 'w'),2492),List('z', 'k', 'w'),4585),Leaf('y',4725),List('z', 'k', 'w', 'y'),9310),Leaf('h',11298),List('z', 'k', 'w', 'y', 'h'),20608),Leaf('q',20889),List('z', 'k', 'w', 'y', 'h', 'q'),41497),List('x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'),72127),List('d', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'),128396),List('s', 'd', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'),250291),Fork(Fork(Leaf('o',82762),Leaf('l',83668),List('o', 'l'),166430),Fork(Fork(Leaf('m',45521),Leaf('p',46335),List('m', 'p'),91856),Leaf('u',96785),List('m', 'p', 'u'),188641),List('o', 'l', 'm', 'p', 'u'),355071),List('s', 'd', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q', 'o', 'l', 'm', 'p', 'u'),605362);System.out.println("""bigtree  : patmat.Huffman.Fork = """ + $show(bigtree ));$skip(29); val res$5 = 
  
	decode(bigtree, List(0));System.out.println("""res5: List[Char] = """ + $show(res$5))}
	
	
}
