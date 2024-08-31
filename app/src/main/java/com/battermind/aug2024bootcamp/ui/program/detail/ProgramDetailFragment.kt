package com.battermind.aug2024bootcamp.ui.program.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.battermind.aug2024bootcamp.databinding.FragmentProgramDetailBinding
import com.battermind.aug2024bootcamp.utils.PROGRAM_TITLE
import com.battermind.aug2024bootcamp.utils.Router
import com.battermind.aug2024bootcamp.utils.SharedPreferencesUtil


class ProgramDetailFragment : Fragment() {

    private var _binding: FragmentProgramDetailBinding? = null
    private val binding get() = _binding!!
    private val router: Router by lazy { Router(findNavController()) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProgramDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.icBack.setOnClickListener {
            router.navigateBack()
        }

        val title = SharedPreferencesUtil.getString(requireContext(), PROGRAM_TITLE)
        binding.title.text = title
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}