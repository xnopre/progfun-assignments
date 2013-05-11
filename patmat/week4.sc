import patmat.Huffman._

object week4 {
  val x = List(('t', 9), ('e', 1), ('x', 3))      //> x  : List[(Char, Int)] = List((t,9), (e,1), (x,3))
  x.sorted                                        //> res0: List[(Char, Int)] = List((e,1), (t,9), (x,3))
  x(0)._1                                         //> res1: Char = t
  x(0)._2                                         //> res2: Int = 9
  x.sortWith(_._2 < _._2)                         //> res3: List[(Char, Int)] = List((e,1), (x,3), (t,9))
  
  
  def test(l: List[Int]): List[Int] = l match {
  	case Nil => Nil
  }                                               //> test: (l: List[Int])List[Int]
  
  test(Nil)                                       //> res4: List[Int] = List()
  //test(List(1))
  
  val bigtree = Fork(Fork(Leaf('s',121895),Fork(Leaf('d',56269),Fork(Fork(Fork(Leaf('x',5928),Leaf('j',8351),List('x', 'j'),14279),Leaf('f',16351),List('x', 'j', 'f'),30630),Fork(Fork(Fork(Fork(Leaf('z',2093),Fork(Leaf('k',745),Leaf('w',1747),List('k', 'w'),2492),List('z', 'k', 'w'),4585),Leaf('y',4725),List('z', 'k', 'w', 'y'),9310),Leaf('h',11298),List('z', 'k', 'w', 'y', 'h'),20608),Leaf('q',20889),List('z', 'k', 'w', 'y', 'h', 'q'),41497),List('x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'),72127),List('d', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'),128396),List('s', 'd', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q'),250291),Fork(Fork(Leaf('o',82762),Leaf('l',83668),List('o', 'l'),166430),Fork(Fork(Leaf('m',45521),Leaf('p',46335),List('m', 'p'),91856),Leaf('u',96785),List('m', 'p', 'u'),188641),List('o', 'l', 'm', 'p', 'u'),355071),List('s', 'd', 'x', 'j', 'f', 'z', 'k', 'w', 'y', 'h', 'q', 'o', 'l', 'm', 'p', 'u'),605362)
                                                  //> bigtree  : patmat.Huffman.Fork = Fork(Fork(Leaf(s,121895),Fork(Leaf(d,56269
                                                  //| ),Fork(Fork(Fork(Leaf(x,5928),Leaf(j,8351),List(x, j),14279),Leaf(f,16351),
                                                  //| List(x, j, f),30630),Fork(Fork(Fork(Fork(Leaf(z,2093),Fork(Leaf(k,745),Leaf
                                                  //| (w,1747),List(k, w),2492),List(z, k, w),4585),Leaf(y,4725),List(z, k, w, y)
                                                  //| ,9310),Leaf(h,11298),List(z, k, w, y, h),20608),Leaf(q,20889),List(z, k, w,
                                                  //|  y, h, q),41497),List(x, j, f, z, k, w, y, h, q),72127),List(d, x, j, f, z,
                                                  //|  k, w, y, h, q),128396),List(s, d, x, j, f, z, k, w, y, h, q),250291),Fork(
                                                  //| Fork(Leaf(o,82762),Leaf(l,83668),List(o, l),166430),Fork(Fork(Leaf(m,45521)
                                                  //| ,Leaf(p,46335),List(m, p),91856),Leaf(u,96785),List(m, p, u),188641),List(o
                                                  //| , l, m, p, u),355071),List(s, d, x, j, f, z, k, w, y, h, q, o, l, m, p, u),
                                                  //| 605362)
  
	decode(bigtree, List(0))                  //> scala.MatchError: Fork(Leaf(s,121895),Fork(Leaf(d,56269),Fork(Fork(Fork(Lea
                                                  //| f(x,5928),Leaf(j,8351),List(x, j),14279),Leaf(f,16351),List(x, j, f),30630)
                                                  //| ,Fork(Fork(Fork(Fork(Leaf(z,2093),Fork(Leaf(k,745),Leaf(w,1747),List(k, w),
                                                  //| 2492),List(z, k, w),4585),Leaf(y,4725),List(z, k, w, y),9310),Leaf(h,11298)
                                                  //| ,List(z, k, w, y, h),20608),Leaf(q,20889),List(z, k, w, y, h, q),41497),Lis
                                                  //| t(x, j, f, z, k, w, y, h, q),72127),List(d, x, j, f, z, k, w, y, h, q),1283
                                                  //| 96),List(s, d, x, j, f, z, k, w, y, h, q),250291) (of class patmat.Huffman$
                                                  //| Fork)
                                                  //| 	at patmat.Huffman$.decode2$1(Huffman.scala:199)
                                                  //| 	at patmat.Huffman$.decodeOnLeft$1(Huffman.scala:172)
                                                  //| 	at patmat.Huffman$.decode2$1(Huffman.scala:196)
                                                  //| 	at patmat.Huffman$.decode(Huffman.scala:206)
                                                  //| 	at week4$$anonfun$main$1.apply$mcV$sp(week4.scala:20)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	
                                                  //| Output exceeds cutoff limit.
	
	
}