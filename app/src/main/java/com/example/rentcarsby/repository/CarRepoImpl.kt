package com.example.rentcarsby.repository

import android.app.Application
import com.example.rentcarsby.data_base.AppDatabase
import com.example.rentcarsby.data_base.CarDao
import com.example.rentcarsby.data_base.entity.CarEntity

class CarRepoImpl(application: Application) : CarRepo{

    private var carDao: CarDao

    private var database : AppDatabase = AppDatabase.getInstance(application)

    init {
        carDao = database.carDao()
    }

    override fun getCarList() : List<CarEntity> {
        return carDao.selectAllCars()
        }

    override fun getCar(id: Int): CarEntity {
        return carDao.getCar(id)
    }

    override fun setCar(carEntity: CarEntity) {
        carDao.insertCar(carEntity)

    }

}



