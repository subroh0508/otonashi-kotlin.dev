@Suppress("unused")
object Dep {
    object Plugin {
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val kotlinFrontend = "org.jetbrains.kotlin:kotlin-frontend-plugin:${Versions.kotlinFrontendPlugin}"
        const val kotlinxSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    }

    object KotlinJvm {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
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
        const val serverCore = "io.ktor:ktor-server-core:${Versions.ktor}"
        const val serverNetty = "io.ktor:ktor-server-netty:${Versions.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging-jvm:${Versions.ktor}"
        const val jsonCommon = "io.ktor:ktor-client-json:${Versions.ktor}"
        const val jsonJvm = "io.ktor:ktor-client-json-jvm:${Versions.ktor}"
        const val jsClient = "io.ktor:ktor-client-js:${Versions.ktor}"

        const val serverTest = "io.ktor:ktor-server-tests:${Versions.ktor}"
    }

    const val logbook = "ch.qos.logback:logback-classic:${Versions.logback}"
}
