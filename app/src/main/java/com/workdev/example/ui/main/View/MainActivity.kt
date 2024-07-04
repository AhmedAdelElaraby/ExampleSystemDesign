package com.workdev.example.ui.main.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.mg_group.womniz.ResponseDataClass.SealedClass.ApiState
import com.workdev.example.ui.main.utils.adapter.AdapterPosts

import com.workdev.example.R
import com.workdev.example.databinding.ActivityMainBinding
import com.workdev.example.ui.main.ViewModel.ViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding

    private val viewModel: ViewModel by viewModels()


    val adaptersPosts = AdapterPosts()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel.getPost()

        binding.rec.adapter=adaptersPosts

        viewModel.getpostsLiveData.observe(this) {
            when (it) {
                is ApiState.Loading -> {

                }
                is ApiState.Failure -> {

                    Toast.makeText(this,""+it.e?.message.toString(), Toast.LENGTH_LONG).show()
                }
                is ApiState.Success -> {

                    adaptersPosts.differ.submitList(it.data)

                }
                is ApiState.Empty -> {

                }
                else -> {

                }
            }



        }

    }
}