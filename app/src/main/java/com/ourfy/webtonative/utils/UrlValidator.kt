package com.ourfy.webtonative.utils

import android.util.Patterns

object UrlValidator {

    fun validate(input: String): String? {
        val trimmed = input.trim()
        if (trimmed.isEmpty()) return null

        val finalUrl =
            if (trimmed.startsWith("http://") || trimmed.startsWith("https://"))
                trimmed
            else
                "https://$trimmed"

        return if (Patterns.WEB_URL.matcher(finalUrl).matches())
            finalUrl
        else null
    }
}
