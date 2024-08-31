package com.battermind.aug2024bootcamp.ui.userDashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.battermind.aug2024bootcamp.databinding.FragmentFirstBinding
import com.battermind.aug2024bootcamp.databinding.FragmentSplashScreenBinding
import com.battermind.aug2024bootcamp.databinding.FragmentUserDashboardBinding
import com.battermind.aug2024bootcamp.utils.IS_USER_LOGIN
import com.battermind.aug2024bootcamp.utils.Router
import com.battermind.aug2024bootcamp.utils.SharedPreferencesUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class UserDashboardFragment : Fragment() {

    private var _binding: FragmentUserDashboardBinding? = null

    private val binding get() = _binding!!
    private val router: Router by lazy { Router(findNavController()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUserDashboardBinding.inflate(inflater, container, false)
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
        binding.icLogin.setOnClickListener {
            SharedPreferencesUtil.putBoolean(requireContext(), IS_USER_LOGIN, false)
            router.gotoAdminLogin()
        }
        binding.technologyPrograms.setOnClickListener {
            router.gotoProgramList()
        }
        binding.contactUs.setOnClickListener {
            router.gotoContactUs()
        }
    }
}