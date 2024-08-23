package com.battermind.aug2024bootcamp.ui.inquiry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.battermind.aug2024bootcamp.databinding.FragmentInquiryDetailBinding
import com.battermind.aug2024bootcamp.databinding.FragmentInquiryFormBinding
import com.battermind.aug2024bootcamp.databinding.FragmentInquiryListBinding
import com.battermind.aug2024bootcamp.utils.Router


class InquiryDetailsFragment : Fragment() {

    private var _binding: FragmentInquiryDetailBinding? = null

    private val binding get() = _binding!!
    private val router: Router by lazy { Router(findNavController()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentInquiryDetailBinding.inflate(inflater, container, false)
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