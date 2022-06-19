package com.example.rentcarsby.repository

import com.example.rentcarsby.data_base.entity.CarEntity

interface CarRepo {

    fun getCarList() : List<CarEntity>
    fun getCar(id: Int): CarEntity
    fun setCar(carEntity: CarEntity)
}