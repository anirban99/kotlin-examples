package com.example.tutorials.nullsafety

class NullSafety {

    fun nullCheckForValue(): Int? {
        var country: String = "India"
//        country = null //compilation error
        return if (country != null) {
            country.length
        } else {
            null
        }
    }

    fun nullCheck(): Int? {
        var city: String? = "Kolkata"
        city = null
        return if (city != null) {
            city.length
        } else {
            null
        }
    }

    fun safeCallForValue(): Int? {
        val country: String? = "India"
        return country?.length
    }

    fun safeCall(): Int? {
        val city: String? = null
        return city?.length
    }

    fun safeCallChainForValue(): String? {
        val country: Country? = Country(City("Kolkata", "003"))
        return country?.city?.code
    }

    fun safeCallChain(): String? {
        val country: Country? = Country(null)
        return country?.city?.code
    }

    fun safeCallWithLet(){

    }

    fun safeCallWithAlso(){

    }

    fun safeCallWithRun(){

    }

    fun elvisOperatorForValue(){

    }

    fun elvisOperator(){

    }

    fun elvisOperatorForException(){

    }

    fun notNullAssertion(){

    }

    fun filterList(){

    }

    data class Country(val city: City?)

    data class City(val name: String?, val code: String?)
}