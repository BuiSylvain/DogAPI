package com.example.rickandmortyapi.PresentationDog.List.api

import com.example.rickandmortyapi.PresentationDog.List.RAM

data class RAMListResponse(
        val count: Int,
        val results: List<RAM>
)