package com.example.galeritutorial.network.helper

import androidx.annotation.MainThread
import com.example.galeritutorial.network.INetworkResponseHandling
import java.lang.Exception

abstract class RequestHelper<T> {

    /**
     * @param[isNeedProgressBar] : ProgressBar'ın gösterilip gösterilmeyeceği kontrolü
     *
     * @param[INetworkResponseHandling] : Generic network response'ları handle etmek için eklenen bir interface. BaseViewModel'da bulunuyor.
     * ViewModel'ınızı BaseViewModel'dan türettiyseniz 'this' demeniz yeterli.
     */
    suspend fun loadRequest(
        iNetworkResponseHandling: INetworkResponseHandling,
        isNeedProgressBar: Boolean
    ): DataHolder<T>? {
        if (isNeedProgressBar) iNetworkResponseHandling.loading(true)
        return try {
            val response = createNetworkRequest()
            if (isNeedProgressBar) iNetworkResponseHandling.loading(false)
            DataHolder.Success(response)
        } catch (e: Exception) {
            iNetworkResponseHandling.onErrorPopUp("Error", "An error occurred on network layer")
            DataHolder.Error("An error occurred on network layer")
        }
    }

    @MainThread
    protected abstract suspend fun createNetworkRequest(): T
}