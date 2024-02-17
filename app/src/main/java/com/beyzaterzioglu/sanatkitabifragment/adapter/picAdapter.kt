package com.beyzaterzioglu.sanatkitabifragment.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.beyzaterzioglu.sanatkitabifragment.databinding.RecyclerRowBinding
import com.beyzaterzioglu.sanatkitabifragment.model.Pic
import com.beyzaterzioglu.sanatkitabifragment.view.DetailsFragment
import com.beyzaterzioglu.sanatkitabifragment.view.ArtListDirections


class picAdapter(val picList:List<Pic>) : RecyclerView.Adapter<picAdapter.PicHolder>(){

    class PicHolder(val recyclerRowBinding: RecyclerRowBinding):RecyclerView.ViewHolder(recyclerRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PicHolder(binding)
    }

    override fun getItemCount(): Int {
        return picList.size
    }

    override fun onBindViewHolder(holder: PicHolder, position: Int) {
        holder.recyclerRowBinding.recyclerViewTextView.text = picList[position].picName
        holder.itemView.setOnClickListener {
          val action = ArtListDirections.actionArtListToDetailsFragment("")
          Navigation.findNavController(it).navigate(action)
        }
    }


}