package com.sarchimarcus.gads_learderboard.skills

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sarchimarcus.gads_learderboard.repository.LeaderRepository

class SkillViewModelFactory (private val leaderRepository: LeaderRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SkillViewModel::class.java)){
            return  SkillViewModel(leaderRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}