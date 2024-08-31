package com.battermind.aug2024bootcamp.ui.program.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.battermind.aug2024bootcamp.database.BetterMindDatabase
import com.battermind.aug2024bootcamp.database.BetterMindDatabase.AppDataBase.getDataBase
import com.battermind.aug2024bootcamp.database.model.ProgramModel
import com.battermind.aug2024bootcamp.databinding.FragmentProgramListBinding
import com.battermind.aug2024bootcamp.utils.Router
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//comment
class ProgramListFragment : Fragment() {

    private var _binding: FragmentProgramListBinding? = null

    private val binding get() = _binding!!
    private val router: Router by lazy { Router(findNavController()) }

    private var database: BetterMindDatabase? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        database = getDataBase(requireContext())
        _binding = FragmentProgramListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.icBack.setOnClickListener {
            router.navigateBack()
        }

        binding.icAdd.setOnClickListener {
            router.gotoAddNewProgram()
        }
        CoroutineScope(Dispatchers.IO).launch {
            val programsDao = database?.programDao()
            programsDao?.insert()
            var data = programsDao?.getAll()

            withContext(Dispatchers.Main) {
                val adapter = ProgramAdapter(data ?: emptyList(),::programItemTap )
                binding.rvProgramList.adapter = adapter

            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun programItemTap(programModel: ProgramModel) {
router.gotoProgramDetail()
    }
}