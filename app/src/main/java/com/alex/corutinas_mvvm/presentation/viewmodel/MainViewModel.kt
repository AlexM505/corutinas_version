package com.alex.corutinas_mvvm.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.alex.corutinas_mvvm.domain.IUseCase
import com.alex.corutinas_mvvm.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(useCase:IUseCase): ViewModel() {

    //Dispatchers.IO ejecuta un hilo aparte del MainTread

    val fecthVersionCode = liveData(Dispatchers.IO) {
        emit(Resource.Loading())

        try {
            val version = useCase.getVersionCode()
            emit(version)
        }catch (e:Exception){
            emit(Resource.Failure(e))
            Log.e("Error:",e.message)
        }
    }
}