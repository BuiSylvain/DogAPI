package com.example.rickandmortyapi.PresentationDog.List

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.PresentationDog.List.api.RAMListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RAMListViewModel : ViewModel(){

    val ramList : MutableLiveData<RAMModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        ramList.value = RAMLoader
        Singletons.ramApi.getRAMList().enqueue(object : Callback<RAMListResponse> {
            override fun onFailure(call: Call<RAMListResponse>, t: Throwable) {
                ramList.value = RAMError
            }
            override fun onResponse(call: Call<RAMListResponse>, response: Response<RAMListResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val ramResponse = response.body()!!
                    ramList.value = RamSuccess(ramResponse.results)
                } else {
                    ramList.value = RAMError
                }
            }
        })
    }


}