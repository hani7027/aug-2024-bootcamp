package com.battermind.aug2024bootcamp.example.exampleList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.battermind.aug2024bootcamp.databinding.FragmentExampleListBinding


class ExampleListFragment : Fragment() {

    private var _binding: FragmentExampleListBinding? = null
    private val viewModel: ExampleViewModel by viewModels()
    private val binding get() = _binding!!

    private val list: MutableList<ExampleModel> = mutableListOf()
    private val adapter: ExampleListAdapter by lazy { ExampleListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExampleListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvProgramList.adapter = adapter
        adapter.submitList(getDummyList15())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setViewModelData() {
        // Observe the LiveData list
        viewModel.exampleList.observe(viewLifecycleOwner, Observer { list ->
            adapter.submitList(list)
        })

    }

}