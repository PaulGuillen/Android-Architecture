package com.devpaul.core_domain.use_case

interface DataStoreUseCase {

    fun setValue(key: String?, value: String?)
    fun setValue(key: String?, value: Int?)
    fun setValue(key: String?, value: Boolean?)
    fun setValue(key: String?, value: Float?)
    fun setValue(key: String?, value: Long?)

    fun getString(key: String?): String?
    fun getInt(key: String?): Int?
    fun getBoolean(key: String?): Boolean?
    fun getFloat(key: String?): Float?
    fun getLong(key: String?): Long?

    fun deleteAll()

    fun getAllPreference()
}
