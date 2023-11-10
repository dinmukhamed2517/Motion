package kz.just_code.motion

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.parcel.Parcelize
import kz.just_code.motion.base.BaseItemViewHolder
import kz.just_code.motion.databinding.RecyclerItemBinding
import kz.just_code.motion.model.ItemDto

class Adapter: ListAdapter<ItemDto, BaseItemViewHolder<*>>(ItemDiffUtils()){

    var itemClick: ((ItemDto, Map<View, String>)->Unit)? = null
    class ItemDiffUtils:DiffUtil.ItemCallback<ItemDto>(){
        override fun areItemsTheSame(oldItem: ItemDto, newItem: ItemDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemDto, newItem: ItemDto): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseItemViewHolder<*> {
        return ItemViewHolder(
            RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseItemViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }
    inner class ItemViewHolder(binding:RecyclerItemBinding):BaseItemViewHolder<RecyclerItemBinding>(binding){
        override fun bindView(item: ItemDto) {
            with(binding){
                title.text = item.title
                image.setImageResource(item.image)
                title.transitionName = "title_${item.id}"
                container.transitionName = "container_${item.id}"
                image.transitionName = "image${item.id}"

            }
            itemView.setOnClickListener {
                // Invoke the itemClick listener with shared element names
                itemClick?.invoke(item, mapOf(
                    binding.title to "title_${item.id}",
                    binding.image to "image_${item.id}",
                    binding.container to "container_${item.id}"
                ))
            }
        }

    }

}

