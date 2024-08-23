package com.battermind.aug2024bootcamp.ui.adminDashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.battermind.aug2024bootcamp.databinding.FragmentAdminDashboardBinding
import com.battermind.aug2024bootcamp.databinding.FragmentFirstBinding
import com.battermind.aug2024bootcamp.databinding.FragmentSplashScreenBinding
import com.battermind.aug2024bootcamp.databinding.FragmentUserDashboardBinding
import com.battermind.aug2024bootcamp.utils.Router
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class AdminDashboardFragment : Fragment() {

    private var _binding: FragmentAdminDashboardBinding? = null

    private val binding get() = _binding!!
    private val router: Router by lazy { Router(findNavController()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAdminDashboardBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        binding.icLogOut.setOnClickListener {
            router.gotoHomeDashboard()
        }
        binding.manageInquiry.setOnClickListener {
            router.gotoInquiryList()
        }
        binding.manageProgram.setOnClickListener {
            router.gotoProgramList()
        }
    }
}