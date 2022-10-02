package thiengo.com.br.tvmaze.network

import retrofit2.http.GET
import retrofit2.http.Query
import thiengo.com.br.tvmaze.model.ShowResponse

/**
 * Retrofit API interface definition using coroutines. Feel
 * free to change this implementation to suit your chosen
 * architecture pattern and concurrency tools.
 */
interface Api {

    @GET("search/shows?q=girls")
    suspend fun search(
        @Query("q") query: String
    ): List<ShowResponse>?

    /*@GET("login")
    suspend fun login(@Header("Authorization") credentials: String?): Account

    @GET("users")
    suspend fun fetchUsers(
        @Header("Authorization") apiKey: String,
        @Header("x-access-token") token: String
    ): List<User>?

    /**
     * Without the userId parameter (or just not sending a
     * valid value to this parameter), this API returns all
     * posts.
     */
    @GET("posts")
    suspend fun fetchPosts(
        @Header("Authorization") apiKey: String,
        @Header("x-access-token") token: String
        //@Header("userId") userId: Int?
    ): List<Post>?*/
}

/**
 * Overloaded Login API extension function to handle
 * authorization header encoding.
 */
/*suspend fun Api.login(username: String, password: String) = login(
    "Basic " + android.util.Base64.encodeToString(
        "$username:$password".toByteArray(),
        android.util.Base64.NO_WRAP
    )
)*/