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

kotlin {
    target {
        useCommonJs()
        browser {}
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

val copyBundleJs by tasks.registering(Copy::class) {
    val frontendProject = rootProject.subprojects.find { subproject -> subproject.name == "frontend" } ?: return@registering

    from(file(project.buildDir.path + "/libs/${rootProject.name}-${project.name}.js"))
    into(file(frontendProject.kotlin.sourceSets["main"].resources.srcDirs.first()))
}

// 動かない
// Kotlin/JSでWebpackのoptimizeやdceができるようになるのは1.3.50から
// https://youtrack.jetbrains.com/issue/KT-32323
val runDceKotlin by tasks.getting(KotlinJsDce::class)

afterEvaluate {
    tasks["browserWebpack"].dependsOn(runDceKotlin)
}
