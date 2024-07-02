package com.atlast.leet_code.c1_arrays_and_strings

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/description/
 */
fun containsDuplicate(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    for (num in nums) {
        if (!set.add(num)) return true
    }
    return false
}