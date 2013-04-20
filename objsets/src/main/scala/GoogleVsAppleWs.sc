import objsets._

object GoogleVsAppleWs {
  val b = GoogleVsApple                           //> b  : GoogleVsApple.type = objsets.GoogleVsApple$@744a6cbf
  
  val nums = List(1, 2, 3, 4, 5, 6)               //> nums  : List[Int] = List(1, 2, 3, 4, 5, 6)
	nums.exists((n) => {
		print(n)
		false
	})                                        //> 123456res0: Boolean = false
  
    //GoogleVsApple.googleTweets foreach println
  
}