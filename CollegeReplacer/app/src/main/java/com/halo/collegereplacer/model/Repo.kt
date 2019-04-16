package com.halo.collegereplacer.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by James on 2019/3/16.
 * Desc:
 */
@Entity(tableName = "repo")
data class Repo(
    @PrimaryKey val id: Long,
    val name: String,
    @SerializedName("full_name") val fullName: String,
    val description: String?,
    val url: String,
    val stars: Int,
    val forks: Int,
    val language: String?
)