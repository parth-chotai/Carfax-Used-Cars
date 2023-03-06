package com.carfax.usedcars.preferences

interface IPreferences {

    var usedCarsData: String?

    fun hasUsedCarsData(): Boolean

    fun clear()
}