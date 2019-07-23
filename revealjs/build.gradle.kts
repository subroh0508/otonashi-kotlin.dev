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

kotlin {
    js {
        compilations.all {
            compileKotlinTask.kotlinOptions {
                metaInfo = true
                outputFile = "${project.buildDir.path}/js/${project.name}.js"
                sourceMap = true
                sourceMapEmbedSources = "always"
                moduleKind = "commonjs"
                main = "call"
            }
        }
        browser {
            runTask {
                devServer = KotlinWebpackConfigWriter.DevServer(
                    contentBase = listOf("${project.buildDir.path}/js/min")
                )
            }
        }
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(Dep.KotlinJs.stdlib)
                implementation(Dep.KotlinJs.html)
                implementation(Dep.KotlinJs.wrappers)

                implementation(npm("core-js", "~3.1.4"))
                implementation(npm("reveal.js"))
            }
        }
    }
}
/*
kotlinFrontend {
    sourceMaps = true

    npm {
        dependency("core-js", "~3.1.4")
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
            bundleName = "revealjs-client"
            contentPath = file(project.buildDir.path + "/js/min")
            //mode = "production"
        }
    }
}
*/

val copyBundleJs by tasks.registering(Copy::class) {
    val frontendProject = rootProject.subprojects.find { subproject -> subproject.name == "frontend" } ?: return@registering

    from(file(project.buildDir.path + "/bundle/revealjs-client.bundle.js"))
    into(file(frontendProject.kotlin.sourceSets["jsMain"].resources.srcDirs.first()))
}

val runDceJsKotlin by tasks.getting(KotlinJsDce::class)

afterEvaluate {
    tasks["build"].finalizedBy(copyBundleJs, runDceJsKotlin)
}
