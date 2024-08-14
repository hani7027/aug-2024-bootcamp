package com.battermind.aug2024bootcamp.binding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.battermind.aug2024bootcamp.R
import com.battermind.aug2024bootcamp.databinding.FragmentBindingBinding


class BindingFragment : Fragment() {

    private var _binding: FragmentBindingBinding? = null
    private val binding: FragmentBindingBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBindingBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}