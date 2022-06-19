package com.example.rentcarsby.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rentcarsby.data_base.entity.CarEntity
import com.example.rentcarsby.repository.CarRepo
import com.example.rentcarsby.repository.CarRepoImpl

class CarReviewViewModel(application: Application): AndroidViewModel(application) {

    private val carRepo: CarRepo = CarRepoImpl(application)
    private val carSettingsLiveData = MutableLiveData<CarEntity>()

    fun getCarImpl(): LiveData<CarEntity> {
        return carSettingsLiveData
    }
    fun getCarFromRepo(id: Int) {
        carSettingsLiveData.postValue(carRepo.getCar(id))
    }
}