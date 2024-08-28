package com.battermind.aug2024bootcamp.ui.program.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.battermind.aug2024bootcamp.database.model.ProgramModel
import com.battermind.aug2024bootcamp.databinding.ItemProgramBinding

class ProgramListAdapter(private val call: (programModel: ProgramModel) -> Unit) :
    ListAdapter<ProgramModel, ProgramListAdapter.ProgramViewHolder>(ProgramDiffUtils()) {

    class ProgramViewHolder(
        private val v: ItemProgramBinding,
        val call: (programModel: ProgramModel) -> Unit
    ) :
        RecyclerView.ViewHolder(v.root) {

        fun bind(programModel: ProgramModel) {
            v.root.setOnClickListener {
                call(programModel)
            }
            v.txtTitle.text = programModel.title
            v.txtDuration.text = programModel.duration
            v.txtDescription.text = programModel.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val binding =
            ItemProgramBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.e("ExampleListAdapter", "onCreateViewHolder call")
        return ProgramViewHolder(binding, call)
    }


    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    private class ProgramDiffUtils : DiffUtil.ItemCallback<ProgramModel>() {
        override fun areItemsTheSame(oldItem: ProgramModel, newItem: ProgramModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProgramModel, newItem: ProgramModel): Boolean {
            return oldItem == newItem
        }
    }

}

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class ProgramAdapter(private val programs: List<Program>) :
    RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder>() {
    class ProgramViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val programName: TextView = view.findViewById(R.id.programName)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_program, parent, false)
        return ProgramViewHolder(view)
    }
    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        val program = programs[position]
        holder.programName.text = program.title
    }
    override fun getItemCount() = programs.size
}

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val programs = listOf(
            Program("AI/ML 1 Day Workshop"),
            Program("AI/ML Bootcamp"),
            Program("App Development Internship Program"),
            Program("Computer Science and Business Internship Program"),
            Program("Computer Science and Business Internship Program")
        )
        val adapter = ProgramAdapter(programs)
        recyclerView.adapter = adapter
    }
}