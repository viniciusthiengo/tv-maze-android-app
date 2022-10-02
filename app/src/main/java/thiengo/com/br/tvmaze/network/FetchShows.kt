package thiengo.com.br.tvmaze.network

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import thiengo.com.br.tvmaze.R
import thiengo.com.br.tvmaze.model.Show

class FetchShows private constructor(
    activity: AppCompatActivity,
    private var onLoadingCallback: (() -> Unit)? = null,
    private var onSuccessCallback: ((List<Show?>) -> Unit)? = null,
    private var onFailureCallback: ((Throwable?) -> Unit)? = null
) : Fetch(activity) {

    fun search(query: String) {
        processOnMainThread {
            onLoadingCallback?.let { it() }
        }

        scope.launch(Dispatchers.IO) {
            try {
                val shows = Service
                    .api
                    .search(query)
                    ?.filter { it.show != null }
                    ?.map { it.show }

                if (shows != null) {
                    processOnMainThread {
                        onSuccessCallback?.let { it(shows) }
                    }
                } else {
                    processOnMainThread {
                        onFailureCallback?.let { it(null) }
                    }
                }

            } catch (t: Throwable) {
                processOnMainThread {
                    onFailureCallback?.let { it(t) }
                }
            }
        }
    }

    class Builder(activity: AppCompatActivity) : Fetch.Builder<FetchShows>(activity) {

        override val fetcher = FetchShows(activity)

        fun setOnLoadingCallback(callback: () -> Unit): Builder {
            fetcher.onLoadingCallback = callback
            return this
        }

        fun setOnSuccessCallback(callback: (List<Show?>) -> Unit): Builder {
            fetcher.onSuccessCallback = callback
            return this
        }

        fun setOnFailureCallback(callback: (Throwable?) -> Unit): Builder {
            fetcher.onFailureCallback = callback
            return this
        }

        override fun build(): FetchShows {
            when {
                fetcher.onLoadingCallback == null ->
                    throwException(R.string.search_shows_on_loading_exception_message)
                fetcher.onSuccessCallback == null ->
                    throwException(R.string.search_shows_on_success_exception_message)
                fetcher.onFailureCallback == null ->
                    throwException(R.string.search_shows_on_failure_exception_message)
            }

            return fetcher
        }
    }
}