package com.alex.corutinas_mvvm

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alex.corutinas_mvvm.base.BaseActivity
import com.alex.corutinas_mvvm.data.network.RepoImpl
import com.alex.corutinas_mvvm.domain.UseCaseImpl
import com.alex.corutinas_mvvm.presentation.viewmodel.MainViewModel
import com.alex.corutinas_mvvm.presentation.viewmodel.MainViewModelFactory
import com.alex.corutinas_mvvm.vo.Resource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val viewModel by lazy { ViewModelProvider(this,MainViewModelFactory(UseCaseImpl(RepoImpl()))).get(MainViewModel::class.java) }

    override fun getViewID(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeData()
    }

    private fun observeData(){
        viewModel.fecthVersionCode.observe(this, Observer {result ->
            when(result){
                is Resource.Loading ->{
                    showProgress()
                }

                is Resource.Success ->{
//                    tvVersion.text = result.data.toString()
                    val actualVersion = result.data
                    if(appIsOutdated(actualVersion))
                        showUpdateProgress()
                    else
                        tvVersion.text = actualVersion.toString()

                    hideProgress()
                }

                is Resource.Failure ->{
                    Toast.makeText(this,"Ocurrio un error ${result.exception.message}",Toast.LENGTH_LONG).show()
                    hideProgress()
                }
            }
        })
    }

    private fun appIsOutdated(actualVersion:Int):Boolean{
        val currentVersion = BuildConfig.VERSION_CODE
        return currentVersion < actualVersion
    }
}
