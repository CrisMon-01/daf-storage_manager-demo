import sbt._

object Resolvers {

  val cloudera = "cloudera" at "***REMOVED***://repository.cloudera.com/artifactory/cloudera-repos/"

  val ***REMOVED***      = "***REMOVED*** repo" at "***REMOVED***://nexus.***REMOVED***.***REMOVED***.it:8081/repository/maven-public/"

  val all = Seq(
    Resolver.mavenLocal,
    Resolver.sonatypeRepo("releases"),
    cloudera
//    ***REMOVED***
  )

}
