package com.battermind.aug2024bootcamp.ui.program.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.battermind.aug2024bootcamp.database.BetterMindDatabase
import com.battermind.aug2024bootcamp.database.BetterMindDatabase.AppDataBase.getDataBase
import com.battermind.aug2024bootcamp.database.model.ProgramModel
import com.battermind.aug2024bootcamp.databinding.FragmentProgramAddBinding
import com.battermind.aug2024bootcamp.utils.Router
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AddNewProgramFragment : Fragment() {

    private var _binding: FragmentProgramAddBinding? = null

    private val binding get() = _binding!!
    private val router: Router by lazy { Router(findNavController()) }
    private var database: BetterMindDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        database = getDataBase(requireContext())
        _binding = FragmentProgramAddBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.icBack.setOnClickListener {
            router.navigateBack()
        }

        binding.addNow.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                database?.programDao()?.insert(getNewProgram())
                withContext(Dispatchers.Main) {
                    router.navigateBack()
                }
            }
        }
    }

    private fun getNewProgram(): ProgramModel {

        val title = binding.etProgramTitle.text.toString()
        val duration = binding.etProgramDuration.text.toString()
        val description = binding.etProgramDescription.text.toString()
        return ProgramModel(title = title, duration = duration, description = description)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}