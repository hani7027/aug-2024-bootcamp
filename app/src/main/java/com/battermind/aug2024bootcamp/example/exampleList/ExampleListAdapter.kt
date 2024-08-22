package com.battermind.aug2024bootcamp.example.exampleList

import android.graphics.Rect
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.battermind.aug2024bootcamp.databinding.ItemExampleListBinding

class ExampleListAdapter :
    ListAdapter<ExampleModel, ExampleListAdapter.ProgramViewHolder>(ProgramDiffUtils()) {

    class ProgramViewHolder(private val v: ItemExampleListBinding) :
        RecyclerView.ViewHolder(v.root) {
        fun bind(exampleModel: ExampleModel) {
            v.title.text = exampleModel.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val binding =
            ItemExampleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.e("ExampleListAdapter","onCreateViewHolder")
        return ProgramViewHolder(binding)
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