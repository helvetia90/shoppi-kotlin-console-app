package data

object CartItems {
    //  내부에서 수정 가능하게 하기 위해 mutableMap
    private val mutableProducts = mutableMapOf<Product, Int>()
    // 외부에 오픈되는 부분은 수정 불가능하게 하기위해 Map 사용
    val products: Map<Product, Int> = mutableProducts

    fun addProduct(product: Product) {
        // let은 앞에 선언한 작업들 가지고 이어서 다음 작업을 하는거라고 생각하면 될듯
        // 아래는 mutableProducts[product]가 널이 아니면 mutableProducts[product]에 + 1한다는 뜻
        // it가 mutableProducts[product]임. let 앞에서 한 작업

        /*  let 이해 예제
         *   val a:String = "m"  // 먼저, let 함수를 사용할 객체를 선언합니다.
         *   a.plus("e").plus("o").plus("ru").let { it.plus("1"); print(it) }
         *   // 기존 코드
         *   // a.plus("e").plus("o").plus("ru").plus("1"); print(a.plus("e").plus("o").plus("ru").a)
         */
        mutableProducts[product]?.let {
            mutableProducts[product] = it + 1
        } ?: kotlin.run {
            // 널일 경우 최초 1로 개수 등록
            mutableProducts[product] = 1
        }
    }
}