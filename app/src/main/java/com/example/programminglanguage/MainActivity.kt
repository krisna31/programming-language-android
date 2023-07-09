package com.example.programminglanguage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rvLang: RecyclerView
    private val list = ArrayList<Lang>()
    private lateinit var fabProfile: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabProfile = findViewById(R.id.fabProfile)
        fabProfile.setOnClickListener {
            val intentProfile = Intent(this, ProfileActivity::class.java)
            startActivity(intentProfile)
        }

        rvLang = findViewById(R.id.rv_lang)
        rvLang.setHasFixedSize(true)

        list.addAll(getListLangs())
        showRecyclerList()
    }

    private fun showSelectedLang(hero: Lang) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }

    private fun getListLangs(): ArrayList<Lang> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listLang = ArrayList<Lang>()
        for (i in dataName.indices) {
            val hero = Lang(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listLang.add(hero)
        }
        return listLang
    }

    private fun showRecyclerList() {
        rvLang.layoutManager = LinearLayoutManager(this)
        val listLangAdapter = ListLangAdapter(list)
        rvLang.adapter = listLangAdapter

        listLangAdapter.setOnItemClickCallback(object : ListLangAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Lang) {
                showSelectedLang(data)
            }
        })
    }
}