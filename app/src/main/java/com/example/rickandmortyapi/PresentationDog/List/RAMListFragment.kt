package com.example.rickandmortyapi.PresentationDog.List

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.PresentationDog.List.api.RAMListResponse
import com.example.rickandmortyapi.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RAMListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loader: ProgressBar
    private lateinit var textViewError: TextView
    private val adapter = RAMAdapter(listOf(), ::onClickedRAM)
    private val viewModel : RAMListViewModel by viewModels()

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
        loader = view.findViewById(R.id.ram_loader)
        textViewError = view.findViewById(R.id.ram_error)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter= this@RAMListFragment.adapter
        }
        viewModel.ramList.observe(viewLifecycleOwner, Observer{ramModel ->
            loader.isVisible = ramModel is RAMLoader
            textViewError.isVisible = ramModel is RAMError

            if(ramModel is RamSuccess) {
                adapter.updateList(ramModel.ramList)
            }
        })

    }



    private fun showList(ramList: List<RAM>) {
        adapter.updateList(ramList)
    }

    private fun onClickedRAM(id: Int){

        findNavController().navigate(R.id.navigateToRAMDetailFragment, bundleOf(
                "ramId" to (id + 1)
        ))
    }
}