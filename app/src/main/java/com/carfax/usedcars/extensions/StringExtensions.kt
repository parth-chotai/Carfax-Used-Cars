package com.carfax.usedcars.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri

fun String.callDealer(context: Context) {
    val callIntent = Intent(Intent.ACTION_CALL)
    callIntent.data = Uri.parse("tel:$this")
    context.startActivity(callIntent)
}