package com.mvvmarcheitecture1.utils

import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

object Functions {

    private val MILLIS = 1000

   open fun checkEmailForValidity(email: String?): Boolean {
        val matcher: Matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email)
        return matcher.find()
    }

    private val VALID_EMAIL_ADDRESS_REGEX: Pattern =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)


  open  fun calendarDate(epocSeconds: Long): Date? {
        val c: Calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        c.setTimeInMillis(epocSeconds * MILLIS)
        return c.getTime()
    }
}