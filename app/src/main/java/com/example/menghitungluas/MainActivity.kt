package com.example.menghitungluas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var  recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: LinearLayoutManager

    private var hitungluas : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val panjang = findViewById<EditText>(R.id.etPanjang)
        val lebar = findViewById<EditText>(R.id.etLebar)
        //var hasil = findViewById<TextView>(R.id.hasilactivity)
        val hitung = findViewById<Button>(R.id.button)

        val data = ArrayList<data>()
        recyclerView = findViewById(R.id.listdata)

        hitung.setOnClickListener {

            val panjang = panjang.text.toString().toInt()
            val lebar = lebar.text.toString().toInt()

            if (panjang != null) {
                hitungluas = panjang * lebar
                hitungluas.toString()

                val menampilkan = data(hitungluas)
                data.add(menampilkan)
                recyclerAdapter.notifyDataSetChanged()

            } else if (lebar != null) {
                hitungluas = (panjang * 2) + (lebar * 2)
                hitungluas.toString()

                val menampilkan = data(hitungluas)
                data.add(menampilkan)
                recyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "DI ISI TERLEBIH DAHULU", Toast.LENGTH_SHORT).show()
            }
        }
        recyclerAdapter = Adapter(data)
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager
    }
}
