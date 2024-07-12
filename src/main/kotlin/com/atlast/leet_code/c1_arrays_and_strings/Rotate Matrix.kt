package com.atlast.leet_code.c1_arrays_and_strings

/**
 * 48. Rotate Image
 */
fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix.size
    val layers = n / 2
    for (layer in 0 until layers) {
        val layerSize = n - 2 * layer
        val layerLastIndex = layer + (layerSize - 1)
        for (i in layer until layerLastIndex) {//1,2
            val top = layer to i //1 1
            val right = i to layerLastIndex //1 2
            val bottom = layerLastIndex to layerLastIndex - i + layer // 2 2
            val left = layerLastIndex - i + layer to layer //1 1
            val temp = matrix[top.first][top.second]
            matrix[top.first][top.second] = matrix[left.first][left.second]
            matrix[left.first][left.second] = matrix[bottom.first][bottom.second]
            matrix[bottom.first][bottom.second] = matrix[right.first][right.second]
            matrix[right.first][right.second] = temp
        }
    }
}