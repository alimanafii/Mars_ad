package com.example.edwfrefref.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import com.example.edwfrefref.bind
import com.example.edwfrefref.databinding.FragmentDetailBinding
import com.example.edwfrefref.network.MarsProperty
import com.example.edwfrefref.overview.OverviewViewModel

class DetailFragment : Fragment() {

//    private val viewModel: OverviewViewModel by lazy {
//        ViewModelProvider(this).get(OverviewViewModel::class.java)
//    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val application= requireNotNull(activity).application
        val binding=FragmentDetailBinding.inflate(inflater)


        binding.lifecycleOwner=this


        val marsProperty=DetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory=DetailViewModelFactory(marsProperty,application)

        binding.viewModel=ViewModelProvider(this,viewModelFactory).get(DetailFragmentViewModel::class.java)

        return binding.root
    }

}