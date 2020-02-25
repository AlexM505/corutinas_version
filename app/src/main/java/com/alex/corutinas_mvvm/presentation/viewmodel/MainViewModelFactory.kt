package com.alex.corutinas_mvvm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alex.corutinas_mvvm.domain.IUseCase

class MainViewModelFactory(val useCase:IUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IUseCase::class.java).newInstance(useCase)
    }
}