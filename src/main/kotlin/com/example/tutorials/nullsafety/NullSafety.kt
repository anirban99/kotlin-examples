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

    fun safeCallWithLet(): List<String?> {
        val cities: List<String?> = listOf("Kolkata", null, "Mumbai")
        var name: List<String?> = emptyList()
        for (city in cities) {
            city?.let { name = name.plus(it) }
        }
        return name
    }

    fun safeCallWithAlso(): List<String?> {
        val cities: List<String?> = listOf("Kolkata", null, "Mumbai")
        var name: List<String?> = emptyList()
        for (city in cities) {
            city?.let {
                name = name.plus(it)
                it
            }?.also { println("Logging the value: $it") }
        }
        return name
    }

    fun safeCallWithRun(): List<String?> {
        val countries: List<String?> = listOf("India", null, "Germany")
        var name: List<String?> = emptyList()
        for (country in countries) {
            country?.run {
                name = name.plus(this)
                this
            }?.also { println("Logging the value: $it") }
        }
        return name
    }

    fun elvisOperatorForDefaultValue(): String {
        val country: Country? = Country(City("New Delhi", null))
        return country?.city?.code ?: "Not available"
    }

    fun elvisOperator(): String {
        val country: Country? = Country(City("Mumbai", "002"))
        return country?.city?.code ?: "Not available"
    }

    fun elvisOperatorForException(): String {
        val country: Country? = Country(City("Chennai", null))
        return country?.city?.code ?: throw IllegalArgumentException("Not a valid code")
    }

    fun notNullAssertion(): Int {
        val country: String? = "India"
        return country!!.length
    }

    fun notNullAssertionForException(): Int {
        val country: String? = null
        return country!!.length
    }

    fun filterNotNullList(): List<String> {
        val countries: List<String?> = listOf("India", null, "Germany", "Russia", null)
        val filteredList: List<String> = countries.filterNotNull()
        return filteredList
    }

    data class Country(val city: City?)

    data class City(val name: String, val code: String?)
}