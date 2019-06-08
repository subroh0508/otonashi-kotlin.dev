rootProject.name = "otonashikotlin.dev"

include("frontend", "backend")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "kotlin2js", "kotlin-dce-js", "org.jetbrains.kotlin.jvm" -> useModule(Dep.Plugin.kotlinGradle)
                "org.jetbrains.kotlin.frontend" -> useModule(Dep.Plugin.kotlinFrontend)
                "kotlinx-serialization" -> useModule(Dep.Plugin.kotlinxSerialization)
            }
        }
    }
}
