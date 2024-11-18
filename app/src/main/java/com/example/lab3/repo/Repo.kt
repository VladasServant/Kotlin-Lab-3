package com.example.lab3.repo

import com.example.lab3.dao.BrandDao
import com.example.lab3.dao.ModelDao
import com.example.lab3.model.BrandData
import com.example.lab3.model.ModelData

class Repo (private val modelDao: ModelDao, private val brandDao: BrandDao) {

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