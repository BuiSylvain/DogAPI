package com.example.rickandmortyapi.PresentationDog.List

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.PresentationDog.List.api.RAMApi
import com.example.rickandmortyapi.PresentationDog.List.api.RAMResponse
import com.example.rickandmortyapi.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RAMListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = RAMAdapter(listOf(), ::onClickedRAM)
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ram_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       recyclerView =view.findViewById(R.id.ram_recyclerview)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter= this@RAMListFragment.adapter
        }


        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val RAMApi: RAMApi = retrofit.create(RAMApi::class.java)

        RAMApi.getRAMList().enqueue(object: Callback<RAMResponse> {
            override fun onFailure(call: Call<RAMResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<RAMResponse>, response: Response<RAMResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val ramResponse = response.body()!!
                    adapter.updateList(ramResponse.results)
                }
            }

        })
    }

    private fun onClickedRAM(RAM: RAM){
        findNavController().navigate(R.id.navigateToRAMDetailFragment)
    }
}