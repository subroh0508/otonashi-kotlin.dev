fun foo([mark]name: String, number: Int, toUpperCase: Boolean[/mark]) =
    (if (toUpperCase) name.toUpperCase() else name) + number

fun main() {
    println(foo("a"))
    println(foo("b", number = 1))
    println(foo("c", toUpperCase = true))
    println(foo(name = "d", number = 2, toUpperCase = true))
}
