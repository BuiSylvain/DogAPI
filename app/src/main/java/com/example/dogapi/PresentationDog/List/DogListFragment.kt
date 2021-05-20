package com.example.dogapi.PresentationDog.List

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dogapi.R

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

        val dogList = arrayListOf<Dog>().apply {
            add(Dog("dog1"))
            add(Dog("dog2"))
            add(Dog("dog3"))

        }
        adapter.updateList(dogList)

    }
}