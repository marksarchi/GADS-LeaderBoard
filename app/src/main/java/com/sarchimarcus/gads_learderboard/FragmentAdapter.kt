package com.sarchimarcus.gads_learderboard

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sarchimarcus.gads_learderboard.learning.LearningFragment
import com.sarchimarcus.gads_learderboard.skills.SkillFragment

class FragmentAdapter (fragmentManager: FragmentManager,lifecycle: Lifecycle) :FragmentStateAdapter(fragmentManager,lifecycle){

    val fragments:ArrayList<Fragment> = arrayListOf(
       LearningFragment(),SkillFragment()
    )
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
       return fragments[position]
    }
}