package com.carfax.usedcars.preferences

import android.content.SharedPreferences
import com.carfax.usedcars.util.USED_CARS_DATA
import javax.inject.Inject

class PreferencesImpl @Inject constructor(private val sharedPreferences: SharedPreferences) :
    IPreferences {

    override var usedCarsData: String?
        get() = sharedPreferences.getString(USED_CARS_DATA, null)
        set(value) = sharedPreferences.edit().putString(USED_CARS_DATA, value).apply()

    override fun hasUsedCarsData(): Boolean {
        return usedCarsData != null
    }

    override fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}