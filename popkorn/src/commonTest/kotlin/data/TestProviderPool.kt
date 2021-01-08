package cc.popkorn.data

import cc.popkorn.core.exceptions.ProviderNotFoundException
import cc.popkorn.pools.ProviderPool
import cc.popkorn.providers.Provider
import kotlin.reflect.KClass

/**
 * ResolverPool that define how test classes are created
 *
 * @author Pau Corbella
 * @since 2.0.0
 */
class TestProviderPool : ProviderPool {

    override fun <T : Any> isPresent(clazz: KClass<T>): Boolean {
        return when (clazz) {
            TestClassByApp::class -> true
            TestClassByNew::class -> true
            TestClassByUse::class -> true
            TestAssistedClass::class -> true
            TestAssistedClass2::class -> true
            else -> false
        }
    }

    override fun <T : Any> create(clazz: KClass<T>): Provider<T> {
        return when (clazz) {
            TestClassByApp::class -> TestClassByAppProvider() as Provider<T>
            TestClassByNew::class -> TestClassByNewProvider() as Provider<T>
            TestClassByUse::class -> TestClassByUseProvider() as Provider<T>
            TestAssistedClass::class -> TestAssistedClassProvider() as Provider<T>
            TestAssistedClass2::class -> TestAssistedClass2Provider() as Provider<T>
            else -> throw ProviderNotFoundException(clazz)
        }
    }
}
