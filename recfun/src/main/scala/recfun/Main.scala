package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (r == 0) 1 
    else if (c == 0) pascal(c, r - 1) 
    else if (c == r) pascal(c - 1, r - 1) 
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def analyseChar(c: Char): Int = {
      if (c == ')') -1 
      else if (c == '(') +1 
      else 0
    }

    def countParentheses(count: Int, chars: List[Char]): Int = {
      if (count < 0) count - 1
      else if (chars.isEmpty) count
      else countParentheses(count + analyseChar(chars.head), chars.tail)
    }

    countParentheses(0, chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    val sortedcoins = coins.sorted;
    if (sortedcoins.isEmpty) 0
    else if (money <= 0) 0
    else if (sortedcoins.tail.isEmpty) { 
      if (money % sortedcoins.head == 0) 1 
      else 0 
    }
    else if (money - sortedcoins.head == 0) 1
    else countChange(money - sortedcoins.head, sortedcoins) + countChange(money, sortedcoins.tail)
  }
}
