package com.example.planetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.planetapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val planetDataList = SetData.SetPlanets()
        val adapter=Adapter(planetDataList)
    binding.myRecycler.adapter= adapter
        binding.myRecycler.layoutManager=LinearLayoutManager(this)


    }



}