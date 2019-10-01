package kr.chapter2

/**
 * 문자열
 */
// 문자열은 String 클래스로 표현
// String은 characters로 구성
// s[i] 와 같은 방식으로 접근 가능) immutable이므로 변경 불가)
fun stringsTest(){
    var x: String = "Kotlin"
    println(x.get(0))
    println(x[0])
    println(x.length)

    for(c in x)
        print(c) // Kotlin
}

/**
 * 문자열 리터럴
 */
// escaped string ("Kotlin")
// 전통적인 방식으로 Java String과 거의 비슷
// Backslash를 사용하여 escaping 처리

// raw string ("""Kotlin""")
// escaping 처리 필요 없음
// 개행이나 어떠한 문자 포함가능
fun stringLiteralTest(){
    val s = "Hello, world!\n"

    val s2 = """
            "'이것은 코틀린의 
            Raw String
            입니당.'"
        """.trimIndent()
}