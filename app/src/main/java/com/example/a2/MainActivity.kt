package com.example.a2

import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sample.R
import com.example.sample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val fooAdapter by lazy {
        FooAdapter {

        }
    }

    val folderNameList = mutableListOf<String>()
    val imageUriList = mutableListOf<Uri>()



    private fun findAllDeviceImage() {
        val externalUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection =
            arrayOf(MediaStore.Images.Media.BUCKET_DISPLAY_NAME, MediaStore.Images.Media._ID)
        contentResolver.query(
            externalUri,
            projection,
            null,
            null,
            "${MediaStore.Video.VideoColumns.DATE_ADDED} DESC"
        )?.apply { // this : Cursor
            val folderNameColumn = getColumnIndexOrThrow(projection[0])
            val columnIndexID = getColumnIndexOrThrow(projection[1])
            Log.d(TAG, "findAllDeviceImage: asdfasdfasdf")
            while (moveToNext()) {
                Log.d(TAG, "findAllDeviceImage: 와일문 들어오나?")
                // 폴더명
                val folderName = getString(folderNameColumn)
                // 이미지 Uri
                val imageUri = Uri.withAppendedPath(externalUri, "" + getLong(columnIndexID))

                folderNameList.add(folderName)
                imageUriList.add(imageUri)
                Log.d(TAG, folderName)
                Log.d(TAG, imageUri.toString())
            }

            close()

        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(/* activity = */ this, /* layoutId = */ R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        findAllDeviceImage()


        // lateinit
        // fooAdapter = FooAdapter {}
        binding.recyclerView.adapter = fooAdapter

        /*fooAdapter.addItems(PickerItem.createSamples(0))*/


        val spinnerList = listOf("강아지","고양이")

        binding.spinner.adapter = ArrayAdapter(
            this, // context
            android.R.layout.simple_spinner_item, // 기본
            spinnerList // items
        )
     }
}