package kr.chapter4

/**
 * 3가지 Jump 표현식
 * return : 함수나 익명 함수에서 반환
 * break : 루프를 종료 시킴
 * continue : 루프의 다음 단계로 진행
 */
fun returnTest(a: Int, b: Int): Int {
    println("a: $a, b: $b")
    return a+b
}

fun breakTest(){
    var x = 0
    for(x in 1..10)
        if(x > 2) {
            break
        }
    println("x: $x")
}


fun continueTest(){
    var x = 0
    for(x in 1..10)
        if(x < 2)
            continue

    println("x: $x")
}

/**
 * Label
 */
// 레이블 표현: label@, abc@, fooBar@
// identifier + @ 형태로 사용
fun labelTest1(){
    loop@ for (i in 1..10) {
        println("--- i: $i ---")

        for( j in 1..10) {
            println("j: $j")
            if(i + j > 12)
                break@loop
        }
    }
}

fun labelTest2() {
    jyp@ for (i in 1..10) {
        println("--- i: $i ---")

        for(j in 1..10) {
            if(j > 2) {
                continue@jyp
            }
            println("j: $j")
        }
    }
}


/**
 * Label Return
 */
////// 코틀린에서 중첩될 수 있는 요소들
// 1. 함수 리터럴 (function literals)
// 2. 지역함수 (local function)
// 3. 객체 표현식 (object expression)
// 4. 함수 (functions)
fun labelReturnTest() {
    var ints = listOf(0, 1, 2, 3)

    ints.forEach(fun(value: Int) {
        if(value == 1) return // 1일때의 함수만 종료하는 것이라 forEach 함수는 계속 작동하는 것
        println(value)
    })
    print("End")
}

// lambda 는 함수가 아니기에 바로 종료
fun returnTestWithLambda(){
    var ints = listOf(0, 1, 2, 3)

    ints.forEach {
        if(it == 1) return
        println(it)
    }
    print("End")
}

// lambda에 label을 합쳐서 사용
fun labelReturnTestWithLambda(){
    var ints = listOf(0, 1, 2, 3)

    ints.forEach jyp@ {
        if(it == 1) return@jyp
        println(it)
    }
    print("End")
}


/**
 * 암시적 레이블
 * */
// 람다식에서만 return 하는 경우 label을 이용해서 return 해야 함
// 직접 label을 사용하는 것보다 암시적 레이블이 편리
// 암시적 레이블은 람다가 사용된 함수의 이름과 동일함
fun implicitLabel(){
    var ints = listOf(0, 1, 2, 3)

    ints.forEach {
        if(it == 1) return@forEach
        println(it)
    }
    print("End")
}

// 레이블 return 시 값을 반환할 경우
// return@label 1 형태로 사용
// return + @label + 값
fun returnLabelValue(): List<String> {
    var ints = listOf(0, 1, 2, 3)
    var result = ints.map {
        if(it == 0) {
            return@map "zero" // return at named label
        }
        "number $it" // expression returned from lambda
    }
    return result
}



fun main() {
    println("------------ test1 ------------")
    labelTest1()

    println("------------ test2 ------------")
    labelTest2()

    println("----------- labelReturnTest --------------")
    labelReturnTest()

    println("----------- returnTestWithLambda --------------")
    returnTestWithLambda()

    println("----------- labelReturnTestWithLambda --------------")
    labelReturnTestWithLambda()

    println("----------- implicitLabel --------------")
    implicitLabel()

    println("----------- returnLabelValue --------------")
    returnLabelValue()
}