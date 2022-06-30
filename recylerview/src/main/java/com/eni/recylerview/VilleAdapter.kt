package com.eni.recylerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eni.recylerview.databinding.ItemListVilleBinding

class VilleAdapter(val listville : ArrayList<Ville>) :
    RecyclerView.Adapter<VilleAdapter.VilleViewHolder>() {

    //Va être de le template d'un élément de liste (va être réutiliser pour afficher
    // chaque ville
    class VilleViewHolder(val binding: ItemListVilleBinding)  : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VilleViewHolder {
        //val itemView = LayoutInflater.from(parent.context)
        //    .inflate(R.layout.item_list_ville,parent,false)
        var binding = ItemListVilleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VilleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VilleViewHolder, position: Int) {
        holder.binding.ville = listville.get(position)
        holder.itemView.setOnClickListener {
            Log.i("VilleAdapter", "onBindViewHolder: " + "element clické")
        }
        //holder.itemView.setOnClickListener {
        //    Toast.makeText(holder.itemView.context, villeAAfficher.nom, Toast.LENGTH_SHORT).show()
        //}
    }
    //Récupère la taille d'élément à afficher
    override fun getItemCount(): Int = listville.size


}