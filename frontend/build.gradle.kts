import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfigWriter
import org.jetbrains.kotlin.gradle.tasks.KotlinJsDce

plugins {
    kotlin("multiplatform")
    id("kotlin-dce-js")
}

group = "net.subroh0508.otonashikotlin.dev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap-1.1")
    maven(url = "http://dl.bintray.com/kotlinx/kotlinx")
    maven(url = "http://dl.bintray.com/kotlin/kotlin-js-wrappers")
}

val resourceDir = "${rootProject.buildDir}/js/packages/${rootProject.name}-${project.name}/js/min"

kotlin {
    js {
        useCommonJs()
        browser {
            runTask {
                sourceMaps = true
                devServer = KotlinWebpackConfigWriter.DevServer(
                    contentBase = listOf(compilation.output.resourcesDir.canonicalPath)
                )
            }
        }
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(Dep.KotlinJs.stdlib)
                implementation(Dep.KotlinJs.html)
                implementation(Dep.KotlinJs.react)
                implementation(Dep.KotlinJs.reactDom)
                implementation(Dep.KotlinJs.wrappers)
                implementation(Dep.KotlinJs.materialUi)
                implementation(Dep.Ktor.jsClient)

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

/*
kotlinFrontend {
    sourceMaps = true

    npm {
        dependency("kotlin-playground")
        dependency("react")
        dependency("react-dom")
        dependency("@reach/router")
        dependency("react-markdown")
        dependency("inline-style-prefixer")
        dependency("react-swipeable-views")
        dependency("reveal.js")

        devDependency("css-loader")
        devDependency("style-loader")
        devDependency("file-loader")
        devDependency("url-loader")
        devDependency("babel-loader")
        devDependency("babel-core")
        devDependency("karma")
    }

    bundle<WebPackExtension>("webpack") {
        (this as WebPackExtension).apply {
            bundleName = "main"
            contentPath = file(project.buildDir.path + "/js/min")
            //mode = "production"
        }
    }
}

*/

val copyResources by tasks.registering(Copy::class) {
    val mainSrc = kotlin.sourceSets["jsMain"]
    from(mainSrc.resources.srcDirs)
    into(file(resourceDir))
}

val runDceJsKotlin by tasks.getting(KotlinJsDce::class)

afterEvaluate {
    tasks["build"].dependsOn(copyResources, runDceJsKotlin)
    tasks["jsRun"].dependsOn(copyResources, runDceJsKotlin)
}
