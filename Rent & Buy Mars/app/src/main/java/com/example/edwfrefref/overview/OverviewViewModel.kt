package com.example.edwfrefref.overview

import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.Navigation
import com.example.edwfrefref.MarsApi
import com.example.edwfrefref.MarsApiFilter
import com.example.edwfrefref.detail.DetailFragment
import com.example.edwfrefref.detail.DetailFragmentDirections
import com.example.edwfrefref.network.MarsProperty
import kotlinx.coroutines.launch
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue

enum class Status { DONE, ERROR, LOADING }

class OverviewViewModel : ViewModel() {


    private val _property = MutableLiveData<List<MarsProperty>>()
    val property: LiveData<List<MarsProperty>>
        get() = _property


    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status


    private val _navigateToSelectedProperty = MutableLiveData<MarsProperty?>()
    val navigateToSelectedProperty: MutableLiveData<MarsProperty?>
        get() = _navigateToSelectedProperty


    init {
        getMarsRealestateProperty(MarsApiFilter.SHOW_ALL)

    }

    private fun getMarsRealestateProperty(filter: MarsApiFilter) {
        viewModelScope.launch {
            _status.value = Status.LOADING
            try {
                _property.value = MarsApi.MarsApiService.getMarsProperty(filter.value)
                _status.value = Status.DONE
            } catch (e: Exception) {
                _status.value = Status.ERROR
                _property.value = ArrayList()
            }
        }
    }


    fun updateFilterMarsRealestate(filter: MarsApiFilter) {
        getMarsRealestateProperty(filter)
    }


    fun displayMarsPropertyDetail(marsProperty: MarsProperty) {
        _navigateToSelectedProperty.value = marsProperty
    }

    fun displayMarsPropertyDetailCompleted(){
        _navigateToSelectedProperty.value= null
    }

}


















