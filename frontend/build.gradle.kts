import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
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

val resourcesDir = "${project.buildDir}/processedResources/Js/main"

kotlin {
    target {
        useCommonJs()
        browser {
            runTask {
                sourceMaps = true
                devServer = KotlinWebpackConfig.DevServer(
                    port = 8088,
                    contentBase = listOf(resourcesDir)
                )
                outputFileName = "otonashikotlin.dev-frontend.js"
            }
            webpackTask {
                sourceMaps = false
                outputFileName = "otonashikotlin.dev-frontend.js"
            }
        }
    }

    sourceSets {
        val main by getting {
            dependencies {
                implementation(Dep.KotlinJs.stdlib)
                implementation(Dep.KotlinJs.html)
                implementation(Dep.KotlinJs.react)
                implementation(Dep.KotlinJs.reactDom)
                implementation(Dep.KotlinJs.wrappers)
                implementation(Dep.KotlinJs.materialUi)
                implementation(Dep.Ktor.jsClient)

                implementation(npm("text-encoding"))
                implementation(npm("kotlin-playground"))
                implementation(npm("@reach/router"))
                implementation(npm("react-markdown"))
                implementation(npm("react-swipeable-views"))
                implementation(npm("styled-components"))
                implementation(npm("inline-style-prefixer"))
                implementation(npm("reveal.js"))
            }
        }
    }
}
