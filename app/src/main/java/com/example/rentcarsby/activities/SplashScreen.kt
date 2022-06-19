package com.example.rentcarsby.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.rentcarsby.data_base.entity.CarEntity
import com.example.rentcarsby.view_model.RecyclerViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    private lateinit var viewModel: RecyclerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(RecyclerViewModel::class.java)
        viewModel.init(application)
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getCarsListFromRepository()
        }
        viewModel.getCarsListImpl().observe(this, {
            val carsList = ArrayList<CarEntity>(it)
            val intent = Intent(this, MainActivity::class.java)

            intent.putParcelableArrayListExtra("carsList", carsList)
            startActivity(intent)
            finish()
        })
    }
}