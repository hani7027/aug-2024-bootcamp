package com.battermind.aug2024bootcamp.lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.battermind.aug2024bootcamp.R
import com.battermind.aug2024bootcamp.databinding.FragmentLifeCycleBinding


class LifeCycleFragment : Fragment() {

    private val TAG = "MyFragment"

    private var _binding: FragmentLifeCycleBinding? = null
    private val binding: FragmentLifeCycleBinding get() = _binding!!
    private var aCount = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG, "Fragment : onAttach() called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aCount = savedInstanceState?.getInt("a") ?: 0
        Log.e(TAG, "Fragment : onCreate() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG, "Fragment : onCreateView() called")
        _binding = FragmentLifeCycleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "Fragment : onViewCreated() called")
        binding.textviewCount.text = aCount.toString()
        binding.buttonFirst.setOnClickListener {
            aCount++
            binding.textviewCount.text = aCount.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "Fragment : onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Fragment : onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "Fragment : onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "Fragment : onStop() called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "Fragment : onDestroyView() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        Log.e(TAG, "Fragment : onDestroy() called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("a", aCount)
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG, "Fragment : onDetach() called")
    }


    private fun logPrint() {
        Log.v("TAG", "This is a verbose log message")
        Log.d("TAG", "This is a debug log message")
        Log.i("TAG", "This is an info log message")
        Log.w("TAG", "This is a warning log message")
        Log.e("TAG", "This is an error log message")
    }

}

