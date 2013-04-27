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
    assert(combine(leaflist) === List(Leaf('x', 9), Fork(Leaf('e', 7), Leaf('t', 8), List('e', 't'), 15)))
  }

  test("XN : until") {
    val trees = List(Leaf('e', 7), Leaf('t', 8), Leaf('x', 9))
    val tree = until(singleton, combine)(trees);
    val expected = Fork(Leaf('x', 9), Fork(Leaf('e', 7), Leaf('t', 8), List('e', 't'), 15), List('x', 'e', 't'), 24);
    assert(tree === expected)
  }

  test("XN : createCodeTree") {
    val tree = createCodeTree(List('a', 'b', 'a', 'c', 'b', 'a'))
    val expected = Fork(Fork(Leaf('c', 1), Leaf('b', 2), List('c', 'b'), 3), Leaf('a', 3), List('c', 'b', 'a'), 6);
    assert(tree === expected)
  }

  test("XN : decode #1") {
    val code = Fork(Leaf('e', 1), Leaf('f', 1), List('e', 'f'), 2)
    assert(decode(code, List(0)) === List('e'))
  }

  test("XN : decode #2") {
    val code = Fork(Leaf('e', 1), Leaf('f', 1), List('e', 'f'), 2)
    val secret: List[Bit] = List(0, 1, 0)
    val result: List[Char] = decode(code, secret)
    val expected: List[Char] = List('e', 'f', 'e')
    assert(result === expected)
  }

  test("XN : decode #3") {
    val code = Fork(Fork(Leaf('e', 1), Leaf('f', 1), List('e', 'f'), 2), Fork(Leaf('g', 1), Leaf('h', 1), List('g', 'h'), 2), List('e', 'f', 'g', 'h'), 4)
    val secret: List[Bit] = List(0, 1, 1, 0, 0, 1, 0, 0, 1, 1)
    val result: List[Char] = decode(code, secret)
    val expected: List[Char] = List('f', 'g', 'f', 'e', 'h')
    assert(result === expected)
  }

  test("XN : decode") {
    val result: List[Char] = decode(frenchCode, secret)
    val expected: List[Char] = List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l')
    assert(result === expected)
  }

  test("XN : encode #1") {
    val code = Fork(Leaf('e', 1), Leaf('f', 1), List('e', 'f'), 2)
    val text: List[Char] = List('e')
    val result: List[Bit] = encode(code)(text)
    val expected: List[Bit] = List(0)
    assert(result === expected)
  }

  test("XN : encode #2") {
    val code = Fork(Fork(Leaf('e', 1), Leaf('f', 1), List('e', 'f'), 2), Fork(Leaf('g', 1), Leaf('h', 1), List('g', 'h'), 2), List('e', 'f', 'g', 'h'), 4)
    val text: List[Char] = List('e')
    val result: List[Bit] = encode(code)(text)
    val expected: List[Bit] = List(0, 0)
    assert(result === expected)
  }

  test("XN : encode #3") {
    val code = Fork(Fork(Leaf('e', 1), Leaf('f', 1), List('e', 'f'), 2), Fork(Leaf('g', 1), Leaf('h', 1), List('g', 'h'), 2), List('e', 'f', 'g', 'h'), 4)
    val text: List[Char] = List('g')
    val result: List[Bit] = encode(code)(text)
    val expected: List[Bit] = List(1, 0)
    assert(result === expected)
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
