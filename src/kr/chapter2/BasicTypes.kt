package kr.chapter2

/**
 * 숫자형
 * 자바의 숫자형과 거의 비슷하게 처리
 * 코틀린에서 Number는 클래스이며, 자바의 primitive type에 직접 접근할 수 없음
 * 자바에서 숫자형이던 char가 코틀린에서는 숫자형이 아님
 * 각각 가지고 있는 클래스의 비트 수는 같음
 * Double: 64bit
 * Float: 32bit
 * Long: 64bit
 * Int 32bit
 * Short: 16bit
 * Byte: 8bit
 *
 * 리터럴
 * 10진수: 123(Int, Short)
 * Long: 123L
 * Double: 123.5, 123.5e10
 * Float 123.5f
 * 2진수: 0b00001011
 * 8진수: 미지원
 * 16진수: 0X0F
 */

class BasicTypes {

    // 언더스코어(_)를 사용하여 숫자 자리수 구분이 가능
    val oneMilion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L

    // 16진수
    val hexBytes = 0xFF_EC_DE_5E

    // 2진수
    val bytes = 0b11010010_01101001_10010100_10010010


    /**
     * Java 플랫폼에서 숫자형은 JVM primitive type으로 저장됨
     * Nullable이나 제네릭의 경우에는 박싱
     * 박싱된 경우 identity를 유지하지 않음
     */

    fun test() {
        // JVM primitive
        var a: Int = 10000
        var b: Int? = 10000 // Nullable

        println("a === b : ${a === b}")     // false -> int a = 10000, Integer b = 10000
        println("a == b : ${a == b}")          // true

        // Boxed
        val boxedA: Int? = a
        val anotherBoxedA: Int? = b
        println("boxedA === anotherBoxedA : ${boxedA === anotherBoxedA}")       // false

    }

    // Explicit Conversions
    // 작은 타입은 큰 타입의 하위 타입이 아님
    // 작은 타입에서 큰 타입으로의 대입이 안됨
    fun explict(){
        val a: Int = 1
        // val b: Long = a // error

        // 명시적으로 변환해주어야함
        val b: Long = a.toLong()
        // println(a == b) // error
    }

    // 문자 (Characters)
    // Char는 숫자로 취급되지 않음
    fun check(c: Char) {

//        if(c == 1){ } // error

        if(c == 'a') { }
    }

}