package com.alex.corutinas_mvvm.domain

import com.alex.corutinas_mvvm.vo.Resource

interface IUseCase {

    suspend fun getVersionCode(): Resource<Int>
}