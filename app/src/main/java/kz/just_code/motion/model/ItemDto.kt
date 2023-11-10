package kz.just_code.motion.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ItemDto(
    val id:Int,
    val title:String,
    @DrawableRes val image:Int,
    val description:String,
):Parcelable
