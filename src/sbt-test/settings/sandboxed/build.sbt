import protocbridge.{SandboxedJvmGenerator, Artifact}

scalaVersion := "2.13.1"

val scalaGen = SandboxedJvmGenerator.forModule(
  "scala",
  Artifact(
    "com.thesamet.scalapb",
    "compilerplugin_2.12",
    "0.9.6"
  ),
  "scalapb.ScalaPbCodeGenerator$",
  suggestedDependencies = Seq(
    Artifact("com.thesamet.scalapb", "scalapb-runtime", "0.9.6", true)
  )
)

Compile / PB.targets := Seq(scalaGen -> (Compile / sourceManaged).value)

libraryDependencies += "com.google.protobuf" % "protobuf-java" % "3.8.0" % "protobuf"
