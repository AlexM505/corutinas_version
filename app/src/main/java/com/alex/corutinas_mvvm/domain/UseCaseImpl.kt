package com.alex.corutinas_mvvm.domain

import com.alex.corutinas_mvvm.data.network.IRepo
import com.alex.corutinas_mvvm.vo.Resource

class UseCaseImpl(private val repo:IRepo):IUseCase {

    override suspend fun getVersionCode(): Resource<Int> {
        return repo.getVersionCodeRepo()
    }

}