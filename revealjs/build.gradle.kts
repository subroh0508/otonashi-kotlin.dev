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
    implementation(Dep.KotlinJs.stdlib)
    implementation(Dep.KotlinJs.html)
    implementation(Dep.KotlinJs.wrappers)
    testImplementation(Dep.KotlinJs.test)
}

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

val runDceKotlinJs by tasks.getting(KotlinJsDce::class)

val copyBundleJs by tasks.registering(Copy::class) {
    val frontendProject = rootProject.subprojects.find { subproject -> subproject.name == "frontend" } ?: return@registering

    from(file(project.buildDir.path + "/bundle/revealjs-client.bundle.js"))
    into(file(frontendProject.sourceSets["main"].resources.srcDirs.first()))
}

afterEvaluate {
    tasks["webpack-bundle"].dependsOn(runDceKotlinJs)
    tasks["webpack-run"].dependsOn(runDceKotlinJs)

    tasks["build"].finalizedBy(copyBundleJs)
}
