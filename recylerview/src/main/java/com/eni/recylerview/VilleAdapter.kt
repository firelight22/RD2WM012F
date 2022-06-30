package com.eni.recylerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VilleAdapter(val listville : ArrayList<Ville>) :
    RecyclerView.Adapter<VilleAdapter.VilleViewHolder>() {

    //Va être de le template d'un élément de liste (va être réutiliser pour afficher
    // chaque ville
    class VilleViewHolder(val itemView: View)  : RecyclerView.ViewHolder(itemView){
        val textViewNomVille : TextView = itemView.findViewById(R.id.textViewNomVille);
        val textViewPopulation: TextView = itemView.findViewById(R.id.textViewPopulation);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VilleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_ville,parent,false)
        return VilleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VilleViewHolder, position: Int) {
        var villeAAfficher = listville.get(position)
        holder.textViewNomVille.text = villeAAfficher.nom
        holder.textViewPopulation.text = villeAAfficher.population.toString()
        //holder.itemView.setOnClickListener {
        //    Toast.makeText(holder.itemView.context, villeAAfficher.nom, Toast.LENGTH_SHORT).show()
        //}
    }
    //Récupère la taille d'élément à afficher
    override fun getItemCount(): Int = listville.size


}