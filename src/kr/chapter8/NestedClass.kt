package kr.chapter8


/**
 * Nested Classes
 * 클래스는 다른 클래스에 중첩될 수 있음
 */
class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

val demo = Outer.Nested().foo() // == 2

/**
 * Inner Class
 * 클래스에 inner를 표기하면 바깥쪽 클래스의 멤버에 접근할 수 있음
 */
class Outer2 {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}

val demo2 = Outer2().Inner().foo() // == 1

/**
 * Anonymous inner classes (익명 내부 클래스)
 * 객체 표현식 (object expression)을 이용해서 익명 내부 클래스의 인스턴스를 생성할 수 있음
 * mSearchEditText.setOnClickListener(object: View.OnClickListener {
 *      override fun onClick(v: View?) {
 *
 *      }
 *  })
 *
 * Funcional java interface인 경우에는 접두어에 인터페이스 이름을 사용해서 람다식으로 표현할 수도 있음
 * mSearchEditText.setOnClickListener( View.OnClickListener {
 *      v -> // ...
 * })
 *
 */