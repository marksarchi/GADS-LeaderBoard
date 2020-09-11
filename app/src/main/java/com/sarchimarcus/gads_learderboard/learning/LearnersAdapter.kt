package com.sarchimarcus.gads_learderboard.learning


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sarchimarcus.gads_learderboard.databinding.ListItemBinding
import com.sarchimarcus.gads_learderboard.network.LearningStudent
import androidx.recyclerview.widget.ListAdapter

class LearnersAdapter () : ListAdapter<LearningStudent,LearnersAdapter.ViewHolder>(DiffCallback){
    companion object DiffCallback :DiffUtil.ItemCallback<LearningStudent>() {
        override fun areItemsTheSame(oldItem: LearningStudent, newItem: LearningStudent): Boolean {
           return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: LearningStudent,
            newItem: LearningStudent
        ): Boolean {
           return  oldItem.hours == newItem.hours
        }

    }
    class ViewHolder(private var binding: ListItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(student: LearningStudent){
            binding.student = student
            binding.executePendingBindings()
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return  ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val student = getItem(position)
        holder.bind(student)
    }
}