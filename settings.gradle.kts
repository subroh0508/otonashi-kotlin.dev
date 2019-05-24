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
                "kotlin2js", "kotlin-dce-js" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.31")
                "org.jetbrains.kotlin.frontend" -> useModule("org.jetbrains.kotlin:kotlin-frontend-plugin:0.0.45")
            }
        }
    }
}
