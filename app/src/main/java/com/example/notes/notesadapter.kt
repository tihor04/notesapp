package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class notesadapter (private val context: Context,private val listner: Inotes): RecyclerView.Adapter<notesadapter.NoteViewHolder>() {


    private val allnoted=ArrayList<Note>()

    inner class NoteViewHolder( itemView : View):RecyclerView.ViewHolder(itemView) {
      val textview: TextView =itemView.findViewById(R.id.text)
        val deletebut:ImageView=itemView.findViewById(R.id.deletebutton)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
 val viewholder=NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))

        viewholder.deletebut.setOnClickListener {
            listner.onClicked(allnoted[viewholder.adapterPosition])

        }
        return viewholder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
      val currnote=allnoted[position]
        holder.textview.text=currnote.text
    }

    override fun getItemCount(): Int {
       return allnoted.size
    }
    fun updatelist(newlist:List<Note>){
        allnoted.clear()
        allnoted.addAll(newlist)

        notifyDataSetChanged()
    }
}

interface Inotes{
    fun onClicked(note:Note)
}