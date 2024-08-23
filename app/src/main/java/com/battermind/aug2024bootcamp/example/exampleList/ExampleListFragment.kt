package com.battermind.aug2024bootcamp.example.exampleList

import android.os.Bundle
import android.util.Log
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

    private var list: MutableList<ExampleModel> = mutableListOf()
    private val adapter: ExampleListAdapter by lazy { ExampleListAdapter(::call) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExampleListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val adapter = ExampleListAdapter(::call)
        binding.rvProgramList.adapter = adapter
        list = dummyData100().toMutableList()
        adapter.submitList(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun call(exampleModel: ExampleModel) {
        Log.e("call", "title: " + exampleModel.title)
        binding.rvProgramList.adapter = adapter
        list.remove(exampleModel)
        adapter.submitList(list)
    }

    private fun setViewModelData() {
        // Observe the LiveData list
        viewModel.exampleList.observe(viewLifecycleOwner, Observer { list ->
//            adapter.submitList(list)
        })

    }

}