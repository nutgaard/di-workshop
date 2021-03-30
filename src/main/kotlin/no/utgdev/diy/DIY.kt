package no.utgdev.diy

// TODO Oppgave 2
class DIY {
    private var instantiated: Boolean = false
    private var beans: MutableSet<BeanDefinition> = mutableSetOf()
    private var objects: Map<String, Any> = mapOf()

    companion object {
        private var instance: DIY? = null

        @JvmStatic
        fun getInstance(): DIY = getInstance(false)

        @JvmStatic
        fun reset() {
            getInstance(true)
        }

        @JvmStatic
        fun getInstance(refresh: Boolean): DIY {
            if (instance == null || refresh) {
                instance = DIY()
            }
            return requireNotNull(instance)
        }

        @JvmStatic
        fun load(classPath: String) {
            getInstance().beans.addAll(DIYStatic.scan(classPath))
        }

        @JvmStatic
        fun load(root: Class<*>) {
            getInstance().beans.addAll(DIYStatic.scan(root))
        }

        @JvmStatic
        fun getBean(name: String): Any? {
            val diy = getInstance()
            if (!diy.instantiated) {
                diy.objects = DIYStatic.instansiate(diy.beans)
                DIYStatic.wireup(diy.objects)
                diy.instantiated = true
            }
            return DIYStatic.getBean(diy.objects, name)
        }
    }
}