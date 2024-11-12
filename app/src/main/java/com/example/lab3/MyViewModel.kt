package com.example.lab3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.lab3.database.DataBase
import com.example.lab3.model.BrandData
import com.example.lab3.model.ItemInterface
import com.example.lab3.model.ModelData
import com.example.lab3.repo.Repo
import kotlinx.coroutines.launch

class MyViewModel (application: Application) : AndroidViewModel(application) {

    private val dataBase = Room.databaseBuilder(
        application,
        DataBase::class.java, "database"
    )
        .build()

    private val repo = Repo(dataBase)

    private var _myList: MutableLiveData<List<ItemInterface>> =
        MutableLiveData<List<ItemInterface>>().apply {
            value = emptyList()
        }
    val myList: LiveData<List<ItemInterface>> = _myList

    init {
        viewModelScope.launch {

//            repo.clearBrands()
//            repo.clearModels()

            val brands = listOf(
                BrandData(brand = "Apple",  foundedDate = "1976", aboutCompany = "is an American corporation based in Cupertino, California, that designs and develops consumer electronics, software, and online services. It is the first American company to surpass USD 1 trillion in market capitalisation. This happened during trading in the company's shares on 2 August 2018. On that day, the company also became the most valuable public company in history, surpassing the previous record holder, PetroChina. As of mid-June 2024, Apple continues to hold the title of the world's most valuable company, having displaced Microsoft from the top spot"),
                BrandData(brand = "Samsung", foundedDate = "1938", aboutCompany = "is a South Korean corporation, an electronics manufacturer headquartered in Seoul. The word ‘Samsung’ (삼성) literally means ‘three stars’ in Korean."),
                BrandData(brand = "Google", foundedDate = "1998", aboutCompany = "a US-based multinational corporation within the Alphabet holding company, investing in internet search, cloud computing and advertising technologies."),
                BrandData(brand = "OnePlus", foundedDate = "2013", aboutCompany = "is a Chinese smartphone manufacturer. The headquarters is located in Shenzhen, Guangdong Province, China."),
                BrandData(brand = "Xiaomi", foundedDate = "2010", aboutCompany = "registered in Asia as Xiaomi Inc. is a Chinese company founded by Lei Jun in 2010. It specialises in the production of electronic equipment, primarily smartphones and other ‘smart devices’. In the third quarter of 2014, Xiaomi, according to market researcher IHS iSuppli, for the first time in its history, took third place in the world in smartphone sales (after Samsung and Apple). The name, in accordance with the Ukrainian spelling, is written in pinyin characters - Xiaomi (without tone marks). The transcription of the name is Xiaomi, or Shiaomi (小米, ‘plague’)."),
                BrandData(brand = "Sony", foundedDate = "1946", aboutCompany = "is a multinational corporation headquartered in Japan and the United States, founded in Japan in 1946. Today, Sony Corporation is one of the operating divisions of the Sony Group.")
            )

//                 repo.insertBrands(brands)

            val models = listOf(
                ModelData(idBrand = 1, modelName = "iPhone 16", releaseYear = "2024"),
                ModelData(idBrand = 1, modelName = "iPhone 15", releaseYear = "2023"),
                ModelData(idBrand = 1, modelName = "iPhone 14", releaseYear = "2022"),
                ModelData(idBrand = 1, modelName = "iPhone 13", releaseYear = "2021"),
                ModelData(idBrand = 2, modelName = "Galaxy S24", releaseYear = "2024"),
                ModelData(idBrand = 2, modelName = "Galaxy S23", releaseYear = "2023"),
                ModelData(idBrand = 2, modelName = "Galaxy S22", releaseYear = "2022"),
                ModelData(idBrand = 2, modelName = "Galaxy S21", releaseYear = "2021"),
                ModelData(idBrand = 3, modelName = "Pixel 9 Pro", releaseYear = "2024"),
                ModelData(idBrand = 3, modelName = "Pixel 8 Pro", releaseYear = "2023"),
                ModelData(idBrand = 3, modelName = "Pixel 7", releaseYear = "2022"),
                ModelData(idBrand = 3, modelName = "Pixel 6", releaseYear = "2021"),
                ModelData(idBrand = 4, modelName = "OnePlus 12", releaseYear = "2024"),
                ModelData(idBrand = 4, modelName = "OnePlus 11", releaseYear = "2023"),
                ModelData(idBrand = 4, modelName = "OnePlus 10 Pro", releaseYear = "2022"),
                ModelData(idBrand = 4, modelName = "OnePlus 9", releaseYear = "2021"),
                ModelData(idBrand = 5, modelName = "Mi 13", releaseYear = "2024"),
                ModelData(idBrand = 5, modelName = "Mi 12", releaseYear = "2022"),
                ModelData(idBrand = 5, modelName = "Mi 11", releaseYear = "2021"),
                ModelData(idBrand = 5, modelName = "Mi 10", releaseYear = "2020"),
                ModelData(idBrand = 6, modelName = "Xperia 5 V", releaseYear = "2024"),
                ModelData(idBrand = 6, modelName = "Xperia 5 IV", releaseYear = "2023"),
                ModelData(idBrand = 6, modelName = "Xperia 1 III", releaseYear = "2022"),
                ModelData(idBrand = 6, modelName = "Xperia 10 II", releaseYear = "2020")
            )

//                 repo.insertModels(models)

            loadItems()
        }
    }

    private fun loadItems() {
        viewModelScope.launch {
            val brands = repo.getAllBrands()
            val models = repo.getAllModels()

            val combinedList = mutableListOf<ItemInterface>()
            brands.forEach { brand ->
                combinedList.add(brand)
                combinedList.addAll(models.filter { it.idBrand == brand.id })
            }

            _myList.postValue(combinedList)
        }
    }

    fun addBrand(brand: BrandData) {
        viewModelScope.launch {
            repo.insertBrand(brand)
            loadItems()
        }
    }

    fun addModel(model: ModelData) {
        viewModelScope.launch {
            repo.insertModel(model)
            loadItems()
        }
    }

    fun updateBrand(brand: BrandData) {
        viewModelScope.launch {
            repo.updateBrand(brand)
            loadItems()
        }
    }

    fun updateModel(model: ModelData) {
        viewModelScope.launch {
            repo.updateModel(model)
            loadItems()
        }
    }

    fun deleteBrand(brand: BrandData) {
        viewModelScope.launch {
            repo.deleteBrand(brand)
            loadItems()
        }
    }

    fun deleteModel(model: ModelData) {
        viewModelScope.launch {
            repo.deleteModel(model)
            loadItems()
        }
    }
}