package com.alex.corutinas_mvvm.vo

import java.lang.Exception

//Clase sellada
//Se le pasa un dato generico (lo que sea)

sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure<out T>(val exception: Exception) : Resource<T>()
}