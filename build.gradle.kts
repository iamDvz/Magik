plugins {
    java
    `maven-publish`
    `java-library`
    id("io.papermc.paperweight.userdev") version "1.6.3"
}


group = "groupId"
version = "0.1"
description = "Magik"

repositories {
    mavenLocal()
    maven (url = "https://jitpack.io")
    maven (url = "https://repo.papermc.io/repository/maven-public/")
    maven (url = "https://oss.sonatype.org/content/groups/public/")
    maven (url = "https://repo.codemc.org/repository/maven-public/")
    maven (url = "https://repo.destroystokyo.com/repository/maven-public/")
    maven (url = "https://repo.citizensnpcs.co")
    maven (url = "https://repo.dmulloy2.net/repository/public/")
    maven (url = "https://repo.maven.apache.org/maven2/")
}

dependencies {
    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

}
java.sourceCompatibility = JavaVersion.VERSION_17

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}
