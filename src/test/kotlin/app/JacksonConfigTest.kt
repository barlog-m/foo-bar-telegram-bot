package app

import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import java.time.LocalDateTime

class JacksonConfigTest {
    data class Foo(
        val date: LocalDateTime

    )
    @Test
    fun objectMapper() {
        val foo = Foo(
            date = LocalDateTime.of(1999, 5, 21, 11, 40)
        )

        val r = objectMapper.writeValueAsString(foo)
        println(r)
        assertTrue(r.contains("1999-05-21T11:40:00"))

        val fooRestored = objectMapper.readValue<Foo>(r)
        assertEquals(foo, fooRestored)
    }
}
