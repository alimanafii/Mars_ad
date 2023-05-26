package com.example.edwfrefref

import com.example.edwfrefref.network.MarsProperty
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

enum class MarsApiFilter(val value:String){
    SHOW_RENT("rent"),
    SHOW_BUY("buy"),
    SHOW_ALL("all")
}

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MarsApiServices {
    @GET("realestate")
    suspend fun getMarsProperty(@Query("filter")type:String): List<MarsProperty>
}

object MarsApi {
    val MarsApiService: MarsApiServices by lazy {
        retrofit.create(MarsApiServices::class.java)
    }
}
