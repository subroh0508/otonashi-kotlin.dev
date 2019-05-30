package components.koans.sections

import kotlinext.js.jsObject

external class Section {
    var displayName: String
    var pathname: String
    var children: Array<Section>
}

val helloWorld: Section = jsObject {
    displayName = "Hello, World!"
    pathname = "Hello,%20world!"
}

val namedArguments: Section = jsObject {
    displayName = "引数(名前付き)"
    pathname = "Named%20arguments"
}

val defaultArguments: Section = jsObject {
    displayName = "引数(デフォルト値)"
    pathname = "Default%20Arguments"
}

val lambdas: Section = jsObject {
    displayName = "ラムダ式"
    pathname = "Lambdas"
}

val strings: Section = jsObject {
    displayName = "文字列"
    pathname = "Strings"
}

val dataClasses: Section = jsObject {
    displayName = "データクラス"
    pathname = "Data%20classes"
}

val nullableTypes: Section = jsObject {
    displayName = "NULL許可"
    pathname = "Nullable%20types"
}

val smartCasts: Section = jsObject {
    displayName = "スマートキャスト"
    pathname = "Smart%20casts"
}

val extensionFunctions: Section = jsObject {
    displayName = "拡張関数"
    pathname = "Extension%20functions"
}

val objectExpressions: Section = jsObject {
    displayName = "無名オブジェクト"
    pathname = "Object%20expressions"
}

val samConversions: Section = jsObject {
    displayName = "SAM変換"
    pathname = "SAM%20conversions"
}

val extensionsOnCollections: Section = jsObject {
    displayName = "リスト操作"
    pathname = "Extensions%20on%20collections"
}

val introduction: Section = jsObject {
    displayName = "最初の一歩"
    pathname = "Introduction"
    children = arrayOf(
        helloWorld,
        namedArguments,
        defaultArguments,
        lambdas,
        strings,
        dataClasses,
        nullableTypes,
        smartCasts,
        extensionFunctions,
        objectExpressions,
        samConversions,
        extensionsOnCollections
    )
}
