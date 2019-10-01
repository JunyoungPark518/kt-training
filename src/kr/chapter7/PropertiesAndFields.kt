package kr.chapter7

import java.lang.AssertionError

/**
 * 프로퍼티
 * var <propertyName>[: <PropertyType>] [=<property_initializer>]
 *  [<getter>]
 *  [<setter>]
 *
 *  옵션(생략가능)
 *  PropertyType, property_initializer, getter, setter
*/
// 코틀린 클래스는 프로퍼티를 가질 수 있음
// var / val
class Address {
    var name : String = "Kotlin"
    var city: String = "Seoul"

    // setter가 없음
//    val initialized = 1
        // error
        // default getter
        // 명시적인 초기화가 필요함
//        var allByDefault: Int?


    get() { return field + "!!!" }
    set(value) { field = value }
}

// 프로퍼티 사용은 자바의 필드를 사용하듯이 하면 됨
fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = address.name
    return result
}

fun main() {
    var obj = Address()
    println(obj.name)
    println(obj.city)
}

/**
 *  Custom accessors (getter, setter)
 *  프로퍼티 선언 내부에, 일반 함수 처럼 선언 할 수 있음
 *-----------------------------------------
 * getter
 * val isEmpty: Boolean
 * get() = this.size == 0
 *-----------------------------------------
 * setter
 * 관습적으로 setter의 파라미터 이름은 value임 (변경가능)
 * var stringRepresentation: String
 * get() = this.toString()
 * set(value) { setDataFromString(value) }
 */

/***
 * 타입 생략
 * 코틀린 1.1부터는 getter를 통해 타입을 추론 할 수 있는 경우, 프로퍼티의 타입을 생략 가능
 */
class TypePass {

//    val isEmpty
//    get() = list.size == 0
}

class PropertyAccessor {
    // 가시성 변경이 필요하거나 어노테이션이 필요한 경우
    var setterVisibilty: String = "abc"
        private set
    var setterWithAnnotation: Any? = null
   //  @Inject set // annotate the setter with Inject

    // body 작성도 가능
    var setterVisiblity2: String = "abc"
    private set(value) { field = value }
}

/**
 * Backing Fields
 */
// 코틀린 클래스는 field를 가질 수 없음
// field 라는 식별자를 통해 접근할 수 있는 automatic backing field 를 제공함
// field는 프로퍼티의 accessor에서만 사용가능함
var counter = 0
set(value) {
    if(value >= 0) field = value
}

/**
 * Backgin Properties
 */
// implicit backing field 방식이 맞지 않는 경우에는 backing property를 이용할 수도 있다
private var _table: Map<String, Int>? = null
val table: Map<String, Int>
get() {
    if(_table == null) {
        _table = HashMap()
    }
    return _table ?: throw AssertionError("null")
}

/**
 * Compile-Time Constants
 */
// const modifier를 이용하면 컴파일 타임 상수를 만들 수 있는 조
// 1. Top-level
// 2. object member
// 3. String or primitive type
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

@Deprecated(SUBSYSTEM_DEPRECATED)
fun foo() {
    println(SUBSYSTEM_DEPRECATED)
}
/**
 * Late-Initialized Properties
 */
// 일반적으로 프로퍼티는 non-null 타입으로 선언됨
// 간혹 non-null 타입 프로퍼티를 사용하고 싶지만, 생성자에서 초기화를 해줄 수 없는 경우가 있음
// 1. Dependency Injection
// 2. Butter knife (Library)
// 3. Unit test의 setup method
class LateInitTest {
    lateinit var data : String
    fun setUp() {
        data = "lateinit"
    }

//    lateinit var subject: TestSubject
//
//    @SetUp fun setup() {
//        subject = TestSubject()
//    }
//
//    @Test fun test() {
//        subject.method()
//    }
}

/**
 * 객체가 constructor에서는 할당 되지 못하지만 여전히 non-null 타입으로 사용하고 싶은 경우
 * 조건
 * 1. 클래스의 바디에서 선언된 프로퍼티
 * 2. 기본생성자에서 선언된 프로퍼티는 안됨
 * 3. var 프로퍼티만 가능
 * 4. custom accessor가 없어야 함
 * 5. non-null 타입이어야 함
 * 6. primitive type은 안됨
 *
 * lateinit 프로퍼티가 초기화되기 전에 접근되면 오류 발생
 * kotlin.UninitializedPropertyAccessException: lateinit property has not been initialized
 */