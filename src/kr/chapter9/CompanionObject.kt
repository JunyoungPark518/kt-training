package kr.chapter9


/**
 * Companion Object (동반자 객체)
 * 클래스 내부의 object declaration은 companion 키워드를 붙일 수 있음
 */
class MyClass {
    companion object Factory {
        fun create() : MyClass = MyClass()
    }
}
// companion object의 멤버는 클래스 이름을 통해서 호출할 수 있다
fun companionTest() {

    // java static과 상당히 유사
    val instance = MyClass.create()
}

/* Companion object의 이름은 생략될 수 있음
    이러한 경우 [class name].Companion 형태로 객체에 접근 가능 */
class MyClass2 {
    companion object
}

fun companionTest2() {
    val x = MyClass2.Companion
}

// companion object의 멤버가 다른 언어의 static 멤버 처럼 보일 수 있지만 아님
// companion object의 멤버는 실제 객체의 멤버임
// super class도 가질 수 있는 클래스의 객체임
interface Factory<T> {
    fun create(): T
}

class MyClass3 {
    companion object : Factory<MyClass3> {
        override fun create() : MyClass3 = MyClass3()
    }
}