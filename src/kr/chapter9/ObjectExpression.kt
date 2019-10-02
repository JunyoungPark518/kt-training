package kr.chapter9

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

/**
 * Object Expressions
 * 용도 : 어떤 클래스에서 조금 변경된 객체를 생성할 때 새로운 서브 클래스의 명시적인 선언 없이 객체 생성
 * Expressions: Java의 익명 객체
 * Declarations: Singleton
 * Companion Object: Singleton + Class method (static)
 * ** 코틀린에서는 static method가 없음 -> Companion Objects 사용
 */

// 객체 표현식
// 자바에서는 익명 내부 클래스를 사용해서 처리했음
// 코틀린에서는 Object Expressions을 이용
/**
 * window.addMouseListener(object: MouseAdapter() {
 *      override fun mouseClicked(e: MouseEvent) { }
 *      override fun mouseEntered(e: MouseEvent) { }
 * })
 */
// 객체 표현식 상속
/// 슈퍼타입의 생성자가 있는 경우, 반드시 값을 전달해주어야 함
/// 슈퍼타입이 여러 개인 경우 ':' 콜론 뒤에, ',' 콤마로 구분해서 명시해주면 됨
open class A(x: Int) {
    public open val y : Int = x
}

interface B {

}

val ab: A = object : A(1), B {
    override val y = 15
}


// 이전의 경우 아래와 같이 클래스를 따로  만들어야 하지만
/**
 * class MyRunnable : Runnable {
 *      override fun run() {
 *          println("hello kotlin")
 *      }
 * }
 */

fun objExp1() {
    var t = Thread(object: Runnable {
        override fun run() {
            println("Thread is running")
        }
    })
    t.run()

    // Simple
    var ts = object : Runnable {
        override fun run() {
            println("Simple run")
        }
    }
    ts.run()

    // Lambda
    val t2 = Thread { print("Lambda is running")}
    t2.run()
}

// 객체 표현식 상속이 없는 경우
/// 특별히 상속받을 supertypes가 없는 경우, 간단하게 작성가능
fun adHocTest() {
    var adHoc = object {
        var x : Int = 111
        var y : Int = 222
    }

    println("${adHoc.x} , ${adHoc.y}")
}

fun main() {
    adHocTest()
}

/**
 *  객체 표현식 제한 사항
 *  익명 객체가 local이나 private로 선언될 때만 type으로 사용될 수 있음
 *  익명 객체가 public function이나 public property에서 리턴되는 경우, 익명 객체의 슈퍼타입으로 동작됨
 *  이런 경우 익명 객체에 추가된 멤버에 접근이 불가능함
 */
class C {
    private fun foo() = object { val x: String = "x" }
    fun publicFoo() = object { val x: String = "x" }

    fun bar() {
        val x1 = foo().x                // Success
//        val x2 = publicFoo().x      // Error
    }
}

/**
 * 객체 표현식 특징
 * 익명 객체의 코드는 enclosing scope의 변수를 접근할 수 있음
 * 자바와는 다르게 final variables 제약 조건이 없음
 */
fun countClicks(window: JComponent) {
    var clickCount = 0
    var enterCount = 0
    window.addMouseListener(object: MouseAdapter(){
        override fun mouseClicked(e: MouseEvent?) {
            clickCount++
        }
        override fun mouseEntered(e: MouseEvent?) {
            enterCount++
        }
    })
}