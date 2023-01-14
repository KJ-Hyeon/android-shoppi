package com.jeong.android.android_shoppi.ui.common

import androidx.lifecycle.Observer
import java.util.*

// 데이터가 한번 소비되면 더이상 사용되지않도록 처리하는 클래스
class Event<T>(private val content : T) {

    //데이터가 소비되었는지 여부를 저장할 Boolean형 변수
    private var hasBeenHandled = false

    fun getContentIfNotHandled() : T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}

class EventObserver<T>(private val onEventUnhandledContent : ((T) ->Unit)) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let {
            onEventUnhandledContent(it)
        }
    }

}