package kr.chapter3

class ControlFlow {

    val a : Int = 0
    val b : Int = 1

    // if else 문이 식으로 사용되는 경우 값을 반환함
    // if식의 경우 반드시 else를 동반해야함
    val max = if(a > b) a else b

    // 위 코드는 Java의 아래 식과 같음
    // int max = (a > b) ? a : b;
    // 하지만 코틀린에서는 삼항연산자가 없음

   val max2 = if(a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }

    /*
    * when
    */
    // when 문은 C계열 언어의 switch문을 대체함
    // when문은 각각의 브랜치의 조건문이 만족할 때 까지 위에서부터 순차적으로 인자를 비교함

    // 여러 조건들이 같은 방식으로 처리될 수 있는 경우, branch의 조건문에 콤마(,)를 사용하여 표
    val x: Int? = 0
    var res = when(x) {
        0, 1 -> print("x == 0 or x == 1")
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }

    var grade = when(x) {
        100 -> "A"
        90 -> "B"
        80 -> "C"
        else -> "F"
    }

    var bool : Boolean = true
    var boo = when(bool) {
        true -> "맞다"
        false -> "틀리다"
    }

    fun parseInt(str: String) {


    }
}