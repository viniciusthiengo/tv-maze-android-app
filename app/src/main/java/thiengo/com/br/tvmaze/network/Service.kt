package thiengo.com.br.tvmaze.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {

    private const val HOST = "https://api.tvmaze.com/"

    val api: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api::class.java)
    }
}
