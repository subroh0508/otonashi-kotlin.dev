import org.jetbrains.kotlin.gradle.tasks.KotlinJsDce

plugins {
    kotlin("js")
}

group = "net.subroh0508.otonashikotlin.dev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    maven(url = "http://dl.bintray.com/kotlinx/kotlinx")
    maven(url = "http://dl.bintray.com/kotlin/kotlin-js-wrappers")
}

kotlin {
    target {
        useCommonJs()
        browser {
            webpackTask {
                sourceMaps = false
                outputFileName = "revealjs-client.bundle.js"
            }
        }
    }

    sourceSets {
        val main by getting {
            dependencies {
                implementation(Dep.KotlinJs.stdlib)
                implementation(Dep.KotlinJs.html)
                implementation(Dep.KotlinJs.wrappers)

                implementation(npm("core-js", "~3.1.4"))
                implementation(npm("css-loader"))
                implementation(npm("style-loader"))
                implementation(npm("url-loader"))
                implementation(npm("reveal.js"))
            }
        }
    }
}
