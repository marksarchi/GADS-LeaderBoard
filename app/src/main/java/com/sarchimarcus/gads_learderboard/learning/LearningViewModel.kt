package com.sarchimarcus.gads_learderboard.learning

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarchimarcus.gads_learderboard.network.LearningStudent
import com.sarchimarcus.gads_learderboard.repository.LeaderRepository

class LearningViewModel (leaderRepository: LeaderRepository) : ViewModel(){

    private val repository = leaderRepository


    private var _studentList  = MutableLiveData<List<LearningStudent>>()

    val studentList: LiveData<List<LearningStudent>>
        get() {
            return  _studentList
        }


    init {
       _studentList = repository.getLearningLeaders()
        Log.e("LearningViewModel",_studentList.value.toString())
    }




}