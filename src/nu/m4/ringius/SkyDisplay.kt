package nu.m4.ringius

/**
 * Class used to display 'the sky' in terminal window.
 * Note that this class does not take memory into consideration, so trying to print too big a sky will
 * cause exception.
 */

class SkyDisplay {
    fun printSky(sky: Sky) {
        val noOfCols = sky.xMax - sky.xMin
        val noOfRows = sky.yMax - sky.yMin
        val points = sky.getSortedPointsInSky()

        val startX = sky.xMin
        val startY = sky.yMin

        val display = Array(noOfRows+1) {CharArray(noOfCols+1) {'.'} }

        for (point in points) {
            var row = display[point.location.y-startY]
            row[point.location.x-startX] = '#'
        }

        for (row in display) {
            for (col in row) {
                print("$col")
            }
            println() // newline
        }
    }
}