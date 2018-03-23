package app

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ArgsTest {

    @Test
    fun parse() {
        val args = parse(listOf("--one=1", "--two=two", "--three"))
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
        val args = parse(listOf(""))
        assertEquals(mapOf<String, String>(), args)
    }

    @Test
    fun port() {
        val args = parse(listOf("--port=8081"))
        val port = port(args)
        assertEquals(8081, port)
    }

    @Test
    fun portDefault() {
        val args = parse(listOf("--port=foo"))
        val port = port(args)
        assertEquals(8080, port)
    }

    @Test
    fun portEmpty() {
        val args = parse(listOf(""))
        val port = port(args)
        assertEquals(8080, port)
    }

    @Test
    fun webHookToken() {
        val args = parse(listOf("--wh_token=foo"))
        val whToken = webHookToken(args)
        assertEquals("foo", whToken)
    }

    @Test
    fun webHookTokenNone() {
        val args = parse(listOf("--wh_token"))
        val whToken = webHookToken(args)
        assertEquals("none", whToken)
    }

    @Test
    fun webHookTokenEmpty() {
        val args = parse(listOf(""))
        val whToken = webHookToken(args)
        assertEquals("none", whToken)
    }

    @Test
    fun authToken() {
        val args = parse(listOf("--auth_token=foo"))
        val authToken = authToken(args)
        assertEquals("foo", authToken)
    }

    @Test
    fun authTokenNone() {
        val args = parse(listOf("--auth_token"))
        val authToken = authToken(args)
        assertEquals("none", authToken)
    }

    @Test
    fun authTokenEmpty() {
        val args = parse(listOf(""))
        val authToken = authToken(args)
        assertEquals("none", authToken)
    }
}
