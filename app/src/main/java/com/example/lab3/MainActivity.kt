package com.example.lab3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val phoneList = listOf(
            BrandData("Apple", "1976", "is an American corporation based in Cupertino, California, that designs and develops consumer electronics, software, and online services. It is the first American company to surpass USD 1 trillion in market capitalisation. This happened during trading in the company's shares on 2 August 2018. On that day, the company also became the most valuable public company in history, surpassing the previous record holder, PetroChina. As of mid-June 2024, Apple continues to hold the title of the world's most valuable company, having displaced Microsoft from the top spot"),
            ModelData("iPhone 16", "2024"),
            ModelData("iPhone 15", "2023"),
            ModelData("iPhone 14", "2022"),
            ModelData("iPhone 13", "2021"),
            BrandData("Samsung", "1938", "is a South Korean corporation, an electronics manufacturer headquartered in Seoul. The word ‘Samsung’ (삼성) literally means ‘three stars’ in Korean."),
            ModelData("Galaxy S24", "2024"),
            ModelData("Galaxy S23", "2023"),
            ModelData("Galaxy S22", "2022"),
            ModelData("Galaxy S21", "2021"),
            BrandData("Google", "1998", "a US-based multinational corporation within the Alphabet holding company, investing in internet search, cloud computing and advertising technologies."),
            ModelData("Pixel 9 Pro", "2024"),
            ModelData("Pixel 8 Pro", "2023"),
            ModelData("Pixel 7", "2022"),
            ModelData("Pixel 6", "2021"),
            BrandData("OnePlus", "2013", "is a Chinese smartphone manufacturer. The headquarters is located in Shenzhen, Guangdong Province, China."),
            ModelData("OnePlus 12", "2024"),
            ModelData("OnePlus 11", "2023"),
            ModelData("OnePlus 10 Pro", "2022"),
            ModelData("OnePlus 9", "2021"),
            BrandData("Xiaomi", "2010", "registered in Asia as Xiaomi Inc. is a Chinese company founded by Lei Jun in 2010. It specialises in the production of electronic equipment, primarily smartphones and other ‘smart devices’. In the third quarter of 2014, Xiaomi, according to market researcher IHS iSuppli, for the first time in its history, took third place in the world in smartphone sales (after Samsung and Apple). The name, in accordance with the Ukrainian spelling, is written in pinyin characters - Xiaomi (without tone marks). The transcription of the name is Xiaomi, or Shiaomi (小米, ‘plague’)."),
            ModelData("Mi 13", "2024"),
            ModelData("Mi 12", "2022"),
            ModelData("Mi 11", "2021"),
            ModelData("Mi 10", "2020"),
            BrandData("Sony", "1946", "is a multinational corporation headquartered in Japan and the United States, founded in Japan in 1946. Today, Sony Corporation is one of the operating divisions of the Sony Group."),
            ModelData("Xperia 5 V", "2024"),
            ModelData("Xperia 5 IV", "2023"),
            ModelData("Xperia 1 III", "2022"),
            ModelData("Xperia 10 II", "2020")
        )
        val adapter = PhoneAdapter(phoneList)
        recyclerView.adapter = adapter
    }
}