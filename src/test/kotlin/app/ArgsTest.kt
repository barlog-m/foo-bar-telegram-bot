package app

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ArgsTest {

    @Test
    fun parse() {
        val args = parse("--one=1", "--two=two", "--three")
        assertEquals(3, args.size)
        assertTrue(args.containsKey("one"))
        assertEquals("1", args["one"])
        assertTrue(args.containsKey("two"))
        assertEquals("two", args["two"])
        assertTrue(args.containsKey("three"))
        assertEquals("", args["three"])
    }

    @Test
    fun parseEmpty() {
        val args = parse("", "")
        assertEquals(mapOf<String, String>(), args)
    }

    @Test
    fun port() {
        val args = parse("--port=8081")
        val port = port(args)
        assertEquals(8081, port)
    }

    @Test
    fun portDefault() {
        val args = parse("--port=foo")
        val port = port(args)
        assertEquals(8080, port)
    }

    @Test
    fun portEmpty() {
        val args = parse("")
        val port = port(args)
        assertEquals(8080, port)
    }

    @Test
    fun webHookToken() {
        val args = parse("--wh_token=foo")
        val whToken = webHookToken(args)
        assertEquals("foo", whToken)
    }

    @Test
    fun webHookTokenNone() {
        val args = parse("--wh_token")
        val whToken = webHookToken(args)
        assertEquals("none", whToken)
    }

    @Test
    fun webHookTokenEmpty() {
        val args = parse("")
        val whToken = webHookToken(args)
        assertEquals("none", whToken)
    }

    @Test
    fun authToken() {
        val args = parse("--auth_token=foo")
        val authToken = authToken(args)
        assertEquals("foo", authToken)
    }

    @Test
    fun authTokenNone() {
        val args = parse("--auth_token")
        val authToken = authToken(args)
        assertEquals("none", authToken)
    }

    @Test
    fun authTokenEmpty() {
        val args = parse("")
        val authToken = authToken(args)
        assertEquals("none", authToken)
    }
}
