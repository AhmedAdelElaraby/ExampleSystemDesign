package com.mg_group.womniz.ResponseDataClass.SealedClass

import com.workdev.domain.entity.PostResponse


sealed class ApiState {
    object Loading : ApiState()
    class  Success(val data: PostResponse) : ApiState()
     class Failure(val e: Throwable?) : ApiState()
   object Empty : ApiState()

}
