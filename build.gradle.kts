plugins {
    application
    kotlin("jvm") version "2.0.0"
}

group = "com.atlast"
version = "0.0.1"

application {
    mainClass.set("com.atlast.leet_code.ApplicationKt")
}

repositories {
    mavenCentral()
}
