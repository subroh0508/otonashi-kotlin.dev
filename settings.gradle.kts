rootProject.name = "otonashikotlin.dev"

include("frontend", "backend", "revealjs")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            when {
                requested.id.id.startsWith("org.jetbrains.kotlin")
                        || requested.id.id == "kotlin-dce-js" -> useModule(Dep.Plugin.kotlinGradle)
                requested.id.id == "kotlinx-serialization" -> useModule(Dep.Plugin.kotlinxSerialization)
            }
        }
    }
}
