package app.market.effectivemobilemock.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.market.effectivemobilemock.databinding.FragmentHomeBinding
import app.market.effectivemobilemock.ui.adapter_delegate.CourseAdapter
import app.market.effectivemobilemock.ui.adapter_delegate.HomeHeaderAdapter
import app.market.effectivemobilemock.ui.adapter_delegate.HomeMainAdapter
import app.market.effectivemobilemock.ui.adapter_delegate.MockData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var courseAdapter: CourseAdapter

    @Inject
    lateinit var homeHeaderAdapter: HomeHeaderAdapter

    private lateinit var homeMainAdapter: HomeMainAdapter
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.createDummyDisplayableItems()

        homeMainAdapter = HomeMainAdapter(courseAdapter)

        binding.rvHome.apply {
            adapter = homeMainAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            itemAnimator = DefaultItemAnimator()
        }

        homeViewModel.displayableItems.observe(viewLifecycleOwner) {
            homeMainAdapter.items = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}