package com.example.galeritutorial.ui.second

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.galeritutorial.MainActivity

import com.example.galeritutorial.R
import com.example.galeritutorial.base.BaseFragment
import com.example.galeritutorial.databinding.SecondFragmentBinding
import com.example.galeritutorial.di.scope.Injectable
import com.example.galeritutorial.model.Comments
import com.example.galeritutorial.util.SpaceXKeyword

class SecondFragment : BaseFragment<SecondViewModel, SecondFragmentBinding>(), Injectable {

    private var rocketName: String? = null
    private var photoImageUrl: String? = null
    private var details: String? = null
    private val commentList: ArrayList<Comments> = arrayListOf()
    override val getLayoutId: Int = R.layout.second_fragment
    override val viewModelClass = SecondViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getData()
    }

    private fun getData() {
        rocketName = arguments?.getString(SpaceXKeyword.ROCKET_NAME)
        photoImageUrl = arguments?.getString(SpaceXKeyword.PHOTO_IMAGE)
        details = arguments?.getString(SpaceXKeyword.DETAIL)
        photoImageUrl?.let { image ->
            rocketName?.let { rocketName ->
                details?.let { detail ->
                    viewModel.getData(
                        image, rocketName,
                        detail
                    )
                }
            }
        }
    }

}
