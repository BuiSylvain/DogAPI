package com.example.rickandmortyapi.PresentationDog.List.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.rickandmortyapi.PresentationDog.List.Singletons
import com.example.rickandmortyapi.PresentationDog.List.api.RAMDetailResponse
import com.example.rickandmortyapi.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RAMDetailFragment : Fragment() {


    private lateinit var textViewName: TextView



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ram_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.ram_detail_name)
        callApi()
    }

    private fun callApi() {
        val id = arguments?.getInt("ramId") ?: -1
        Singletons.ramApi.getRAMDetail(id).enqueue(object : Callback<RAMDetailResponse>{
            override fun onFailure(call: Call<RAMDetailResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<RAMDetailResponse>, response: Response<RAMDetailResponse>) {
                if(response.isSuccessful && response.body() != null){
                    textViewName.text = response.body()!!.name
                }
            }
        })
    }
}