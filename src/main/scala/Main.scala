
object Main extends App {

  val pageCount: PageCount = new PageCount

  println("Page Count is " + pageCount.getPageCount)

  println("English Count is " + pageCount.getEnglishCount)

  println("Count of Page Hit : " + pageCount.getPageHit)

}
