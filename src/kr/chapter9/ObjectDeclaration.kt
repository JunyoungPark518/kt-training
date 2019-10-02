package kr.chapter9

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

/**
 * 객체 선언 용도
 * 매우 유용한 싱글톤 패턴을 코틀린에서는 object declarations을 이용해서 만들 수 있음
 */
class DataProvider
object DataProviderManager {
    fun registerDataProvider(provider: DataProvider) {
        // ...
    }

    val allDataProviders: Collection<DataProvider>
        get() {
            TODO()
        }
}

/**
 * 객체 선언 문법
 * object 키워드 뒤에 항상 이름이 있어야함
 * object declaration은 object expression이 아니어서 할당 구문에 우측에 사용될 수가 없음
 */
// object declaration의 객체를 참조하려면, 해당 이름으로 직접 접근하면 됨
fun decTest1() {
    var obj = DataProvider()
    DataProviderManager.registerDataProvider(obj)
}

// 슈퍼타입을 가질 수 있음 (상속가능)
object DefaultListener: MouseAdapter() {
    var clickCount = 0
    var enterCount = 0
    override fun mouseClicked(e: MouseEvent?) {
        clickCount++
    }
    override fun mouseEntered(e: MouseEvent?) {
        enterCount++
    }
}

fun jsonTest() {
    val a = object {
        val key1 = "key1"
        val key2 = "key2"
        val val1 =  11
        val val2 = 22
    }

    println("${a.key1} , ${a.key2}, ${a.val1}, ${a.val2}")
}
