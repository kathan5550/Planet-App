package com.example.planetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.planetapp.databinding.ActivityInfoBinding

class Info_activity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding
    private lateinit var obj:PlanetData
    private var planetimage:Int?=null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        obj=intent.getParcelableExtra("data")!!
        planetimage=intent.getIntExtra("planetImage",-1)
        setdata(obj,planetimage!!)

        binding.buttonInfo.setOnClickListener{
            val intent =Intent(this,FinalActivity::class.java)
            startActivity(intent)
        }

    }
    private fun setdata(obj:PlanetData,planetimage:Int)
    {
            binding.titleInfo.text=obj.title
            binding.galaxyInfo.text=obj.galaxy
            binding.distanceInfo.text=obj.distance+"m km"
            binding.gravityInfo.text=obj.gravity+"m/ss"
            binding.overviewInfo.text=obj.overview
            binding.EarthInfo.setImageResource(planetimage)
    }
}