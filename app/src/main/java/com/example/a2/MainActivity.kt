package com.example.a2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fooAdapter by lazy {
        FooAdapter {

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(/* activity = */ this, /* layoutId = */ R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager


        // lateinit
        // fooAdapter = FooAdapter {}
        binding.recyclerView.adapter = fooAdapter

        fooAdapter.addItems(Foo.createSamples(0))
     }
}