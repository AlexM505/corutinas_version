package com.alex.corutinas_mvvm.data.network

import com.alex.corutinas_mvvm.vo.Resource

interface IRepo {

    suspend fun getVersionCodeRepo():Resource<Int>
}