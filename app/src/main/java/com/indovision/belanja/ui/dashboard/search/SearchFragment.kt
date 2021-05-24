package com.indovision.belanja.ui.dashboard.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.indovision.belanja.data.source.remote.RemoteDataSource
import com.indovision.belanja.databinding.FragmentSearchBinding
import com.indovision.belanja.ui.dashboard.search.adapter.SearchAdapter
import com.indovision.belanja.viewmodel.SearchViewModel
import com.indovision.belanja.viewmodel.ViewModelFactory

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding as FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        val factory = ViewModelFactory.getInstance(RemoteDataSource())
        val viewModel = ViewModelProvider(this, factory)[SearchViewModel::class.java]

        viewModel.getProductSearch(SearchFragmentArgs.fromBundle(arguments as Bundle).searchText)
            .observe(viewLifecycleOwner, {
                val adapter = SearchAdapter(it)
                with(binding) {
                    rvResultSearch.adapter = adapter
                    rvResultSearch.setHasFixedSize(true)
                    rvResultSearch.layoutManager =
                        GridLayoutManager(context, 2)
                }
            })
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
