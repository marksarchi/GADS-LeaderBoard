package com.sarchimarcus.gads_learderboard.skills

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarchimarcus.gads_learderboard.network.SkillStudent
import com.sarchimarcus.gads_learderboard.repository.LeaderRepository

class SkillViewModel(leaderRepository: LeaderRepository) : ViewModel(){

    private var _studentList  = MutableLiveData<List<SkillStudent>>()

    val studentList:LiveData<List<SkillStudent>>
    get() {
        return  _studentList
    }



    init {
        _studentList = leaderRepository.getSkillIQLeaders()
    }




}