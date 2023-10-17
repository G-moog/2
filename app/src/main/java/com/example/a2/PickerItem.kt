package com.example.a2

data class PickerItem(
    val folderName: String,
    val imageUri: String
) {
    // 더미
/*    companion object {
        fun createSamples(page : Int) = mutableListOf<PickerItem>().apply {
            for (i in 1 until 10) {
                val number = page * 10
                add(PickerItem(folderName, "이름 ${number + i}", "01000000000"))
            }
        }
    }*/
}

/*
data class PickerItem(
    val id: Int,
    val name: String,
    val phone: String,
) {
    // 더미
    companion object {
        fun createSamples(page : Int) = mutableListOf<PickerItem>().apply {
            for (i in 1 until 10) {
                val number = page * 10
                add(PickerItem(number +i, "이름 ${number + i}", "01000000000"))
            }
        }
    }
}*/
