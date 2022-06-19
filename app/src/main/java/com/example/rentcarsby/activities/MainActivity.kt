package com.example.rentcarsby.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import com.example.rentcarsby.R
import com.example.rentcarsby.data_base.entity.CarEntity
import com.example.rentcarsby.fragments.RecyclerViewFragment
import com.example.rentcarsby.fragments.SecondFragment
import com.example.rentcarsby.view_model.CarReviewViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), ActivityOnItemClick {
    private lateinit var viewmodel: CarReviewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProvider(this).get(CarReviewViewModel::class.java)

        val carsList = intent.getParcelableArrayListExtra<CarEntity>("carsList")
        val fragment = RecyclerViewFragment()

        fragment.arguments = bundleOf("carsList" to carsList)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_main_activity, fragment)
            .addToBackStack(null)
            .commit()
    }


    override fun startSecondFrag(position: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            viewmodel.getCarFromRepo(position)
        }
        val fragment = SecondFragment()
        viewmodel.getCarImpl().observe(this, {

            fragment.arguments = bundleOf("car" to it)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_main_activity, fragment)
                .commit()
        })
        }
}