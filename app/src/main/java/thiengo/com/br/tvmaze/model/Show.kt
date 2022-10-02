package thiengo.com.br.tvmaze.model

import com.google.gson.annotations.SerializedName

class Show(
    @SerializedName("id") val id: Long? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("language") val language: String? = null
)