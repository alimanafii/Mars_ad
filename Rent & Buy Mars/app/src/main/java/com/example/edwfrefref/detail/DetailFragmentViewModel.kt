package com.example.edwfrefref.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.edwfrefref.network.MarsProperty

class DetailFragmentViewModel(
    marsProperty: MarsProperty,
    app: Application
) : AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<MarsProperty>()
    val selectedProperty: LiveData<MarsProperty>
        get() = _selectedProperty

    private val _price = MutableLiveData<String>()
    val price: LiveData<String>
        get() = _price


    private val _isType = MutableLiveData<String>()
    val isType: LiveData<String>
        get() = _isType


    init {
        _selectedProperty.value = marsProperty
        changeText()
    }


    private fun changeText() {
        if (_selectedProperty.value!!.isRental) {
            _price.value = "Price is : ${_selectedProperty.value!!.price} $ monthly "

        } else {
            _price.value = "Price is : ${_selectedProperty.value!!.price}$ "

        }
        _isType.value="Type this ad is : ${_selectedProperty.value!!.type} "

    }
}