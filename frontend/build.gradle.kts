import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
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

val resourcesDir = "${rootProject.buildDir}/js/packages/${rootProject.name}-${project.name}/kotlin/resources"

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
                archiveFileName = "otonashikotlin.dev-frontend.js"
            }
            webpackTask {
                sourceMaps = true
                archiveFileName = "otonashikotlin.dev-frontend.js"
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
                implementation(npm("reveal.js"))
            }
        }
    }
}

val copyResources by tasks.registering(Copy::class) {
    val mainSrc = kotlin.sourceSets["main"]
    from(mainSrc.resources.srcDirs)
    into(file(resourcesDir))
}

// 動かない
// Kotlin/JSでWebpackのoptimizeやdceができるようになるのは1.3.50から
// https://youtrack.jetbrains.com/issue/KT-32323

val runDceKotlin by tasks.getting(KotlinJsDce::class) {
    dceOptions {
        outputDirectory = tasks.compileKotlinJs.get().outputFile.parent
    }
}

afterEvaluate {
    tasks["browserWebpack"].dependsOn(copyResources, runDceKotlin)
    tasks["browserRun"].dependsOn(copyResources, runDceKotlin)
}
