import objsets._

object GoogleVsAppleWs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(66); 
  val b = GoogleVsApple;System.out.println("""b  : GoogleVsApple.type = """ + $show(b ));$skip(39); 
  
  val nums = List(1, 2, 3, 4, 5, 6);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(45); val res$0 = 
	nums.exists((n) => {
		print(n)
		false
	});System.out.println("""res0: Boolean = """ + $show(res$0))}
  
    //GoogleVsApple.googleTweets foreach println
  
}
