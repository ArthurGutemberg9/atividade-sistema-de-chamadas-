
package com.example.sistemachamados

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemachamados.databinding.ItemChamadoBinding

class ChamadoAdapter(private var lista: List<Chamado>) :
    RecyclerView.Adapter<ChamadoAdapter.ChamadoViewHolder>() {

    inner class ChamadoViewHolder(val binding: ItemChamadoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChamadoViewHolder {
        val binding = ItemChamadoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChamadoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChamadoViewHolder, position: Int) {
        val chamado = lista[position]
        holder.binding.txtTitulo.text = chamado.titulo
        holder.binding.txtDescricao.text = chamado.descricao
        holder.binding.txtStatus.text = chamado.status
    }

    override fun getItemCount(): Int = lista.size

    fun atualizarLista(novaLista: List<Chamado>) {
        lista = novaLista
        notifyDataSetChanged()
    }
}
