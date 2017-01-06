/**
  * Created by akorovin on 06.01.2017.
  * Running hashing on molecules and saving to hdfs test
  */
object HashPartitionerRun {
  def main(args: Array[String]): Unit = {
    // TODO: 1. sc.parallelize dataset and create Molecule instances in List array or Seq
    // TODO: 2. hash molecules thus create HashedMolecules (todo: write hash function)
    // TODO: 3. save to HDFS (dont forget to run hdfs)
  }
}

case class Molecule(private val subject: String, private val triples: Map[String, Triple])

case class HashedMolecule(private val hash: Long, private val subject: String, private val triples: Map[String, Triple])

case class Triple(private val subject: String, private val property: String, private val obj: String)

