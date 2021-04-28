package com.piappstudio.offlineexam.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.piappstudio.offlineexam.databinding.FragmentListBinding
import com.piappstudio.offlineexam.model.pojo.CardInfo
import com.piappstudio.offlineexam.model.pojo.Page

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
private const val ARG_PAGE_INFO = "ARG_PAGE_INFO"
class ListFragment : Fragment() {

    private var _binding:FragmentListBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter:HomeListAdapter
    var page:Page? = null
    private val viewModel:ListViewModel by lazy {
        ListViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            page = it.getParcelable(ARG_PAGE_INFO)
            viewModel.postPageInfo(page)
        }
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        adapter = HomeListAdapter(page?.cards?: emptyList())
        binding.rvList.adapter = adapter
        binding.rvList.layoutManager = LinearLayoutManager(context)
        viewModel.livePageInfo.observe(viewLifecycleOwner, {
            adapter.lstList = it.cards
            adapter.notifyDataSetChanged()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(pageInfo: Page) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PAGE_INFO, pageInfo)
                }
            }
    }
}