package kr.chapter1

/**
 * 함수 정의
 */
// 함수는 fun 키워드로 정의
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 함수 몸체가 식(Expression)인 경우 return 생략가능
// 이러한 경우 return type이 추론됨
fun sum2(a: Int, b: Int) = a + b

// 리턴할 값이 없는 경우 Unit(Object)로 리턴을 함
// Unit은 Java에서 void 리턴 역할
fun printKotlin(): Unit {
    println("Hello Kotlin")
}

// Unit은 생략가능
fun printKotlinWithoutUnit() {
    println("Hello Kotlin")
}

// 지역변수 정의
// val: 읽기 전용 변수
// 값의 할당이 1회만 가능, Java의 final과 유사
fun values() {
    val a: Int = 1 // 즉시 할당
    val b = 2       // 'Int' type 추론
    val c: Int      // 컴파일 오류, 초기화가 필요함
    c = 3           // 컴파일 오류, 읽기 전용
}

// var: Mutable 변수
fun variable() {
    var x = 5
    x += 1
}

/**
 * 주석
 */
// Java, Javascriupt와 동일
// /*  */ 여러 줄 주석 (Block comment)
// block Comment 가 자바랑 다르게 중첩 허용됨
/*
* block comment 가 /* 중첩도 가능  */
* */

/**
* 문자열 템플릿
*/
// String Interpolation (문자열 보간법)
fun interpolationTest(){
    var a = 1
    // simple name in template
    var s1 = "a is $a"

    a = 2
    // arbitary expression in template
    val s2 = "${s1.replace("is", "was")}, but now is $a"
}

/**
 * 조건문
 */
fun maxOf(a: Int, b: Int): Int {
    if(a > b) {
        return a
    } else {
        return b
    }
}

fun maxOf2(a: Int, b: Int) = if(a > b) a else b

/**
 * Nullable
 */
// 값이 null 일 수 있는 경우 타입에 nullable 마크를 명시 해야 함
// '?' 를 리턴타입 옆에 선언하여 nullable 표
fun parseInt(str: String): Int? {
    return parseInt(str)
}

// nullable 타입의 변수를 접근 할 때는 반드시 null 체크를 해야 하고 그렇지 않으면 컴파일 오류 발생!!
fun printProduct(arg1: String, arg2: String) {
    val x: Int? = parseInt(arg1)
    val y: Int? = parseInt(arg2)

    if(x != null && y != null) {
        println(x * y)
    }
    else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

/**
 * 자동 타입 변환
 */
// 타입 체크만 해도 자동으로 타입 변환이 됨
// Any 타입이 Java의 Object로 생각하면 쉬움
// is 는 instanceof 로 생각하면 됨
fun getStringLength(obj: Any): Int? {
    if(obj is String) {
        // 'obj'가 자동으로 String 타입으로 변환 됨
        return obj.length
    }
    return null
}


/**
 * While loop
 */
fun whlieTest(){
    val items = listOf("apple", "banana", "Kiwi")
    var index = 0
    while(index < items.size) {
        println("item at $index is $items[index")
        index++
    }
}

/**
 * When expression
 */
fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }


/**
 * Ranges
 */
fun rangeTest() {

    // in 연산자를 이용해서 숫자 범위를 체크 가능
    val x = 3
    if(x in 1..10) {
        println("fits in range")
    }

    // range를 이용한 for loop
    for(x in 1..5) {
        print(x)
    }
}

/**
 * Collections
 */
fun collectionsTest() {

    // 컬렉션도 in으로 loop 가능
    val items = listOf("Apple", "Banana", "Kiwi")
    for(item in items)
        println(item)

    // in으로 해당 값이 collection에 포함되는지 체크 가능
    val items2 = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items2 -> println("juicy")
        "apple" in items2 -> println("apple is fine too")
    }

    // lambda식을 이용해서 컬렉션에 filter, map 등의 연산 가능
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.filter{ it.startsWith("a")}
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach{ println(it) }

}
