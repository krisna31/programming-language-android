package com.example.programminglanguage

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Lang(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
