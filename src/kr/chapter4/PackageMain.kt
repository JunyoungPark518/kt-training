package kr.chapter4

import other2

/**
 * 패키지
 */
// 소스 파일은 패키지 선언으로 시작 됨
// 모든 콘텐츠(클래스, 함수, ...) 는 패키지에 포함 됨
// 패키지를 명세하지 않으면 이름이 없는 기본 패키지에 포함됨

fun main(args: Array<String>) {

    // 같은 패키지에 있으므로 호출하는데 지장 없음
    other1()

    // 이름이 없는 기본 패키지를 import
    other2()

    // 기본 import가 되어 있는 함수 호출
    basicImportPackage()
}

/**
 * 기본 패키지
 *
 * 기본으로 import 되는 package가 있음
 * 플랫폼 별로 import 되는 package도 다른 부분도 있음
 *
 *************************
 * kotlin.*
 * kotlin.annotation.*
 * kotlin.collections.*
 * kotlin.comparisons.* (since 1.1)
 * kotlin.io.*
 * kotlin.ranges.*
 * kotlin.sequences.*
 * kotlin.text.*
 *
 *************************
 * JVM
 *************************
 * java.lang.*
 * kotlin.jvm.*
 *
 *************************
 * JS
 *************************
 * kotlin.js.*
 */

fun basicImportPackage() {
    var a = listOf(1, 2, 3) // import 를 하지 않았음
    println(a)
}

/**
 * Imports
 * */
// 기본으로 포함되는 패키지 외에도, 필요한 패키지들을 직접 import 할 수 있음
// Bar 1개만 import함
// import foo.Bar

// 'foo' 패키지에 모든 것을 importgka
// import foo.*

// foo.Bar & bar.Bar 이름이 충돌 나는 경우 'as' 키워드를 사용하여 로컬 리네임 가능
// import foo.Bar
// import bar.Bar as bBar