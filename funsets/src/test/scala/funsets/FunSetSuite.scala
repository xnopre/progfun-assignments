package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contains common elements") {
    new TestSets {
      val s = intersect(s2, union(s1, s2))
      assert(!contains(s, 1), "intersect 1")
      assert(contains(s, 2), "intersect 2")
      assert(!contains(s, 3), "intersect 3")
    }
  }

  test("diff contains diff elements") {
    new TestSets {
      val s = diff(union(s1, s2), s1)
      assert(!contains(s, 1), "intersect 1")
      assert(contains(s, 2), "intersect 2")
      assert(!contains(s, 3), "intersect 3")
    }
  }

  test("filter does filter") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      val sfiltered = filter(s, x => x == 3)
      assert(!contains(sfiltered, 1), "intersect 1")
      assert(!contains(sfiltered, 2), "intersect 2")
      assert(contains(sfiltered, 3), "intersect 3")
    }
  }

  test("forall does return true") {
    val s = (x: Int) => true
    assert(forall(s, x => x < 10000), "forall 1")
  }

  test("forall does return false") {
    val s = (x: Int) => true
    assert(!forall(s, x => x < 50), "forall 2")
  }

  test("forall: {1,2,3,4}") {
    val s = (x: Int) => x >= 1 && x <= 4
    assert(forall(s, x => x < 5), "All elements in the set are strictly less than 5")
  }

  test("forall: {-1000,0}") {
    val s = (x: Int) => x == -1000 || x == 0
    assert(forall(s, x => x < 1000), "All elements in the set are strictly less than 1000")
  }

  test("forall & filter: even") {
    val setEvenNumber = (x: Int) => x % 2 == 0
    assert(forall(setEvenNumber, x => x % 2 == 0), "The set of all even numbers should contain only even numbers")
  }

  test("exists does return true") {
    val s = (x: Int) => true
    assert(exists(s, x => x == 50), "exists 1")
  }

  test("exists does return false") {
    val s = (x: Int) => x != 50
    assert(!exists(s, x => x == 50), "exists 2")
  }

  test("map does transform") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      val smapped = map(s, x => x * 2)
      assert(contains(smapped, 2), "map 1")
      assert(contains(smapped, 4), "map 2")
      assert(contains(smapped, 6), "map 3")
    }
  }

  test("forall & map: doubling numbers") {
    val s = (x: Int) => true
    val mappedS = map(s, x => x * 2)
    assert(forall(mappedS, x => x % 2 == 0), "The set obtained by doubling all numbers should contain only even numbers")
  }
}
