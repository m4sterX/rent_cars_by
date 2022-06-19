package com.example.rentcarsby.view_model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rentcarsby.data_base.entity.CarEntity
import com.example.rentcarsby.repository.CarRepo
import com.example.rentcarsby.repository.CarRepoImpl

class RecyclerViewModel() : ViewModel() {

    private lateinit var carRepo: CarRepo
    private val carsListLiveData = MutableLiveData<List<CarEntity>>()
    private val carsListSettedLiveData = MutableLiveData<List<CarEntity>>()

    fun init(application: Application) {
         carRepo = CarRepoImpl(application)
    }

    fun getCarsListImpl(): LiveData<List<CarEntity>> {
        return carsListLiveData
    }

    fun getSettedCarsListLiveData() : LiveData<List<CarEntity>> {
        return carsListSettedLiveData
    }

    fun getCarsListFromRepository() {
        carsListLiveData.postValue(carRepo.getCarList())
        }

    fun setCarsToRepository(carsList: List<CarEntity>) {
        carsListSettedLiveData.postValue(carsList)
    }
}

