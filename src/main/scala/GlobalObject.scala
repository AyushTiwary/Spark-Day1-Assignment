import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object GlobalObject {

  Logger.getLogger("org").setLevel(Level.OFF)

  val sparkConf: SparkConf = new SparkConf()
    .setAppName("Spark-Day1_Assignment")
    .setMaster("local[4]")

  val sparkContext: SparkContext = new SparkContext(sparkConf)

  val filePath: String = "src/main/resources/pagecounts"

}
