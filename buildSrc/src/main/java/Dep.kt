@Suppress("unused")
object Dep {
    object Plugin {
        val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        val kotlinFrontend = "org.jetbrains.kotlin:kotlin-frontend-plugin:${Versions.kotlinFrontendPlugin}"
    }

    object Kotlin {
        val js = "org.jetbrains.kotlin:kotlin-stdlib-js:${Versions.kotlin}"
        val jsTest = "org.jetbrains.kotlin:kotlin-test-js:${Versions.kotlin}"
    }
}
