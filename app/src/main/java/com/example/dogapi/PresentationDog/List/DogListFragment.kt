package com.example.dogapi.PresentationDog.List

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dogapi.PresentationDog.List.api.DogApi
import com.example.dogapi.PresentationDog.List.api.DogResponse
import com.example.dogapi.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DogListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = DogAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dog_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       recyclerView =view.findViewById(R.id.dog_recyclerview)
        recyclerView.apply {
            layoutManager = this@DogListFragment.layoutManager
            adapter= this@DogListFragment.adapter
        }


        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val dogApi: DogApi = retrofit.create(DogApi::class.java)

        dogApi.getDogList().enqueue(object: Callback<DogResponse> {
            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val dogResponse = response.body()!!
                    adapter.updateList(dogResponse.results)
                }
            }

        })



        /*val dogList = arrayListOf<Dog>().apply {
            add(Dog("dog1"))
            add(Dog("dog2"))
            add(Dog("dog3"))

        }*/

    }
}