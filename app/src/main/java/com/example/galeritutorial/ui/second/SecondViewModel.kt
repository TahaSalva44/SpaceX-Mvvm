package com.example.galeritutorial.ui.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.galeritutorial.base.BaseViewModel
import com.example.galeritutorial.model.Comments
import com.example.galeritutorial.network.helper.DataHolder
import kotlinx.coroutines.launch
import javax.inject.Inject

class SecondViewModel @Inject constructor(private val secondRepository: SecondRepository) :
    BaseViewModel() {

    var details:String? = null
    var rocketName :String? = null
    var image:String? = null



    fun getData(image:String,rocketName:String,details:String){
        this.image = image
        this.details = details
        this.rocketName = rocketName
    }
}
