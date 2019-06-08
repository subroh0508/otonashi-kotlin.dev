import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm")
    id("kotlinx-serialization")
}

group = "backend"
version = "1.0-SNAPSHOT"
application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")

repositories {
    mavenLocal()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
    maven { url = uri("https://kotlin.bintray.com/kotlinx") }
}

dependencies {
    compile(Dep.KotlinJvm.stdlib)
    compile(Dep.Ktor.serverCore)
    compile(Dep.Ktor.serverNetty)
    compile(Dep.Ktor.gson)
    compile(Dep.Ktor.locations)
    compile(Dep.logbook)
    testCompile(Dep.Ktor.serverTest)
}

val compileKotlin by tasks.getting(KotlinCompile::class) {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf(
            "-Xuse-experimental=kotlin.Experimental"
        )
    }
}
