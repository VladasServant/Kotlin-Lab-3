package com.example.lab3.repo

import com.example.lab3.database.DataBase
import com.example.lab3.model.BrandData
import com.example.lab3.model.ModelData

class Repo (private val dataBase: DataBase) {

    suspend fun insertBrand(brand: BrandData) {
        dataBase.brandDao().insertBrand(brand)
    }

    suspend fun insertBrands(brands: List<BrandData>) {
        dataBase.brandDao().insertBrands(brands)
    }

    suspend fun insertModel(model: ModelData) {
        dataBase.modelDao().insertModel(model)
    }

    suspend fun insertModels(models: List<ModelData>) {
        dataBase.modelDao().insertModels(models)
    }

    suspend fun updateBrand(brand: BrandData) {
        dataBase.brandDao().updateBrand(brand)
    }

    suspend fun updateModel(model: ModelData) {
        dataBase.modelDao().updateModel(model)
    }

    suspend fun getAllBrands(): List<BrandData> {
        return dataBase.brandDao().getAllBrands()
    }

    suspend fun getAllModels(): List<ModelData> {
        return dataBase.modelDao().getAllModels()
    }

    suspend fun deleteBrand(brand: BrandData) {
        dataBase.brandDao().deleteBrand(brand)
    }

    suspend fun deleteModel(model: ModelData) {
        dataBase.modelDao().deleteModel(model)
    }

    suspend fun clearBrands() {
        dataBase.brandDao().clearBrands()
    }

    suspend fun clearModels() {
        dataBase.modelDao().clearModels()
    }
}