package com.example.rentcarsby.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rentcarsby.R
import com.example.rentcarsby.activities.ActivityOnItemClick
import com.example.rentcarsby.adapter.MyRecyclerViewAdapter
import com.example.rentcarsby.data_base.entity.CarEntity
import java.util.*


class RecyclerViewFragment : Fragment() {
    private lateinit var carsList: ArrayList<CarEntity>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var list: ArrayList<CarEntity>? = arguments?.getParcelableArrayList<CarEntity>("carsList") as ArrayList<CarEntity>
        if (list != null) {
            carsList = list
        } else {
            Toast.makeText(view?.context,"carsList is null", Toast.LENGTH_LONG).show()
        }
        return inflater.inflate(R.layout.fragment_recyclerview, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val recAdapter = MyRecyclerViewAdapter({ position: Int ->
            onListItemClick(position)},
            carsList)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = recAdapter

        recyclerView.addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.HORIZONTAL))
        recyclerView.setHasFixedSize(true)
    }

    private fun onListItemClick(position: Int) {
        (activity as ActivityOnItemClick).startSecondFrag(position)
    }
}