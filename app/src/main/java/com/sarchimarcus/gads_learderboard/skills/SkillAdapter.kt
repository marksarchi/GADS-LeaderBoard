package com.sarchimarcus.gads_learderboard.skills

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sarchimarcus.gads_learderboard.databinding.ListItemBinding
import com.sarchimarcus.gads_learderboard.databinding.SkillItemBinding
import com.sarchimarcus.gads_learderboard.network.LearningStudent
import com.sarchimarcus.gads_learderboard.network.SkillStudent


class SkillAdapter () : ListAdapter<SkillStudent, SkillAdapter.ViewHolder>(DiffCallback){
    companion object DiffCallback : DiffUtil.ItemCallback<SkillStudent>() {
        override fun areItemsTheSame(oldItem: SkillStudent, newItem: SkillStudent): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: SkillStudent,
            newItem: SkillStudent
        ): Boolean {
            return  oldItem.score == newItem.score
        }

    }
    class ViewHolder(private var binding: SkillItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(student: SkillStudent){
            binding.student = student
            binding.executePendingBindings()
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(SkillItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = getItem(position)
        holder.bind(student)
    }
}