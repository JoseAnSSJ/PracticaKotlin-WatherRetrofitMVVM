package com.example.wather.mainModule.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wather.databinding.ItemWBinding
import com.example.wather.databinding.ItemWBindingImpl

class ForCastAdapter  {

    inner class viewHolder(view: View): RecyclerView.ViewHolder(view){
        val mBinding = DataBindingUtil.bind<ItemWBinding>(view)

        fun setListener(forCast: )
    }

}