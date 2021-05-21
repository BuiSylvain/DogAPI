package com.example.dogapi.PresentationDog.List.api

import retrofit2.http.GET
import retrofit2.Call


interface DogApi {
    @GET("character")
    //fun getDogList(@Path("user") user: String?): Call<List<Repo>>
    fun getDogList(): Call<DogResponse>
}