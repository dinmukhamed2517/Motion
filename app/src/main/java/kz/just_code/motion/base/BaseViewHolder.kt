package kz.just_code.motion.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kz.just_code.motion.model.ItemDto

abstract class BaseViewHolder<VB:ViewBinding, T>(protected open val binding:VB):
    RecyclerView.ViewHolder(binding.root){
        abstract fun bindView(item:T)
}


abstract class BaseItemViewHolder<VB:ViewBinding>(override val binding: VB):
    BaseViewHolder<VB, ItemDto>(binding)