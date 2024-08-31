package com.battermind.aug2024bootcamp.ui.splashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.battermind.aug2024bootcamp.databinding.FragmentFirstBinding
import com.battermind.aug2024bootcamp.databinding.FragmentSplashScreenBinding
import com.battermind.aug2024bootcamp.utils.IS_USER_LOGIN
import com.battermind.aug2024bootcamp.utils.Router
import com.battermind.aug2024bootcamp.utils.SharedPreferencesUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenFragment : Fragment() {

    private var _binding: FragmentSplashScreenBinding? = null

    private val binding get() = _binding!!
    private val router: Router by lazy { Router(findNavController()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)

            val isAdminLogin = SharedPreferencesUtil.getBoolean(requireContext(), IS_USER_LOGIN)
            if(isAdminLogin){
                router.gotoAdminDashboard()
            }else{
                router.gotoHomeDashboard()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}