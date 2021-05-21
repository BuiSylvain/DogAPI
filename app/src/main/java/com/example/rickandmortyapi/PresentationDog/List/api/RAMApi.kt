package com.example.rickandmortyapi.PresentationDog.List.api

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path


interface RAMApi {
    @GET("character")
    fun getRAMList(): Call<RAMListResponse>

    @GET("character/{id}")
    fun getRAMDetail(@Path("id") id: Int): Call<RAMDetailResponse>
}