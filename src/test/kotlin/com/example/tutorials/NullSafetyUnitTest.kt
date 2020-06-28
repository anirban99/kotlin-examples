package com.example.tutorials

import com.example.tutorials.nullsafety.NullSafety
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun givenList_whenSafeCallWithLet_thenReturnsOnlyNonNullableElements() {
        assertEquals(2, classUnderTest.safeCallWithLet().size)
        assertEquals("Kolkata", classUnderTest.safeCallWithLet()[0])
    }

    @Test
    fun givenList_whenSafeCallWithLetAndAlso_thenReturnsOnlyNonNullableElements() {
        assertEquals(2, classUnderTest.safeCallWithAlso().size)
    }

    @Test
    fun givenList_whenSafeCallWitRun_thenReturnsOnlyNonNullableElements() {
        assertEquals(2, classUnderTest.safeCallWithRun().size)
        assertEquals("Germany", classUnderTest.safeCallWithRun()[1])
    }

    @Test
    fun givenNullableString_whenElvisOperatorIsUsed_thenReturnsDefaultValue() {
        assertEquals("Not available", classUnderTest.elvisOperatorForDefaultValue())
    }

    @Test
    fun givenNonNullableString_whenElvisOperatorIsUsed_thenReturnsValue() {
        assertEquals("002", classUnderTest.elvisOperator())
    }

    @Test
    fun givenNullableString_whenElvisOperatorIsUsed_thenThrowsException() {
        assertThrows<IllegalArgumentException> { classUnderTest.elvisOperatorForException() }
    }

    @Test
    fun givenNonNullableString_whenNotNullAssertionOperatorIsUsed_thenReturnsValue() {
        assertEquals(5, classUnderTest.notNullAssertion())
    }

    @Test
    fun givenNullableString_whenNotNullAssertionOperatorIsUsed_thenThrowsException() {
        assertThrows<NullPointerException> { classUnderTest.notNullAssertionForException() }
    }

    @Test
    fun givenList_whenFilterNotNullIsUsed_thenReturnsOnlyNonNullableElements() {
        assertEquals(3, classUnderTest.filterNotNullList().size)
        assertEquals("Russia", classUnderTest.filterNotNullList()[2])
    }
}