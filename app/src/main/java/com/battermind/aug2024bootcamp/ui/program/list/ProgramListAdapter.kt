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