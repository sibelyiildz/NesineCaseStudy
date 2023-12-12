package com.example.nesinecasestudy.data.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "post_entity")
data class PostEntity(
    @PrimaryKey(autoGenerate = false)
    var id: Int
) : Parcelable