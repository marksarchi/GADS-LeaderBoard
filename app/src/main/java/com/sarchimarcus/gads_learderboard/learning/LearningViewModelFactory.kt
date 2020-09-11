package com.sarchimarcus.gads_learderboard.learning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sarchimarcus.gads_learderboard.repository.LeaderRepository

class LearningViewModelFactory (private val leaderRepository: LeaderRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(LearningViewModel::class.java)){
           return  LearningViewModel(leaderRepository) as T
       }
        throw  IllegalArgumentException("Unknown ViewModel")
    }
}