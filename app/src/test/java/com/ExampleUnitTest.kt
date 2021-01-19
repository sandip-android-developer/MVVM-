package com

import com.mvvmarcheitecture1.utils.Functions
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun testIsEmailValid(){
        var testEmail="sksandipkumar588gmail.com"
        Assert.assertThat(String.format("Email Validity Test failed for %s ",testEmail),Functions.checkEmailForValidity(testEmail) ,
            `is`(true))
    }
}