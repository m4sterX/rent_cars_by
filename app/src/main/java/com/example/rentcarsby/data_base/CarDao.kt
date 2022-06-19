package com.example.rentcarsby.data_base

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.rentcarsby.data_base.entity.CarEntity

@Dao
interface CarDao {


    @Insert
    fun insertCar(car: CarEntity)

    @Delete
    fun deleteCar(car: CarEntity)

    @Query("Select * From car_table")
    fun selectAllCars(): List<CarEntity>

    @Query("Select * From car_table Where id is :mId")
    fun getCar(mId: Int): CarEntity


}
//    @Query("Select * From car_table Where carParkId is carParkId")
//    fun selectAllCars(carParkId: Int): List<Car>
//
//    @Query("Select * From car_table Where id is id")
//    fun getCar(id: Int): Car
