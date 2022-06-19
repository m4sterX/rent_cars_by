package com.example.rentcarsby.data_base.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "car_table")
data class CarEntity(
    @PrimaryKey val id: Int,

    @ColumnInfo val name: String,

    @ColumnInfo val previewImage: Int,

    @ColumnInfo val description: String,

    @ColumnInfo val price: Double,

    ) : Parcelable

