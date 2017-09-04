import java.io.{File, PrintWriter}
import org.apache.spark.rdd.RDD
import GlobalObject._

class PageCount {

  def pagecounts: RDD[String] = {
    sparkContext.textFile(filePath)
  }

  val destinationFilePath = "src/main/resources"

  new File(destinationFilePath).mkdir()

  new PrintWriter(destinationFilePath + "/pagecounts-destination.txt") {
    write(pagecounts.take(10).mkString("\n"))
    close
  }

  def getPageCount: Double = {
    pagecounts.count()
  }

  def getEnglishRDD: RDD[String] = {
    pagecounts.filter(_.split(" ")(0) == "en")
  }

  def getEnglishCount: Long = {
    pagecounts.filter(_.split(" ")(0) == "en").count()
  }

  def getPageHit = {
    pagecounts.map(data => (data.split(" ")(1), data.split(" ")(2).toInt)).reduceByKey(_ + _).filter(_._2 > 200000).
      collect().toList
  }

}
