package com.example.simplecachingexample.utils

import android.util.Log
import com.example.monitoringanetworkconnectioninrealtimewithlivedata.TAG
import kotlinx.coroutines.flow.*


//inline fun <Input, Output> networkBoundResource(
//    crossinline query: () -> Flow<Input>,
//    crossinline fetch: suspend () -> Output,
//    crossinline saveFetchResult: suspend (Output) -> Unit,
//    crossinline shouldFetch: (Input) -> Boolean = { true }
//) = flow {
//    val data = query().first()
//
////    val flow = if (shouldFetch(data)) {
////        emit(Resource.Loading(data))
////        try {
////            Log.i(TAG, "networkBoundResource: ")
////            saveFetchResult(fetch())
////            query().map { Resource.Success(it) }
////        } catch (throwable: Throwable) {
////            query().map { Resource.Error(throwable, it) }
////        }
////    } else {
////        query().map { Resource.Success(it) }
////    }
////
////    emitAll(flow)
//}