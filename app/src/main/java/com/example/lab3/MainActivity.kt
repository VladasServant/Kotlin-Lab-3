package com.example.lab3

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.adapter.PhoneAdapter
import com.example.lab3.model.BrandData
import com.example.lab3.model.ItemInterface
import com.example.lab3.model.ModelData

class MainActivity : AppCompatActivity() {

    private val vm: MyViewModel by viewModels()
    private lateinit var adapter: PhoneAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = PhoneAdapter(emptyList(), { item ->
            if (item is BrandData) {
                showEditBrandDialog(item)
            } else if (item is ModelData) {
                showEditModelDialog(item)
            }
        }, { item ->
            showDeleteConfirmationDialog(item)
        })

        findViewById<Button>(R.id.addBrandButton).setOnClickListener {
            showAddBrandDialog()
        }

        findViewById<Button>(R.id.addModelButton).setOnClickListener {
            showAddModelDialog()
        }

        recyclerView.adapter = adapter

        vm.myList.observe(this, Observer { itemList ->
            adapter.updateItems(itemList)
        })
    }

    private fun showAddBrandDialog() {
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.brand_edit, null)
        val brandEditText = dialogView.findViewById<EditText>(R.id.editTextBrand)
        val foundedDateEditText = dialogView.findViewById<EditText>(R.id.editTextFoundedDate)
        val aboutCompanyEditText = dialogView.findViewById<EditText>(R.id.editTextAboutCompany)

        builder.setView(dialogView)
            .setPositiveButton("Add") { dialog, _ ->
                val newBrand = BrandData(
                    brand = brandEditText.text.toString(),
                    foundedDate = foundedDateEditText.text.toString(),
                    aboutCompany = aboutCompanyEditText.text.toString()
                )
                vm.addBrand(newBrand)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }

        builder.create().show()
    }

    private fun showAddModelDialog() {
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.model_edit, null)

        val idBrandEditText = dialogView.findViewById<EditText>(R.id.editTextIdBrand)
        val modelNameEditText = dialogView.findViewById<EditText>(R.id.editTextModelName)
        val releaseYearEditText = dialogView.findViewById<EditText>(R.id.editTextReleaseYear)

        builder.setView(dialogView)
            .setPositiveButton("Add") { dialog, _ ->
                val idBrand = idBrandEditText.text.toString().toIntOrNull() ?: 0
                val modelName = modelNameEditText.text.toString()
                val releaseYear = releaseYearEditText.text.toString()

                val newModel = ModelData(
                    idBrand = idBrand,
                    modelName = modelName,
                    releaseYear = releaseYear
                )
                vm.addModel(newModel)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }

        builder.create().show()
    }

    private fun showEditBrandDialog(item: BrandData) {
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.brand_edit, null)

        val brandEditText = dialogView.findViewById<EditText>(R.id.editTextBrand)
        val foundedDateEditText = dialogView.findViewById<EditText>(R.id.editTextFoundedDate)
        val aboutCompanyEditText = dialogView.findViewById<EditText>(R.id.editTextAboutCompany)

        brandEditText.setText(item.brand)
        foundedDateEditText.setText(item.foundedDate)
        aboutCompanyEditText.setText(item.aboutCompany)

        builder.setView(dialogView)
            .setPositiveButton("Save") { dialog, _ ->
                val updatedBrand = item.copy(
                    brand = brandEditText.text.toString(),
                    foundedDate = foundedDateEditText.text.toString(),
                    aboutCompany = aboutCompanyEditText.text.toString()
                )
                vm.updateBrand(updatedBrand)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }

        builder.create().show()
    }

    private fun showEditModelDialog(item: ModelData) {
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.model_edit, null)

        val modelNameEditText = dialogView.findViewById<EditText>(R.id.editTextModelName)
        val releaseYearEditText = dialogView.findViewById<EditText>(R.id.editTextReleaseYear)

        modelNameEditText.setText(item.modelName)
        releaseYearEditText.setText(item.releaseYear)

        builder.setView(dialogView)
            .setPositiveButton("Save") { dialog, _ ->
                val updatedModel = item.copy(
                    modelName = modelNameEditText.text.toString(),
                    releaseYear = releaseYearEditText.text.toString()
                )
                vm.updateModel(updatedModel)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }

        builder.create().show()
    }


    private fun showDeleteConfirmationDialog(item: ItemInterface) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to delete this item?")
            .setPositiveButton("Yes") { dialog, _ ->
                if (item is BrandData) {
                    vm.deleteBrand(item)
                } else if (item is ModelData) {
                    vm.deleteModel(item)
                }
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }

        builder.create().show()
    }
}