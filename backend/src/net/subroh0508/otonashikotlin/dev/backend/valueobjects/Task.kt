package net.subroh0508.otonashikotlin.dev.backend.valueobjects

interface Task {
    val pathname: String

    enum class Builders(override val pathname: String) : Task
    enum class Collections(override val pathname: String) : Task
    enum class Conventions(override val pathname: String) : Task
    enum class Generics(override val pathname: String) : Task
    enum class Properties(override val pathname: String) : Task

    enum class Introduction(override val pathname: String) : Task {
        DATA_CLASSES("DataClasses"),
        DEFAULT_ARGUMENTS("DefaultArguments"),
        EXTENSION_FUNCTIONS("ExtensionFunctions"),
        EXTENSIONS_ON_COLLECTIONS("ExtensionsOnCollections"),
        HELLO_WORLD("HelloWorld"),
        LAMBDAS("Lambdas"),
        NAMED_ARGUMENTS("NamedArguments"),
        NULLABLE_TYPES("NullableTypes"),
        OBJECT_EXPRESSIONS("ObjectExpressions"),
        SAM_CONVERSIONS("SAMConversions"),
        SMART_CASTS("SmartCasts"),
    }
}