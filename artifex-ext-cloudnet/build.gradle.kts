plugins {
    java
    id("eu.cloudnetservice.juppiter") version "0.4.0"
    id("net.kyori.blossom") version "1.3.1"
}

repositories {
    mavenCentral()
    maven("https://repository.derklaro.dev/snapshots/")
    maven("https://repository.derklaro.dev/releases/")
    maven("https://s01.oss.sonatype.org/content/repositories/releases/")
    maven("https://hub.spigotmc.org/nexus/repository/public/")
    maven("https://repo.papermc.io/repository/maven-snapshots/")
    maven("https://libraries.minecraft.net")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("net.md-5:bungeecord-api:1.20-R0.3-SNAPSHOT")
    compileOnly("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")

    compileOnly("dev.derklaro.aerogel:aerogel:2.1.0")
    compileOnly("eu.cloudnetservice.cloudnet:node:4.0.0-RC10")
    compileOnly("eu.cloudnetservice.cloudnet:bridge:4.0.0-RC10")
    compileOnly("eu.cloudnetservice.cloudnet:platform-inject-api:4.0.0-RC10")

    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

//    annotationProcessor("eu.cloudnetservice.cloudnet:platform-inject-processor:4.0.0-RC10")

    compileOnly(fileTree("libs"))
}

moduleJson {
    author = "Score2"
    name = project.name
    group = project.group.toString()
    main = "${rootProject.group}.NodeArtifexCloudnetExt"
}

blossom {
    replaceToken("@project_name@", project.name)
    replaceToken("@project_version@", project.version.toString())
    replaceTokenIn("src/main/java/com/foacraft/ext/artifex/BukkitArtifexCloudnetExt.java")
    replaceTokenIn("src/main/java/com/foacraft/ext/artifex/BungeeArtifexCloudnetExt.java")
    replaceTokenIn("src/main/java/com/foacraft/ext/artifex/VelocityArtifexCloudnetExt.java")
}