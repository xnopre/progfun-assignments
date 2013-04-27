object week4 {
  val x = List(('t', 9), ('e', 1), ('x', 3))      //> x  : List[(Char, Int)] = List((t,9), (e,1), (x,3))
  x.sorted                                        //> res0: List[(Char, Int)] = List((e,1), (t,9), (x,3))
  x(0)._1                                         //> res1: Char = t
  x(0)._2                                         //> res2: Int = 9
  x.sortWith(_._2 < _._2)                         //> res3: List[(Char, Int)] = List((e,1), (x,3), (t,9))
}