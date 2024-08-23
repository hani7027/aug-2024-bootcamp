package com.battermind.aug2024bootcamp.example.exampleList

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.battermind.aug2024bootcamp.databinding.ItemExampleListBinding

class ExampleListAdapter(val call: (exampleModel: ExampleModel) -> Unit) :
    ListAdapter<ExampleModel, ExampleListAdapter.ProgramViewHolder>(ProgramDiffUtils()) {

    class ProgramViewHolder(
        private val v: ItemExampleListBinding,
        val call: (exampleModel: ExampleModel) -> Unit
    ) :
        RecyclerView.ViewHolder(v.root) {

        fun bind(exampleModel: ExampleModel) {
            v.root.setOnClickListener {
                call(exampleModel)
            }
            v.title.text = exampleModel.title
            v.subtitle.text = exampleModel.subTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val binding =
            ItemExampleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.e("ExampleListAdapter", "onCreateViewHolder call")
        return ProgramViewHolder(binding, call)
    }


    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    private class ProgramDiffUtils : DiffUtil.ItemCallback<ExampleModel>() {
        override fun areItemsTheSame(oldItem: ExampleModel, newItem: ExampleModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ExampleModel, newItem: ExampleModel): Boolean {
            return oldItem == newItem
        }
    }

}