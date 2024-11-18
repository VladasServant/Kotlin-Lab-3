package com.example.lab3.api

import com.example.lab3.model.BrandData
import com.example.lab3.model.ModelData
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("brands")
    suspend fun getBrands(): Response<List<BrandData>>

    @GET("models")
    suspend fun  getModels(): Response<List<ModelData>>
}