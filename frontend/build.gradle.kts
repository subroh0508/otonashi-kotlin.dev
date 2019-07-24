import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfigWriter
import org.jetbrains.kotlin.gradle.tasks.KotlinJsDce

plugins {
    kotlin("js")
    id("kotlin-dce-js")
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

val resourceDir = "${rootProject.buildDir}/js/packages/${rootProject.name}-${project.name}/js/min"

kotlin {
    target {
        useCommonJs()
        browser {
            runTask {
                sourceMaps = true
                devServer = KotlinWebpackConfigWriter.DevServer(
                    port = 8088,
                    contentBase = listOf(resourceDir)
                )
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

                implementation(npm("core-js", "~3.1.4"))
                implementation(npm("text-encoding"))
                implementation(npm("bufferutil"))
                implementation(npm("fs"))
                implementation(npm("utf-8-validate"))
                implementation(npm("kotlin-playground"))
                implementation(npm("react"))
                implementation(npm("react-dom"))
                implementation(npm("@reach/router"))
                implementation(npm("react-markdown"))
                implementation(npm("@jetbrains/kotlin-styled", "1.0.0-pre.80"))
                implementation(npm("styled-components", "3.4.10"))
                implementation(npm("inline-style-prefixer"))
                implementation(npm("react-swipeable-views"))
                implementation(npm("@material-ui/core"))
                implementation(npm("reveal.js"))
            }
        }
    }
}

val copyResources by tasks.registering(Copy::class) {
    val mainSrc = kotlin.sourceSets["main"]
    from(mainSrc.resources.srcDirs)
    into(file(resourceDir))
}

// 動かない
// Kotlin/JSでWebpackのoptimizeやdceができるようになるのは1.3.50から
// https://youtrack.jetbrains.com/issue/KT-32323
val runDceKotlin by tasks.getting(KotlinJsDce::class)

afterEvaluate {
    tasks["browserWebpack"].dependsOn(copyResources, runDceKotlin)
    tasks["browserRun"].dependsOn(copyResources, runDceKotlin)
}
