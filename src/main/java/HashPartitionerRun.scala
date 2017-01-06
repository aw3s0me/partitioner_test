import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

/**
  * Created by akorovin on 06.01.2017.
  * Running hashing on molecules and saving to hdfs test
  */
object HashPartitionerRun {
  def main(args: Array[String]): Unit = {
    // TODO: 1. sc.parallelize dataset and create Molecule instances in List array or Seq
    val spark = SparkSession.
      builder().
      master("local").
      appName("partition").
      getOrCreate()

    // Fig 3: RDF-MT Creation MULDER Paper (a)
    val moleculeInstances = Seq(
      Molecule("s1", Map(
        "p1" -> Triple("s1", "p1", "o1", false),
        "p2" -> Triple("s1", "p2", "os2", false),
        "p3" -> Triple("s1", "p3", "o3", false),
        "p4" -> Triple("s1", "p4", "o4", false),
        "p3" -> Triple("s1", "p3", "o5", false))),
      Molecule("os2", Map(
        "p3" -> Triple("os2", "p3", "o3", false),
        "p6" -> Triple("os2", "p6", "s3", false))),
      Molecule("s3", Map(
        "p3" -> Triple("s3", "p3", "o6", false),
        "p7" -> Triple("s3", "p7", "s4", false))),
      Molecule("s4", Map(
        "p3" -> Triple("s4", "p3", "o7", false),
        "p8" -> Triple("s4", "p8", "8175133", true)))
    )

    // TODO: 2. hash molecules thus create HashedMolecules (todo: write hash function)
    // TODO: 3. save to HDFS (dont forget to run hdfs)
  }
}

case class Molecule(private val subject: String, private val triples: Map[String, Triple])

case class HashedMolecule(private val hash: Long, private val subject: String, private val triples: Map[String, Triple])

case class Triple( private val subject: String,
                   private val property: String,
                   private val obj: String,
                   private val isDatatype: Boolean)
