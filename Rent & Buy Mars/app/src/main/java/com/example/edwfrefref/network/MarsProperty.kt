package com.example.edwfrefref.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MarsProperty (

        val price:Double,
        val id:String,
        val type:String,
        @Json(name = "img_src")
        val imgSrc:String):Parcelable {

        val isRental
                get() = type=="rent"

}