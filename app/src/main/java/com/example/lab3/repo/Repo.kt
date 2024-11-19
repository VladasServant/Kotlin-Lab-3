package com.example.lab3.repo

import com.example.lab3.api.Api
import com.example.lab3.api.RetrofitClient
import com.example.lab3.dao.BrandDao
import com.example.lab3.dao.ModelDao
import com.example.lab3.model.BrandData
import com.example.lab3.model.ModelData

class Repo (private val brandDao: BrandDao, private val modelDao: ModelDao) {

    private val appRetrofitClient = RetrofitClient.getClient()
    private val appApi = appRetrofitClient.create(Api::class.java)

    suspend fun loadBrands(): List<BrandData>? {
        val response = appApi.getBrands()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

    suspend fun loadModels(): List<ModelData>? {
        val response = appApi.getModels()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

    suspend fun insertBrand(brand: BrandData) {
        brandDao.insertBrand(brand)
    }

    suspend fun insertBrands(brands: List<BrandData>) {
        brandDao.insertBrands(brands)
    }

    suspend fun insertModel(model: ModelData) {
        modelDao.insertModel(model)
    }

    suspend fun insertModels(models: List<ModelData>) {
        modelDao.insertModels(models)
    }

    suspend fun updateBrand(brand: BrandData) {
        brandDao.updateBrand(brand)
    }

    suspend fun updateModel(model: ModelData) {
        modelDao.updateModel(model)
    }

    suspend fun getAllBrands(): List<BrandData> {
        return brandDao.getAllBrands()
    }

    suspend fun getAllModels(): List<ModelData> {
        return modelDao.getAllModels()
    }

    suspend fun deleteBrand(brand: BrandData) {
        brandDao.deleteBrand(brand)
    }

    suspend fun deleteModel(model: ModelData) {
        modelDao.deleteModel(model)
    }

    suspend fun clearBrands() {
        brandDao.clearBrands()
    }

    suspend fun clearModels() {
        modelDao.clearModels()
    }
}