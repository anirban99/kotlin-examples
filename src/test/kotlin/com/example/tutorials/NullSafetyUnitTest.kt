package com.example.tutorials

import com.example.tutorials.nullsafety.NullSafety
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class NullSafetyUnitTest {

    private val classUnderTest: NullSafety = NullSafety()

    @Test
    fun givenNonNullableString_whenNullCheckIsDone_thenReturnsLength() {
        assertEquals(5, classUnderTest.nullCheckForValue())
    }

    @Test
    fun givenNullString_whenNullCheckIsDone_thenReturnsNull() {
        assertNull(classUnderTest.nullCheck())
    }

    @Test
    fun givenNonNullableString_whenSafeCallIsDone_thenReturnsLength() {
        assertEquals(5, classUnderTest.safeCallForValue())
    }

    @Test
    fun givenNullString_whenSafeCallIsDone_thenReturnsNull() {
        assertNull(classUnderTest.safeCall())
    }

    @Test
    fun givenNonNullableString_whenSafeCallChainIsDone_thenReturnsCityCode() {
        assertEquals("003", classUnderTest.safeCallChainForValue())
    }

    @Test
    fun givenNullableString_whenSafeCallChainIsDone_thenReturnsNull() {
        assertEquals("003", classUnderTest.safeCallChainForValue())
        assertNull(classUnderTest.safeCallChain())
    }
}