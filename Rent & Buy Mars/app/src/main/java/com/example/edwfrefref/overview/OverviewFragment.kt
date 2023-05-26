package com.example.edwfrefref.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.edwfrefref.MarsApiFilter
import com.example.edwfrefref.R
import com.example.edwfrefref.databinding.FragmentOverviewBinding
import com.example.edwfrefref.recycler_grid_adapter

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        binding.recyclerGrid.adapter = recycler_grid_adapter(recycler_grid_adapter.OnClickListener {
            viewModel.displayMarsPropertyDetail(it)
        })




        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                this.findNavController()
                    .navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
            viewModel.displayMarsPropertyDetailCompleted()
            }

        })



        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.updateFilterMarsRealestate(
            when (item.itemId) {
                R.id.show_all_menu -> MarsApiFilter.SHOW_ALL
                R.id.show_buy_menu -> MarsApiFilter.SHOW_BUY
                R.id.show_rent_menu -> MarsApiFilter.SHOW_RENT
                else -> MarsApiFilter.SHOW_ALL
            }
        )
        return true
    }
}


