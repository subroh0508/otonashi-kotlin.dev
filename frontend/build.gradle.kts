plugins {
    id("kotlin2js")
    id("kotlin-dce-js")
    id("org.jetbrains.kotlin.frontend")
}

group = "net.subroh0508.otonashikotlin.dev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(Dep.Kotlin.js)
    testImplementation(Dep.Kotlin.jsTest)
}
