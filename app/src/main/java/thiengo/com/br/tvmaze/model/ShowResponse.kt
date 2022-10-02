package thiengo.com.br.tvmaze.model

import com.google.gson.annotations.SerializedName

class ShowResponse(
    @SerializedName("score") val score: Double? = null,
    @SerializedName("show") val show: Show? = null
)