import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinJsDce

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
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    maven(url = "http://dl.bintray.com/kotlinx/kotlinx")
    maven(url = "http://dl.bintray.com/kotlin/kotlin-js-wrappers")
}

dependencies {
    implementation(Dep.Kotlin.js)
    implementation(Dep.Kotlin.jsHtml)
    implementation(Dep.Kotlin.jsWrapper)
    testImplementation(Dep.Kotlin.jsTest)
}

kotlinFrontend {
    sourceMaps = true

    npm { 
        dependency("core-js", "3.0.0")
        dependency("kotlin-playground")

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

val compileKotlin2Js by tasks.getting(Kotlin2JsCompile::class) {
    kotlinOptions {
        metaInfo = true
        outputFile = "${project.buildDir.path}/js/${project.name}.js"
        sourceMap = true
        sourceMapEmbedSources = "always"
        moduleKind = "commonjs"
        main = "call"
    }
}

val compileTestKotlin2Js by tasks.getting(Kotlin2JsCompile::class) {
    kotlinOptions {
        metaInfo = true
        outputFile = "${project.buildDir.path}/js-tests/${project.name}-tests.js"
        sourceMap = true
        moduleKind = "commonjs"
        main = "call"
    }
}

val copyResources by tasks.registering(Copy::class) {
    val mainSrc = kotlin.sourceSets["main"]
    from(mainSrc.resources.srcDirs)
    into(file(project.buildDir.path + "/js/min"))
}

val runDceKotlinJs by tasks.getting(KotlinJsDce::class)

afterEvaluate {
    tasks["webpack-bundle"].dependsOn(copyResources, runDceKotlinJs)
    tasks["webpack-run"].dependsOn(copyResources, runDceKotlinJs)
}
