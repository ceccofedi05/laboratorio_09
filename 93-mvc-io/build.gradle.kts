plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.88.0"
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("com.github.spotbugs:spotbugs-annotations:4.9.0")
}

application {
    mainClass.set("it.unibo.mvc.SimpleGUI")
}

tasks.javadoc {
    isFailOnError = false
}
