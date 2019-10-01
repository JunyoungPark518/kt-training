package kr.chapter5

/**
 * Class
 */
// 클래스는 class 키워드로 선언함
// 클래스 이름
// 클래스 헤더 (형식 매개변수, 기본 생성자 등)
// 클래스 바디 (중괄호 {} )
class ClassAndInheritance(data: Int) {


}
// 헤더와 바디는 옵션이고, 바디가 없으면 { } 도 생략가능
// class Empty

/**
 * 기본 생성자
 */
// 클래스 별로 1개만 가질 수 있음
// 클래스 헤더의 일부
// 클래스 이름 뒤에 작성
class Person constructor(firstName: String) {
    var children : ChildPerson? = null

    constructor(name: String, parent: Person) : this(name) {

    }

    constructor() : this("jypark", Person()) {

    }
}

// 어노테이션이나 접근지정자가 없을 때는, 기본 생성자의 constructor 키워드를 생략가능
// class Person(firstName: String) { }

// 기본생성자는 코드를 가질 수 없음
// 프로퍼티 선언 및 초기화는 기본생성자에서 간결한 구문으로 사용 가
class Customer(firstName: String, val lastName: String) {

    // 기본생성자의 파라미터는 프로퍼티
    // 이 값은 생성자 파라미터에 그냥 넣어도 무방
    var middleName: String? = ""
    var upper = firstName.toUpperCase()

    /// 초기화는 초기화(init) 블록 안에서 작성해야 함
    /// 초기화 블록은 init 키워드로 작성
    /// 기본 생성자의 파라미터는 init 블록 안에서 사용 가능함
    init {
        println("Customer initialized with value ${firstName}")
    }
    fun print() {
        println("Call print() in Customer : middleName >> ${middleName}")
        println("lastName : ${lastName}")
        println("Upper case : ${upper}")
    }
}


fun main() {
    val customer = Customer("Park", "John")
    println(customer)
    customer.middleName = "Junyoung"
    customer.print()
}

// 기본 생성자에 어노테이션 접근지정자 등이 있는 경우 constructor 키워드가 필요함
//class Customer2 public @Inject constructor(name: String) {}

/**
 * 보조생성자
 */
// 클래스 별로 여러 개를 가질 수 있음
// constructor 키워드로 선언
class ChildPerson {
    constructor(parent: Person) {
//        parent.children.add(this)
    }

    fun add(child: ChildPerson) {

    }
}

/**
 * 생성된(generated) 기본생성자
 */
// 클래스에 기본생성자 또는 보조생성자를 선언하지 않으면, 생성된 기본 생성자가 만들어짐
// generated primary constructor
/// 매개변수가 없고 가시성이 public
// 만약 생성된 기본생성자의 가시성이 public이 아니어야 한다면, 다른 가시성을 가진 빈 기본생성자를 선언해야 함
class DontCreateMe private constructor() { }

/**
 * 인스턴스 생성
 */
// 코틀린은 new 키워드가 없음
// 객체를 생성하려면 생성자를 일반 함수처럼 호출 하면 됨
val customer = Customer("Joe Smith", "Last Name")