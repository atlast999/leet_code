package com.atlast.leet_code.c1_arrays_and_strings

/**
 * 242. Valid Anagram
 */
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val map = mutableMapOf<Char, Int>()
    for (index in s.indices) {
        val fromS = s[index]
        val fromT = t[index]
        if (fromS == fromT) continue
        val countS = map[fromS] ?: 0
        map[fromS] = countS + 1
        val countT = map[fromT] ?: 0
        map[fromT] = countT - 1
    }
    return map.any { (_, count) -> count != 0 }.not()
}

fun test242() {
    isAnagram(
        s = "anagram",
        t = "nagaram"
    ).let {
        println("res: $it")
    }
}