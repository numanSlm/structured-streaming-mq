// build.sbt

// Define the root project. All project-specific settings go inside this .settings block.
lazy val root = (project in file("."))
  .settings(
    // === Project Basic Settings ===
    // The name of your application. This will be part of the generated JAR's filename.
    name := "structured-streaming-mq",

    // The version of your application. Also contributes to the JAR's filename.
    version := "0.1.0-SNAPSHOT",

    // The Scala version used for compiling your project's code.
    scalaVersion := "2.13.12",

    // === Project Dependencies ===
    // Define the libraries your project depends on.
    // For this simple example, we just include the Scala standard library.
    // If you were to add Spark dependencies later, they would go here (e.g., using % "provided" for Spark).
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % scalaVersion.value
      // Example of adding Spark dependencies (uncomment and adjust when needed):
      // "org.apache.spark" %% "spark-core" % "3.5.0" % "provided",
      // "org.apache.spark" %% "spark-sql" % "3.5.0" % "provided"
    ),

    // === sbt-assembly Plugin Specific Settings ===
    // This setting tells sbt-assembly which Scala object contains the 'main' method.
    // This is the entry point for your application when the JAR is executed.
    // !! IMPORTANT: Ensure "org.structstream.mq.HelloWorld" exactly matches
    //    the fully qualified name of your main Scala object !!
    assembly / mainClass := Some("org.structstream.mq.HelloWorld"),

    // Define merge strategies for handling conflicts when creating the fat JAR.
    // This is crucial to prevent issues when multiple libraries contain files with the same path (e.g., META-INF files).
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard // Discard common META-INF conflicts
      case x => MergeStrategy.first // For other conflicting files, pick the first one encountered
    },

    // Define the output path and naming convention for the generated assembly JAR.
    // This line places the JAR directly into a 'resource' folder at your project's root.
    // The JAR will be named something like 'structured-streaming-mq-assembly-0.1.0-SNAPSHOT.jar'.
    assembly / assemblyOutputPath := baseDirectory.value / "resources" / s"${name.value}-assembly-${version.value}.jar"
  )