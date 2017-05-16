organization := "com.github.davidallsopp"

name := "geohash-scala"

version := "0.5"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.11.4" % "test"
)

publishArtifact := true
publishArtifact in (Compile, packageDoc) := false
publishMavenStyle := true

publishTo <<= version { (v: String) =>
  if (v.trim.endsWith("SNAPSHOT"))
    Some("Radicalbit Snapshots" at "https://tools.radicalbit.io/maven/repository/snapshots/")
  else
    Some("Radicalbit Releases" at "https://tools.radicalbit.io/maven/repository/internal/")
}

credentials += Credentials(Path.userHome / ".artifactory" / ".archiva-snapshots")
credentials += Credentials(Path.userHome / ".artifactory" / ".archiva-releases")

org.scalastyle.sbt.ScalastylePlugin.Settings
