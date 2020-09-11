package com.sarchimarcus.gads_learderboard.submit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sarchimarcus.gads_learderboard.repository.LeaderRepository

class SubmitViewModelFactory (private  val leaderRepository: LeaderRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(SubmitViewModel::class.java)){
           return SubmitViewModel(leaderRepository) as T
       }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}