package com.battermind.aug2024bootcamp.ui.program

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.battermind.aug2024bootcamp.databinding.FragmentProgramListBinding
import com.battermind.aug2024bootcamp.utils.Router


class ProgramListFragment : Fragment() {

    private var _binding: FragmentProgramListBinding? = null

    private val binding get() = _binding!!
    private val router: Router by lazy { Router(findNavController()) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProgramListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.icBack.setOnClickListener {
            router.navigateBack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}