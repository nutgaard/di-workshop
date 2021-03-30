package no.utgdev.diy

// TODO Oppgave 2
class DIY {
    companion object {
        private val instance: DIY? = null

        @JvmStatic
        fun getInstance(): DIY = getInstance(false)

        @JvmStatic
        fun reset() {
            getInstance(true)
        }

        @JvmStatic
        fun getInstance(refresh: Boolean): DIY {
            TODO("Not implemented yet")
        }

        @JvmStatic
        fun load(classPath: String) {
            TODO("Not implemented yet")
        }

        @JvmStatic
        fun load(root: Class<*>) {
            TODO("Not implemented yet")
        }

        @JvmStatic
        fun getBean(name: String): Any? {
            TODO("Not implemented yet")
        }
    }
}