package com.example.planetapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.planetapp.databinding.ViewBinding



class Adapter(private val planet: List<PlanetData>): RecyclerView.Adapter<Adapter.myViewHolder>()
{

    class myViewHolder(private val binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(planet: PlanetData) {
            binding.title.text = planet.title
            binding.galaxy.text = planet.galaxy
            binding.gravity.text = "${planet.gravity} m/ss"
            binding.distance.text = "${planet.distance} m km"


            val dummyImageResource = when (planet.title?.toLowerCase()) {
                "mars" -> R.drawable.mars
                "neptune" -> R.drawable.neptune
                "earth" -> R.drawable.earth
                "moon" -> R.drawable.moon
                "venus" -> R.drawable.venus
                "saturn" -> R.drawable.saturn
                "sun" -> R.drawable.sun
                "jupiter" -> R.drawable.jupiter
                "uranus" -> R.drawable.uranus
                "mercury" -> R.drawable.mercury
                else -> null
            }
            dummyImageResource?.let { binding.earthImg.setImageResource(it) }

            binding.root.setOnClickListener{
                val intent=Intent(binding.root.context,Info_activity::class.java)
                intent.putExtra("data",planet)
                intent.putExtra("planetImage",dummyImageResource)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        val binding = ViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return myViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return planet.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(planet[position])



       /* holder.itemView.setOnClickListener{
            val intent=Intent(holder.itemView.context,Info_activity::class.java)
            intent.putExtra("data",planet[position])
            intent.putExtra("planetImage",dummyImage)
            holder.itemView.context.startActivity(intent)
        }*/

    }
}

