package com.battermind.aug2024bootcamp.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.battermind.aug2024bootcamp.R
import com.battermind.aug2024bootcamp.databinding.ActivityLifeCycleBinding

class ActivityLifeCycle : AppCompatActivity() {

    lateinit var binding: ActivityLifeCycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e(TAG, "Activity  : onCreate")
//        logPrint()
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "Activity  : onStart")
        binding.buttonAddFragment.setOnClickListener {
            // Create an instance of the fragment
            val fragment = LifeCycleFragment    ()

            // Add the fragment to the 'fragment_container' FrameLayout
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        binding.buttonDialog.setOnClickListener {
            val bottomSheetFragment = InfoBottomSheetDialog()
            bottomSheetFragment.show(supportFragmentManager, "MyBottomSheet")
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Activity  : onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "Activity  : onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "Activity  : onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "Activity  : onDestroy")
    }


    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "Activity  : onRestart")
    }

    companion object {
        const val TAG = "ActivityLifeCycle"
    }

    private fun logPrint() {
        Log.v("TAG", "This is a verbose log message")
        Log.d("TAG", "This is a debug log message")
        Log.i("TAG", "This is an info log message")
        Log.w("TAG", "This is a warning log message")
        Log.e("TAG", "This is an error log message")
    }

}