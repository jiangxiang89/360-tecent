package com.px_esport.product.adapter

import android.util.Log
import com.tencent.kuikly.core.render.android.adapter.IKRUncaughtExceptionHandlerAdapter
import com.px_esport.product.BuildConfig

object KRUncaughtExceptionHandlerAdapter : IKRUncaughtExceptionHandlerAdapter {

    private const val TAG = "KRExceptionHandler"

    override fun uncaughtException(throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            throw throwable
        } else {
            Log.e(TAG, "KR error: ${throwable.stackTraceToString()}")
        }
    }

}