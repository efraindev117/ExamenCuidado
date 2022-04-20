package com.example.examencuidado.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.examencuidado.databinding.ItemsUserBinding
import com.example.examencuidado.model.data.GitResponseUserItem

class AdapterUser(
    private val userList: ArrayList<GitResponseUserItem>,
    private val listenerDetails: OnMyClick
) :
    RecyclerView.Adapter<AdapterUser.MyViewHolder>() {

    inner class MyViewHolder(val mBinding: ItemsUserBinding) :
        RecyclerView.ViewHolder(mBinding.root){

            fun setListenerDetails(git:GitResponseUserItem){
                mBinding.root.setOnClickListener {
                    listenerDetails.myClickGitDetails(git)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val mBinding = ItemsUserBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return MyViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {
            with(userList[position]) {
                setListenerDetails(userList[position])
                mBinding.tvName.text = login
                val img = avatar_url
                mBinding.ivUser.load(img)
            }
        }
    }

    override fun getItemCount() = userList.size
}