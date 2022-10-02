package thiengo.com.br.tvmaze.network

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class Fetch(activity: AppCompatActivity) {

    protected val scope = activity.lifecycleScope

    protected fun processOnMainThread(callback: () -> Unit) {
        scope.launch(Dispatchers.Main) {
            callback()
        }
    }

    abstract class Builder<T>(private val activity: AppCompatActivity) {

        protected abstract val fetcher: T

        abstract fun build(): T

        protected fun throwException(message: Int) {
            throw NullPointerException(activity.getString(message))
        }
    }
}