package com.battermind.aug2024bootcamp.ui.contactUs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.battermind.aug2024bootcamp.databinding.FragmentContactUsBinding
import com.battermind.aug2024bootcamp.databinding.FragmentInquiryFormBinding
import com.battermind.aug2024bootcamp.utils.Router
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ContactUsFragment : Fragment() {

    private var _binding: FragmentContactUsBinding? = null

    private val binding get() = _binding!!
    private val router: Router by lazy { Router(findNavController()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentContactUsBinding.inflate(inflater, container, false)
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