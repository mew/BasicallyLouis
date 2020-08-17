plugins {
    java
    kotlin("jvm") version "1.4.0"
}

group = "zone.nora"
version = "1.0"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("net.dv8tion", "JDA", "4.2.0_192")
    implementation("com.github.mew", "slothpixel-jvm", "ab4e7984fc")

    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

val fatJar = task("fatJar", type = Jar::class) {
    baseName = "${project.name}-with-dependencies"
    manifest {
        attributes["Main-Class"] = "zone.nora.basicallylouis.BotKt"
    }
    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory || it.name.contains(".pom")) it else zipTree(it)
    })
    with(tasks.jar.get() as CopySpec)
}

tasks {
    "build" {
        dependsOn(fatJar)
    }
}