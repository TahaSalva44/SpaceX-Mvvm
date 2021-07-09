package com.example.galeritutorial.ui.first

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.example.galeritutorial.R
import com.example.galeritutorial.base.BaseFragment
import com.example.galeritutorial.databinding.FirstFragmentBinding
import com.example.galeritutorial.interfaces.ISpaceX
import com.example.galeritutorial.model.LaunchesEntityItem
import com.example.galeritutorial.model.Photo
import com.example.galeritutorial.ui.first.adapter.AdapterSpaceX
import com.example.galeritutorial.util.SharedPref
import com.example.galeritutorial.util.SpaceXKeyword

class FirstFragment : BaseFragment<FirstViewModel, FirstFragmentBinding>(), ISpaceX {

    override val getLayoutId: Int = R.layout.first_fragment
    override val viewModelClass = FirstViewModel::class.java
    private val launchesList: ArrayList<LaunchesEntityItem> = arrayListOf()

    private val photoAdapter = AdapterSpaceX(launchesList, this)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        setHasOptionsMenu(true)
        viewModel.getLaunches()
        initRecycler()
        observe()
    }

    private fun initRecycler() {
        binding.recyclerPhoto.adapter = photoAdapter
    }

    private fun observe() {
        viewModel.launchesEntity.observe(viewLifecycleOwner, Observer {
            launchesList.clear()
            launchesList.addAll(it)
            photoAdapter.notifyDataSetChanged()
        })
    }

    override fun clicked(launchesEntityItem: LaunchesEntityItem) {
        val bundle = Bundle()
        bundle.putString(SpaceXKeyword.PHOTO_IMAGE, launchesEntityItem.links.missionPatch)
        bundle.putString(SpaceXKeyword.ROCKET_NAME, launchesEntityItem.rocket.rocketName)
        bundle.putString(SpaceXKeyword.DETAIL, launchesEntityItem.details)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_firstFragment_to_secondFragment, bundle)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            R.id.action_selectyear -> {
                showYearSelectionDialog()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun loadLaunches(year: Int?) {
        val yearPref = context?.let { SharedPref.getInt(it, SharedPref.YEAR, 2016) }
        if (year?.equals(yearPref)?.not()!!) {
            context?.let { SharedPref.putInt(it, SharedPref.YEAR, year) }
            viewModel.getLaunches(year)
        }
    }

    private fun showYearSelectionDialog() {
        val dialog = YearSelectionDialog()
        dialog.setCallback(object : YearSelectionDialog.YearSelectionCallback {
            override fun onSelectYear(year: Int) {
                loadLaunches(year)
            }
        })
        activity?.supportFragmentManager?.let { dialog.show(it, "yearselection") }
    }

}
