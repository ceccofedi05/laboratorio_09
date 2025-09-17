plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.141.0"
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("com.github.spotbugs:spotbugs-annotations:4.9.6")
}

application {
    mainClass.set("it.unibo.mvc.SimpleGUI")
}

tasks.javadoc {
    isFailOnError = false
}
