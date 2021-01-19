package com.mvvmarcheitecture1.utils

import android.content.Context

open class SettingsManager(context: Context) {
    /*private val dataStore = context.createDataStore(name = "settings_pref")

    companion object {
        var IS_USER = preferencesSetKey<User>("is_user")
    }

    suspend fun setUSer(user: User) {
        dataStore.edit { preferences ->
            preferences.set(IS_USER, setOf(user)
            )
        }
    }

    val uiModeFlow: Flow<Set<User>?>
        get() = dataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }
            .map { preference ->
                preference[IS_USER]
            }*/
}