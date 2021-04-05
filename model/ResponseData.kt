package com.example.retrofitapplication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ResponseData(

	@field:SerializedName("createdby")
	val createdby: String? = null,

	@field:SerializedName("firstappearance")
	val firstappearance: String? = null,

	@field:SerializedName("imageurl")
	val imageurl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("publisher")
	val publisher: String? = null,

	@field:SerializedName("bio")
	val bio: String? = null,

	@field:SerializedName("team")
	val team: String? = null,

	@field:SerializedName("realname")
	val realname: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(createdby)
		parcel.writeString(firstappearance)
		parcel.writeString(imageurl)
		parcel.writeString(name)
		parcel.writeString(publisher)
		parcel.writeString(bio)
		parcel.writeString(team)
		parcel.writeString(realname)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ResponseData> {
		override fun createFromParcel(parcel: Parcel): ResponseData {
			return ResponseData(parcel)
		}

		override fun newArray(size: Int): Array<ResponseData?> {
			return arrayOfNulls(size)
		}
	}
}

annotation class Parcelize
