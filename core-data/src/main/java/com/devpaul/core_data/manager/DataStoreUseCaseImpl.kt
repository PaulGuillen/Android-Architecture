package com.devpaul.core_data.manager

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.devpaul.core_domain.use_case.DataStoreUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.koin.core.annotation.Single

@Single
class DataStoreUseCaseImpl(private val context: Context) : DataStoreUseCase {

    private val Context.dataStore by preferencesDataStore(name = "settings")

    override fun setValue(key: String?, value: String?) {
        if (key != null && value != null) {
            val dataStoreKey = stringPreferencesKey(key)
            runBlocking {
                context.dataStore.edit { preferences ->
                    preferences[dataStoreKey] = value
                }
            }
        }
    }

    override fun setValue(key: String?, value: Int?) {
        if (key != null && value != null) {
            val dataStoreKey = intPreferencesKey(key)
            runBlocking {
                context.dataStore.edit { preferences ->
                    preferences[dataStoreKey] = value
                }
            }
        }
    }

    override fun setValue(key: String?, value: Boolean?) {
        if (key != null && value != null) {
            val dataStoreKey = booleanPreferencesKey(key)
            runBlocking {
                context.dataStore.edit { preferences ->
                    preferences[dataStoreKey] = value
                }
            }
        }
    }

    override fun setValue(key: String?, value: Float?) {
        if (key != null && value != null) {
            val dataStoreKey = floatPreferencesKey(key)
            runBlocking {
                context.dataStore.edit { preferences ->
                    preferences[dataStoreKey] = value
                }
            }
        }
    }

    override fun setValue(key: String?, value: Long?) {
        if (key != null && value != null) {
            val dataStoreKey = longPreferencesKey(key)
            runBlocking {
                context.dataStore.edit { preferences ->
                    preferences[dataStoreKey] = value
                }
            }
        }
    }

    override fun getString(key: String?): String? {
        return key?.let {
            val dataStoreKey = stringPreferencesKey(it)
            runBlocking {
                context.dataStore.data.first()[dataStoreKey] ?: ""
            }
        }
    }

    override fun getInt(key: String?): Int? {
        return key?.let {
            val dataStoreKey = intPreferencesKey(it)
            runBlocking {
                context.dataStore.data.first()[dataStoreKey] ?: 0
            }
        }
    }

    override fun getBoolean(key: String?): Boolean? {
        return key?.let {
            val dataStoreKey = booleanPreferencesKey(it)
            runBlocking {
                context.dataStore.data.first()[dataStoreKey] ?: false
            }
        }
    }

    override fun getFloat(key: String?): Float? {
        return key?.let {
            val dataStoreKey = floatPreferencesKey(it)
            runBlocking {
                context.dataStore.data.first()[dataStoreKey] ?: 0f
            }
        }
    }

    override fun getLong(key: String?): Long? {
        return key?.let {
            val dataStoreKey = longPreferencesKey(it)
            runBlocking {
                context.dataStore.data.first()[dataStoreKey] ?: 0L
            }
        }
    }

    override fun deleteAll() {
        runBlocking {
            context.dataStore.edit { preferences ->
                preferences.clear()
            }
        }
    }

    override fun getAllPreference() {
        // DataStore no proporciona un método directo para obtener todas las preferencias.
        // Si necesitas esto, puedes iterar sobre todas las claves conocidas.
    }
}
