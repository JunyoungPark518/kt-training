package kr.chapter8

/**
 * Data Class
 */
// 용도: 데이터는 보유하지만 아무것도 하지 않는 클래스
// 코틀린에서는 data class를 제공
// 기본 생성자에서 선언된 속성을 통해, 아래의 기능들을 컴파일러가 자동으로 생성해 줌
// equals(), hashCode(), copy(), toString() of the form "User(name=John, age=42)", componentN()
// 명시적으로 정의해주는 경우네는, 컴파일러가 자동으로 생성해주지 않음
data class User(val name: String, val age: Int)

fun UserTest() {
//    var exam_0 = User() // 기본값이 없어서 에러
    var exam_1 = User("jyp", 11)
    var exam_2 = User(age=55, name="park")
//    var exam_3 = User("htp")      // 모든 파라미터를 가지고 있지 않아 에러
//    var exam_4 = User(age=44)     // 모든 파라미터를 가지고 있지 않아 에러
}

// 의미 있는 Data Class의 조건
/// 기본 생성자에 1개 이상의 파라미터
/// 기본생성자의 파라미터가 var, val로 선언
/// Data class는 abstract, open, sealed, inner가 안됨

// 1.1 이후에 바뀐 점
/// Data class interface 구현 가능
/// Sealed class 상속 가능

// 기본값
/// JVM에서 파라미터가 없는 생성자가 필요한 경우 모든 프로퍼티에 기본 값을 설정
data class User2(val name: String = "Kotlin", val age: Int = 99)

fun User2Test(){
    val exam_0 = User2()
    val exam_1 = User2("jyp")
    val exam_2 = User2("jyp", 11)
    val exam_3 = User2(age=13)
    val exam_4 = User2(name="jyp", age=15)

}

fun main() {
    val test = User2("jyp", 15)
    println(test.toString())
    var test2 = User2()
    println(test2.toString())
    copyPrint()

    ddTest()
    sdcTest()
}


/**
 * 복사
 */
// 객체의 기존 값들은 유지하고, 일부 값만 고쳐서 새로운 객체를 만들고 싶은 경우
// Data class에 컴파일러가 copy를 만들어 주기 때문에 바로 copy를 호출해서 사용하면됨
fun copy(name: String, age: Int) = User(name, age)
val jack = User(name="jack", age=1)
val olderJack = jack.copy(age=2)
val peter = olderJack.copy("peter")
fun copyPrint() {
    println(jack)
    println(olderJack) // 값을 바꾸었다고 해서 기존의 객체에 영향을 주지 않음
    println(peter)
}

/**
 * Destructuring Declarations
 */
// complier가 componentN 함수를 자동으로 만들어줌
fun ddTest() {
    println(">>>>>>>>> ddTest >>>>>>>>>>")
    val jane = User("jane", 35)
    val (name, age) = jane
    println("$name, $age years of age")
}

/**
 * Standard Data Classes
 * 스탠다드 라이브러리에서 제공하는 Pair, Triple 이라는 클래스가 있음
 * 가독성을 위해서는 프로퍼티에 의미 있는 이름을 제공하는 클래스가 최고임
 */
fun sdcTest() {
    println(">>>>>>>> sdcTest >>>>>>>>>>")
    val jane = User("jane", 35)
    val jane2 = Pair("jane", 35)
    val jane3 = Triple("jane", 35, null)
    println(" $jane2 , $jane3")
}
