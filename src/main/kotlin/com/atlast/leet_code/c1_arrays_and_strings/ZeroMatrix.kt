package com.atlast.leet_code.c1_arrays_and_strings

/**
 * 73. Set Matrix Zeroes
 */
fun setZeroesOld(matrix: Array<IntArray>): Unit {
    val rows = mutableSetOf<Int>()
    val columns = mutableSetOf<Int>()
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == 0) {
                rows.add(i)
                columns.add(j)
            }
        }
    }
    rows.forEach { row ->
        for (j in matrix[row].indices) {
            matrix[row][j] = 0
        }
    }
    columns.forEach { col ->
        for (i in matrix.indices) {
            matrix[i][col] = 0
        }
    }
}

fun setZeroes(matrix: Array<IntArray>): Unit {
    var firstRowHasZero = false
    for (col in matrix[0].indices) {
        if (matrix[0][col] == 0) {
            firstRowHasZero = true
            break
        }
    }
    var firstColHasZero = false
    for (row in matrix.indices) {
        if (matrix[row][0] == 0) {
            firstColHasZero = true
        }
    }
    for (row in matrix.indices) {
        for (col in matrix[row].indices) {
            if (matrix[row][col] == 0) {
                matrix[0][col] = 0
                matrix[row][0] = 0
            }
        }
    }
    for (row in 1..matrix.lastIndex) {
        for (col in 1..matrix[row].lastIndex) {
            if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                matrix[row][col] = 0
            }
        }
    }
    if (firstRowHasZero) {
        for (col in matrix[0].indices) {
            matrix[0][col] = 0
        }
    }
    if (firstColHasZero) {
        for (row in matrix.indices) {
            matrix[row][0] = 0
        }
    }
}