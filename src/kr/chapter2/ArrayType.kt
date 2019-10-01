package kr.chapter2

/**
 * 배열
 */
// Array 클래스로 표현됨
// get, set ([] 연산자 오버로딩됨)
// size 등 유용한 멤버 함수 포함
fun arrayTest() {
    // 배열의 사용 방법
    var array: Array<String> = arrayOf("코틀린", "연습")
    println(array[0])
    println(array.get(0))
    println(array.size)

    // 배열의 생성
    val b = Array(5, {i -> i.toString()})
    val a = arrayOf("0", "1", "2", "3", "4")


    for(c in a)
        print(c)      // 01234

    println()

    for(c in b)
        print(c)      // 01234

    // 특별한 Array class
    // primitive type의 박싱 오버헤드를 없애기 위한 배열
    // IntArray, ShortArray, LongArray
    // Array를 상속한 클래스들은 아니지만, Array와 같은 메소드와 프로퍼티를 가짐
    // size등 유용한 멤버 함수 포함
    val x: IntArray  = intArrayOf(1, 2, 3, 4)
    x[0] = 7
    println(x.get(0))
    println(x[0])
    println(x.size)
}