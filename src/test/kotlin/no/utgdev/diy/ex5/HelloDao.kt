package no.utgdev.diy.ex5

class HelloDao {
    private var value = "Hello"

    constructor() {}
    constructor(value: String) {
        this.value = value
    }

    fun hello(): String {
        return value
    }
}