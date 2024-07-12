package com.atlast.leet_code.c1_arrays_and_strings

/**
 * 443. String Compression
 */
fun compress(chars: CharArray): Int {
    if (chars.size <= 1) return chars.size
    var updatedIndex = 0
    var curChar = chars[0]
    var start = 0
    for (i in 1..chars.size) {
        if (i < chars.size && chars[i] == curChar) {
            continue
        } else {
            chars[updatedIndex++] = curChar
            val curCount = i - start
            if (curCount > 1) {
                curCount.toString().forEach { numChar ->
                    chars[updatedIndex++] = numChar
                }
            }
            curChar = chars.getOrNull(i) ?: chars.last()
            start = i
        }
    }
    chars.groupBy { it }.toList().joinToString(separator = "") { (char, charList) ->
        "$char${if (charList.size > 1) charList.size else ""}"
    }.also {
        it.forEachIndexed { index, char ->
            chars[index] = char
        }
    }.length
    return updatedIndex


}