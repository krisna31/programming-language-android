package com.example.programminglanguage

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val KEY_LANG = "KEY_LANG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName: TextView = findViewById(R.id.tvJudul)
        val tvDetailDescription: TextView = findViewById(R.id.tvDeskripsi)
        val ivDetailPhoto: ImageView = findViewById(R.id.ivGambar)
        val tvTahunRilis: TextView = findViewById(R.id.tvDibuatTahun)
        val tvPembuat: TextView = findViewById(R.id.tvPembuat)

        val dataLang = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Lang>(KEY_LANG, Lang::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Lang>(KEY_LANG)
        }

        if (dataLang != null) {
            tvDetailName.text = dataLang.name
            tvDetailDescription.text = dataLang.description
            ivDetailPhoto.setImageResource(dataLang.photo)
            tvTahunRilis.text = String.format("Dibuat Tahun %s", dataLang.year)
            tvPembuat.text = String.format("Pembuat: %s", dataLang.creator)
        }
    }
}