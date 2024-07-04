package com.workdev.example.ui.main.utils.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.workdev.domain.entity.PostResponseItem
import com.workdev.example.databinding.ItemPostBinding


class AdapterPosts(): RecyclerView.Adapter<AdapterPosts.ViewHolder>() {
    lateinit var  binding:ItemPostBinding




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      binding= ItemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.userId.text= "user id  : "+differ.currentList[position].userId.toString()
        holder.binding.id.text="id : "+differ.currentList[position].id.toString()
        holder.binding.title.text="Title : "+differ.currentList[position].title
        holder.binding.body.text="Body : "+differ.currentList[position].body



    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(var binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)


    private val differCallback = object : DiffUtil.ItemCallback<PostResponseItem>(){
        override fun areItemsTheSame(oldItem:PostResponseItem , newItem:PostResponseItem ): Boolean {
            return  oldItem.id == newItem.id
        }


        override fun areContentsTheSame(oldItem:PostResponseItem , newItem:PostResponseItem ): Boolean {

            return oldItem == newItem

        }

    }
   val differ = AsyncListDiffer(this,differCallback)








}