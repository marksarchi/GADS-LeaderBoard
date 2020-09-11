package com.sarchimarcus.gads_learderboard

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sarchimarcus.gads_learderboard.learning.LearnersAdapter
import com.sarchimarcus.gads_learderboard.network.LearningStudent
import com.sarchimarcus.gads_learderboard.network.SkillStudent
import com.sarchimarcus.gads_learderboard.skills.SkillAdapter

@BindingAdapter("listdata")
fun bindRecyclerView(recyclerView: RecyclerView, data :List<LearningStudent>?){
val adapter = recyclerView.adapter as? LearnersAdapter
    adapter?.submitList(data)
}

@BindingAdapter("skilldata")
fun bindSkillRecyclerView(recyclerView: RecyclerView, data :List<SkillStudent>?){
    val adapter = recyclerView.adapter as? SkillAdapter
    adapter?.submitList(data)
}


/*@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,data:List<LearningStudent>?){
    val adapter = recyclerView.adapter as LearnersAdapter
    adapter.submitList(data)
}*/

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl :String?){

    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .into(imageView)

    }
}
