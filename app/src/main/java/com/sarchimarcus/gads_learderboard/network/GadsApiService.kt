package com.sarchimarcus.gads_learderboard.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory.Companion.invoke
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://gadsapi.herokuapp.com/api/"
private  const val BASE_FORMURL= "https://docs.google.com/forms/d/e/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

private val submitRetrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(   BASE_FORMURL)
    .build()

interface GadsApiService {

    @GET("hours")
    fun getLearningLeaders():Deferred<List<LearningStudent>>

    @GET("skilliq")
    fun getSkillLeaders() :Deferred<List<SkillStudent>>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
     fun postProjectDetails(

        @Field("entry.1824927963")emailAddress:String,
        @Field("entry.1877115667")firstName:String,
        @Field("entry.2006916086")lastName:String,
        @Field(" entry.284483984") link:String

    ): Call<Void>


}

object GadsApi {
   val retrofitService : GadsApiService by lazy {
       retrofit.create(GadsApiService::class.java)
   }
}

object SubmitApi {
    val retrofitService : GadsApiService by lazy {
        submitRetrofit.create(GadsApiService::class.java)
    }
}
//companion object {
//    // init Retrofit base server instance
//    val redditClient by lazy { GadsApiService.invoke(REDDIT_BASE_URL) }
//    val stackClient by lazy { GadsApiService.invoke(STACK_BASE_URL) }
//
//    private val loggingInterceptor = HttpLoggingInterceptor().apply {
//        this.level = HttpLoggingInterceptor.Level.BODY
//    }
//
//    operator fun invoke(baseUrl: String): GadsApiService {
////        val client = OkHttpClient.Builder().apply {
////            /**addNetworkInterceptor(StethoInterceptor()) */
////            addNetworkInterceptor(loggingInterceptor)
////            connectTimeout(10, TimeUnit.MINUTES)
////            readTimeout(10, TimeUnit.MINUTES)
////            writeTimeout(10, TimeUnit.MINUTES)
////        }.build()
//
//        return Retrofit.Builder()
//            .client(client)
//            .baseUrl(baseUrl)
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
//}