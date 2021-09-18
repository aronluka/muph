package com.android.muph.utils

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

val GSON_INSTANCE by lazy { GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()!! }

fun <T> T.toJson(): String = GSON_INSTANCE.toJson(this)

fun <T> String.fromJson(clazz: Class<T>): T = GSON_INSTANCE.fromJson(this, clazz)

fun <T> String.fromJson(typeToken: TypeToken<T>): T = GSON_INSTANCE.fromJson(this, typeToken.type)

inline fun <reified T> String.fromJson(): T? = fromJson(object : TypeToken<T>() {})