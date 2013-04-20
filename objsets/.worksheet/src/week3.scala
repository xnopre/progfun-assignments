import objsets._

object week3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(145); 
 def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  };System.out.println("""asSet: (tweets: objsets.TweetSet)Set[objsets.Tweet]""");$skip(50); 

  def size(set: TweetSet): Int = asSet(set).size;System.out.println("""size: (set: objsets.TweetSet)Int""");$skip(92); 
  
  val gizmodoTweets = TweetReader.ParseTweets.getTweetData("gizmodo", TweetData.gizmodo);System.out.println("""gizmodoTweets  : List[objsets.Tweet] = """ + $show(gizmodoTweets ));$skip(46); val res$0 = 
  size(TweetReader.toTweetSet(gizmodoTweets));System.out.println("""res0: Int = """ + $show(res$0));$skip(65); val res$1 = 
  size(TweetReader.toTweetSet(gizmodoTweets).filter(tw => true));System.out.println("""res1: Int = """ + $show(res$1))}
}
