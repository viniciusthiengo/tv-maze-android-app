package thiengo.com.br.tvmaze

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import thiengo.com.br.tvmaze.network.FetchShows

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        FetchShows
            .Builder(this)
            .setOnLoadingCallback {
                Log.d("thiengo", "OnLoadingCallback")
            }
            .setOnSuccessCallback {
                Log.d("thiengo", "OnSuccessCallback")

                it.forEach {
                    Log.d("thiengo", "Show name: ${it?.name}")
                }
            }
            .setOnFailureCallback {
                Log.d("thiengo", "OnFailureCallback")
            }
            .build()
            .search(query = "girls")

    }
}