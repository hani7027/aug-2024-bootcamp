package com.battermind.aug2024bootcamp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.battermind.aug2024bootcamp.databinding.LogInScreenBinding

class LoginFragment : Fragment() {

    private var _binding: LogInScreenBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = LogInScreenBinding.inflate(inflater, container, false)
        return binding.root

    }

    data class Person(val id: Int)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            if (validate()) {
                Toast.makeText(
                    requireContext(),
                    "Valid",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Invalid",
                    Toast.LENGTH_LONG
                ).show()
            }

        }


    }


    private fun validate(): Boolean {
        val email = binding.usernameEditText.text?.toString()
        val password = binding.passwordEditText.text?.toString()
        val isValidEmail = email?.equals(ADMIN_EMAIL)?:false
        val isValidPassword = password?.equals(ADMIN_PASSWORD)?:false
        return isValidEmail && isValidPassword

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    companion object {
        private const val ADMIN_EMAIL = "admin@mind.com"
        private const val ADMIN_PASSWORD = "1234"
    }

}