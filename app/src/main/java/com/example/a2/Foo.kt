package com.example.a2

data class Foo(
    val id: Int,
    val name: String,
    val phone: String,
) {
    // 더미
    companion object {
        fun createSamples(page : Int) = mutableListOf<Foo>().apply {
            for (i in 1 until 10) {
                val number = page * 10
                add(Foo(number +i, "이름 ${number + i}", "01000000000"))
            }
        }
    }
}