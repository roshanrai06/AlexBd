package com.roshan.alexbd.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Response(

    @Json(name = "Response")
    val response: List<ResponseItem?>? = null
) : Parcelable

@Parcelize
data class ResponseItem(

    @Json(name = "image")
    val image: String? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "description")
    val description: String? = null
) : Parcelable
