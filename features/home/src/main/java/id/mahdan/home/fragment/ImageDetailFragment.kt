package id.mahdan.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import id.mahdan.common.base.BaseFragment
import id.mahdan.common.base.BaseViewModel
import id.mahdan.home.databinding.FragmentImageDetailBinding
import id.mahdan.home.viewmodel.ImageDetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ImageDetailFragment: BaseFragment() {

    private lateinit var binding: FragmentImageDetailBinding
    private val args: ImageDetailFragmentArgs by navArgs()
    private val viewModel: ImageDetailViewModel by viewModel()
    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadImage(args.url)
    }

}