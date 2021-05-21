package com.example.dogapi.PresentationDog.List.api

import com.example.dogapi.PresentationDog.List.Dog

data class DogResponse(
        val count: Int,
        val results: List<Dog>
)