@Suppress("unused")
object Dep {
    object Plugin {
        val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        val kotlinFrontend = "org.jetbrains.kotlin:kotlin-frontend-plugin:${Versions.kotlinFrontendPlugin}"
    }

    object KotlinJs {
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-js:${Versions.kotlin}"
        val test = "org.jetbrains.kotlin:kotlin-test-js:${Versions.kotlin}"
        val html = "org.jetbrains.kotlinx:kotlinx-html-js:${Versions.kotlinxHtml}"
        val react = "org.jetbrains:kotlin-react:${Versions.kotlinReact}"
        val reactDom = "org.jetbrains:kotlin-react:${Versions.kotlinReact}"
        val wrappers = "org.jetbrains:kotlin-styled:${Versions.kotlinJsWrappers}"
        val materialUi = "subroh0508.net.kotlinmaterialui:core:${Versions.kotlinMaterialUi}"
    }
}
