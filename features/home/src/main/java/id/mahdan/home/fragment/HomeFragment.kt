package id.mahdan.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import id.mahdan.common.base.BaseFragment
import id.mahdan.common.base.BaseViewModel
import id.mahdan.common.extension.onScrollToEnd
import id.mahdan.home.view.MovieAdapter
import id.mahdan.home.databinding.FragmentHomeBinding
import id.mahdan.home.viewmodel.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment(){

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureRecyclerView()
        configureObserver()
        configureEvent()
    }

    private fun configureEvent(){
        binding.fragmentHomeRv.onScrollToEnd(3) {
            binding.viewmodel?.onScrolledToBottom()
        }
    }

    private fun configureObserver(){
        binding.viewmodel?.titleSearch?.observe(viewLifecycleOwner, Observer {
            binding.viewmodel?.searchMovies(it, false)
        })
    }

    private fun configureRecyclerView() {
        binding.fragmentHomeRv.adapter = MovieAdapter(viewModel)
    }
}