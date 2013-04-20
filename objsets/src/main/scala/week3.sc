import objsets._

object week3 {
 def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }                                               //> asSet: (tweets: objsets.TweetSet)Set[objsets.Tweet]

  def size(set: TweetSet): Int = asSet(set).size  //> size: (set: objsets.TweetSet)Int
  
  val gizmodoTweets = TweetReader.ParseTweets.getTweetData("gizmodo", TweetData.gizmodo)
                                                  //> gizmodoTweets  : List[objsets.Tweet] = List(User: gizmodo
                                                  //| Text: Kindle Paperwhite Review: Forget Everything Else, This Is the E-Reader
                                                  //|  You Want http://t.co/737W6aNC [51], User: gizmodo
                                                  //| Text: These new Apple patents give a sneak peek at what future iPhone camera
                                                  //| s might have in store. http://t.co/0YT9rjxp [49], User: gizmodo
                                                  //| Text: Ever wonder why the sky is dark at night? Here's your answer. http://t
                                                  //| .co/eTKxkcaE [86], User: gizmodo
                                                  //| Text: The head of Homeland Security stays secure by just not using email, at
                                                  //|  all. http://t.co/W6KAFEUu [37], User: gizmodo
                                                  //| Text: This is how graphene will grow the flexible semiconductors of the futu
                                                  //| re: http://t.co/IoEvuxp4 [43], User: gizmodo
                                                  //| Text: It's the tech-based reality TV show you never knew you didn't want: ht
                                                  //| tp://t.co/j9J8gAo8 [19], User: gizmodo
                                                  //| Text: How do you make your Steve Jobs sculpture stand out? Easy, mix in some
                                                  //|  trash you stole from him. http://t.co/mvHBj3CH [15], User: gizm
                                                  //| Output exceeds cutoff limit.
  size(TweetReader.toTweetSet(gizmodoTweets))     //> res0: Int = 100
  size(TweetReader.toTweetSet(gizmodoTweets).filter(tw => true))
                                                  //> res1: Int = 100
}