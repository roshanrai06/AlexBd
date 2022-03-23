package com.roshan.alexbd.data

import retrofit2.http.GET

interface APIService {
    @GET("v1/99066355-8f5e-4c9d-b400-d5bdf26911b6")
    suspend fun getBirthdayList(): Response
}