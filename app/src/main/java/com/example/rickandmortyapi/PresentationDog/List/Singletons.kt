package com.example.rickandmortyapi.PresentationDog.List

import com.example.rickandmortyapi.PresentationDog.List.RamApplication.Companion.context
import com.example.rickandmortyapi.PresentationDog.List.api.RAMApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons{
    companion object{
        var cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024)
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()
        val ramApi: RAMApi = Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(RAMApi::class.java)


    }
}
