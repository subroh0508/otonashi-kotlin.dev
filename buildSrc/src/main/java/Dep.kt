@Suppress("unused")
object Dep {
    object Plugin {
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val kotlinFrontend = "org.jetbrains.kotlin:kotlin-frontend-plugin:${Versions.kotlinFrontendPlugin}"
    }

    object KotlinJs {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-js:${Versions.kotlin}"
        const val test = "org.jetbrains.kotlin:kotlin-test-js:${Versions.kotlin}"
        const val html = "org.jetbrains.kotlinx:kotlinx-html-js:${Versions.kotlinxHtml}"
        const val react = "org.jetbrains:kotlin-react:${Versions.kotlinReact}"
        const val reactDom = "org.jetbrains:kotlin-react:${Versions.kotlinReact}"
        const val wrappers = "org.jetbrains:kotlin-styled:${Versions.kotlinJsWrappers}"
        const val materialUi = "subroh0508.net.kotlinmaterialui:core:${Versions.kotlinMaterialUi}"
    }

    object Ktor {
        const val jsClient = "io.ktor:ktor-client-js:${Versions.ktor}"
    }
}
