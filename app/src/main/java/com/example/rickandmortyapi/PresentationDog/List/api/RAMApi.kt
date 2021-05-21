package com.example.rickandmortyapi.PresentationDog.List.api

import retrofit2.http.GET
import retrofit2.Call


interface RAMApi {
    @GET("character")
    //fun getDogList(@Path("user") user: String?): Call<List<Repo>>
    fun getRAMList(): Call<RAMResponse>
}