package kr.chapter6

/**
 * 상속
 */
// 코틀린의 최상위 클래스는 Any임
// 클래스에 상위타입을 선언하지 않으면 Any가 상속됨
// class Example1 // 암시적인 Any 상속
// class Example2 : Any() // 명시적인 Any 상속

// Any는 java.lang.Object와는 다른 클래스임
/// equals(), hashCode(), toString() 만 있음
/**
public open class Any {
    public open operator fun equals(other: Any?): Boolean
    public open fun hashCode(): Int
    public open fun toString(): String
}
 */

// 명시적으로 상위타입을 선언하려면, 클래스 헤더의 콜론(:) 뒤에 상위 타입을 선언
open class Base(p: Int) // open을 하지 않으면 상속할 수 없다
class Derived(p: Int) : Base(p)
class Derived2(p: Int) : Base(111)

// 파생클래스에 기본생성자가 없으면 각각의 보조생성자에서 상위타입을 super 키워드를 이용해서 초기화 해주어야함
// 또는 다른 생성자에게 상위타입을 초기화할 수 있게 위임행주어야 한다
class MyView : View {
    constructor() : super(1)
    constructor(ctx: Int) : this()

}

open class View(ctx: Int) {

}

// oepn annotation은 자바의 final과 반대임
// open class 는 다른 클래스가 상속할 수 있음
// 기본적으로 코틀린의 모든 class 는 final 임

/**
 * 메소드 오버라이딩
 */
// 오버라이딩 될 메소드 : open 어노테이션 요구
// 오버라이딩 된 메소드 : override 어노테이션 요구
open class Base2 {
    open fun v() {
        println("v1")
    }
    fun nv() {}
}

class Derived3(): Base2() {
    override fun v() { }
}

/**
 * 프로퍼티 오버라이딩
 * */
// 메소드 오버라이딩과 유사한 방식으로 오버라이딩 가능
open class Foo {
    open val x: Int get() { return 1}
}

class Bar1 : Foo() {
    override val x : Int = 2
}

/**
 * 오버라이딩 규칙
 * */
// 같은 멤버에 대한 중복된 구현을 상속받은 경우, 상속받은 클래스는 해당 멤버를 오버라이딩하고 자체 구현을 제공해야 함
// suiper + <Class> 를 통해서 상위 클래스를 호출할 수 있음
open class Aaa {
    open fun f() { print("A") }
    fun a() { print("a")}
}

// 코틀린의 인터페이스에는 구현체가 있음
// open은 없어도 된다
interface Bbb {
    fun f() { print("B") }
    fun b() { print("b")}
}

// class C extends Aaa implements Bbb
class C : Aaa(), Bbb {
    override fun f() {
        super<Aaa>.f()      // call to Aaa.f()
        super<Bbb>.f()      // call to Bbb.f()
    }
}

fun main() {
    C().f()
}

/**
 * 추상 클래스
 */
// abstract 멤버는 구현이 없음
// abstract 클래스나 멤버는 open 이 필요 없음
abstract class AbsClass {
    abstract fun f()
}

// 구현체
class AbsClassImpl : AbsClass() {
    override fun f() {
        print("implementation to here")
    }
}
