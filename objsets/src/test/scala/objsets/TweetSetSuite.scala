package objsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TweetSetSuite extends FunSuite {
  trait TestSets {
    val set1 = new Empty
    val set2 = set1.incl(new Tweet("a", "a body", 20))
    val set3 = set2.incl(new Tweet("b", "b body", 20))
    val c = new Tweet("c", "c body", 7)
    val d = new Tweet("d", "d body", 9)
    val set4c = set3.incl(c)
    val set4d = set3.incl(d)
    val set5 = set4c.incl(d)
  }

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }

  def size(set: TweetSet): Int = asSet(set).size

  test("filter: on empty set") {
    new TestSets {
      assert(size(set1.filter(tw => tw.user == "a")) === 0)
    }
  }

  test("filter: a on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.user == "a")) === 1)
    }
  }

  test("filter: 20 on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.retweets == 20)) === 2)
    }
  }

//  test("filter: XN more big data") {
//    var set: TweetSet = new Empty
//    for (i <- 1 to 200000) {
//      set = set.incl(new Tweet("" + i, "a" + i, i))
//      set = set.incl(new Tweet("" + i, "b" + i, i))
//    }
//    assert(size(set.filter(tw => true)) === 400000)
//  }

  test("union: XN Empty union Empty") {
    new TestSets {
      val result = new Empty().union(new Empty)
      assert(size(result) === 0)
      assert(result.isInstanceOf[Empty])
    }
  }

  test("union: set4c and set4d") {
    new TestSets {
      assert(size(set4c.union(set4d)) === 4)
    }
  }

  test("union: with empty set (1)") {
    new TestSets {
      assert(size(set5.union(set1)) === 4)
    }
  }

  test("union: with empty set (2)") {
    new TestSets {
      assert(size(set1.union(set5)) === 4)
    }
  }

  test("union: XN more big data") {
    val count = 30;
    var set1: TweetSet = new Empty
    for (i <- 1 to count) {
      val x = 2 * i
      set1 = set1.incl(new Tweet("" + x, "" + x, x))
    }
    var set2: TweetSet = new Empty
    for (i <- 1 to count) {
      val x = 2 * i + 1
      set2 = set2.incl(new Tweet("" + x, "" + x, x))
    }
    var set3: TweetSet = new Empty
    for (i <- 1 to count) {
      val x = 1000 * i
      set3 = set3.incl(new Tweet("" + x, "" + x, x))
    }
    assert(size(set1.union(set2).union(set3)) === 3 * count+8)
  }

  test("descending: set5") {
    new TestSets {
      val trends = set5.descendingByRetweet
      assert(!trends.isEmpty)
      assert(trends.head.user == "a" || trends.head.user == "b")
    }
  }
}
