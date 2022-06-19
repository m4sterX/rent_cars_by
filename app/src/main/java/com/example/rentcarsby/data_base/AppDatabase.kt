package com.example.rentcarsby.data_base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.rentcarsby.R
import com.example.rentcarsby.data_base.entity.CarEntity
import com.example.rentcarsby.subscribeOnBackground

@Database(entities = [CarEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context) : AppDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, AppDatabase::class.java,
                "car_database")
                    .addCallback(roomCallback)
                    .build()

            return instance!!
        }
        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(instance!!)
            }
        }

        private fun populateDatabase(db: AppDatabase) {
            val carDao = db.carDao()
            subscribeOnBackground {
                carDao.insertCar(CarEntity(0, "Toyota Mark II",R.drawable.mark2, "марк", 100.0))
                carDao.insertCar(CarEntity(1, "Nissan 200SX S15", R.drawable.sx1, "description about 200sx", 120.0))
                carDao.insertCar(CarEntity(2, "Mazda RX7 VeilSide Fortune", R.drawable.rx7_1, "ОПИСАНИЕ", 130.0))
                carDao.insertCar(CarEntity(3, "Nissan Skyline R33", R.drawable.sx1, "описание", 140.0))
                carDao.insertCar(CarEntity(4, "Honda S2000", R.drawable.sx2, "описание", 150.0))

            }
        }
    }
}