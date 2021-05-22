package com.example.rickandmortyapi.PresentationDog.List

sealed class RAMModel

data class RamSuccess(val ramList: List<RAM>) : RAMModel()
object RAMLoader : RAMModel()
object RAMError : RAMModel()