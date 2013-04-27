package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("XN : weight of a Leaf") {
    new TestTrees {
      assert(weight(Leaf('a', 2)) === 2)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("XN : chars of a Leaf") {
    new TestTrees {
      assert(chars(Leaf('b', 3)) === List('b'))
    }
  }

  test("XN : test for 'times' #1 : times(Nil)") {
    assert(times(Nil) === Nil)
  }

  test("XN : test for 'times' #2 : 1 char") {
    assert(times(List('a')) === List(('a', 1)))
  }

  test("XN : test for 'times' #3 : unrepeated chars") {
    assert(times(List('c', 'b', 'a')) === List(('a', 1), ('b', 1), ('c', 1)))
  }

  test("XN : test for 'times' #4") {
    assert(times(List('a', 'b', 'a')) === List(('a', 2), ('b', 1)))
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }

  test("XN : makeOrderedLeafList for some frequency table : change freq") {
    assert(makeOrderedLeafList(List(('t', 9), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('x', 3), Leaf('t', 9)))
  }

  test("XN : singleton on Nil") {
    assert(singleton(Nil) === false)
  }

  test("XN : singleton on list with 1 leaf") {
    assert(singleton(List(Leaf('e', 5))) === true)
  }

  test("XN : singleton on list with 1 fork") {
    assert(singleton(List(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5))) === true)
  }

  test("XN : singleton on list with 2 trees") {
    assert(singleton(List(Leaf('e', 5), Leaf('e', 5), Leaf('e', 5))) === false)
  }

  test("XN : combine on empty list Nil") {
    assert(combine(Nil) === Nil)
  }

  test("XN : combine on list with 1 elements") {
    assert(combine(List(Leaf('p', 7))) === List(Leaf('p', 7)))
  }

  test("XN : combine on list with 2 elements grouped in 1 fork") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
  }

  test("XN : combine of some leaf list : + preserve weigth order") {
    val leaflist = List(Leaf('e', 7), Leaf('t', 8), Leaf('x', 9))
    assert(combine(leaflist) === List(Leaf('x', 9),Fork(Leaf('e', 7), Leaf('t', 8), List('e', 't'), 15)))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
