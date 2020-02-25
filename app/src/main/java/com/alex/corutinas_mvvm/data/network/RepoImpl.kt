package com.alex.corutinas_mvvm.data.network

import com.alex.corutinas_mvvm.vo.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class RepoImpl:IRepo {

    override suspend fun getVersionCodeRepo(): Resource<Int> {
        //Firebase

        val resultdata = FirebaseFirestore.getInstance().collection("params")
            .document("app").get().await()

        val versionCode = resultdata.getLong("version")

        return Resource.Success(versionCode!!.toInt())
    }
}