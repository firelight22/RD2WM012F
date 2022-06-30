package com.eni.tprecyclerviewvoiture

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eni.tprecyclerviewvoiture.databinding.ItemListVoitureBinding

class VoitureAdapter(val arrayListVoiture : ArrayList<Voiture>,val listener: OnVoitureClickListener)
    : RecyclerView.Adapter<VoitureAdapter.VoitureViewHolder>() {

    class VoitureViewHolder(val binding: ItemListVoitureBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoitureViewHolder {
        val binding = ItemListVoitureBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return VoitureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VoitureViewHolder, position: Int) {
        val voiture = arrayListVoiture[position]
        holder.binding.voiture = voiture
        holder.itemView.setOnClickListener { listener.onVoitureClick(voiture) }
    }

    override fun getItemCount(): Int = arrayListVoiture.size

    class OnVoitureClickListener(val listener: (voiture:Voiture) -> Unit){
        fun onVoitureClick(voiture:Voiture) = listener(voiture)
    }

}