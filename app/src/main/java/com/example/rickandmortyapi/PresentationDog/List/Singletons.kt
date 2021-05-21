package com.example.rickandmortyapi.PresentationDog.List

import com.example.rickandmortyapi.PresentationDog.List.api.RAMApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons{
    companion object{
        val ramApi: RAMApi = Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RAMApi::class.java)
    }
}
