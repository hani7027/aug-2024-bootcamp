package com.battermind.aug2024bootcamp.example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.battermind.aug2024bootcamp.databinding.FragmentFirstBinding
import com.battermind.aug2024bootcamp.utils.Router

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FirstFragmentViewModel by viewModels()

    private val router: Router by lazy { Router(findNavController()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gotoNextFragment.setOnClickListener {
            router.gotoSecondFragment()
        }
        viewModel.count.observe(viewLifecycleOwner) { count ->
            binding.myCount.text = count.toString()

        }
        binding.add.setOnClickListener {
            viewModel.increaseCount()
        }

    }


}