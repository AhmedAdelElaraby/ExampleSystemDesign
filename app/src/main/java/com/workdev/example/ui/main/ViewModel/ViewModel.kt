package com.workdev.example.ui.main.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mg_group.womniz.ResponseDataClass.SealedClass.ApiState
import com.workdev.domain.entity.PostResponse
import com.workdev.domain.usecase.GetPosts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ViewModel @Inject constructor (private val posts: GetPosts): ViewModel() {

    private val _posts :MutableLiveData<ApiState?> = MutableLiveData(ApiState.Empty)
    val getpostsLiveData:LiveData<ApiState?> =_posts
fun getPost (){

        viewModelScope.launch {
            _posts.value = ApiState.Loading
            posts.invoke().catch {
                _posts.value=ApiState.Failure(it)
            }.collect{data->
                _posts.value=ApiState.Success(data)
            }




            }





}

}