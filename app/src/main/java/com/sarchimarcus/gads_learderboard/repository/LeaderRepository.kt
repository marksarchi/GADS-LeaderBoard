package com.sarchimarcus.gads_learderboard.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sarchimarcus.gads_learderboard.network.GadsApi
import com.sarchimarcus.gads_learderboard.network.LearningStudent
import com.sarchimarcus.gads_learderboard.network.SkillStudent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LeaderRepository {

    private var repoJob = Job()
    private val coroutineScope = CoroutineScope(repoJob + Dispatchers.Main)


     fun getLearningLeaders() :MutableLiveData<List<LearningStudent>>{
          val  studentList = MutableLiveData<List<LearningStudent>>()

        Log.e("Repository","getLearning leaders called")
        coroutineScope.launch {
            var getLearningListDeffered = GadsApi.retrofitService.getLearningLeaders()
            try {
                val listResult = getLearningListDeffered.await()
                studentList.value = listResult
                Log.e("Repository","studentList Updated")
                Log.e("Repository",listResult.toString())
            }catch (e : Exception){
                studentList.value = ArrayList()
                Log.e("Repository",e.localizedMessage.toString())
            }
        }
        return studentList
    }

    fun getSkillIQLeaders() :MutableLiveData<List<SkillStudent>>{
        val  studentList = MutableLiveData<List<SkillStudent>>()

        Log.e("Repository","getLearning leaders called")
        coroutineScope.launch {
            var getLearningListDeffered = GadsApi.retrofitService.getSkillLeaders()
            try {
                val listResult = getLearningListDeffered.await()
                studentList.value = listResult
                Log.e("Repository","studentList Updated")
                Log.e("Repository",listResult.toString())
            }catch (e : Exception){
                studentList.value = ArrayList()
                Log.e("Repository",e.localizedMessage.toString())
            }
        }
        return studentList
    }



}