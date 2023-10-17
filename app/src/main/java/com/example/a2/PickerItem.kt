package com.example.a2

import android.net.Uri

data class PickerItem(
    val folderName: String,
    val imageUri: Uri
) {
    // 더미
    /*companion object {
        fun createSamples(page : Int, spinnerValue : String, folderNameList: MutableList<String>, imageUriList: MutableList<Uri>) = mutableListOf<PickerItem>().apply {

            var i = 0
            while ( i < 10) {
                if(folderNameList[i] == spinnerValue){
                    add(PickerItem(folderNameList[i], imageUriList[i]))
                    i += 1
                }


            }
        }
    }*/
}

