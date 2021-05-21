package com.example.rickandmortyapi.PresentationDog.List.api

data class RAMDetailResponse (
        val name: String,
        val RAMinfo : List<RAMInfo>
)

data class RAMInfo(
        val count : Int,
        val results : RAMResult
)

data class RAMResult(
        val id : Int,
        val url : String
)

