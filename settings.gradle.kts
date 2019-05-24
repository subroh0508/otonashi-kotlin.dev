rootProject.name = "otonashikotlin.dev"

include("frontend")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "kotlin2js", "kotlin-dce-js" -> useModule(Dep.Plugin.kotlinGradle)
                "org.jetbrains.kotlin.frontend" -> useModule(Dep.Plugin.kotlinFrontend)
            }
        }
    }
}
