package nu.m4.ringius

class Sky {
    val sky = mutableSetOf<Point2D>()

    var xMin: Int = Int.MAX_VALUE
    var xMax: Int = Int.MIN_VALUE
    var yMin: Int = Int.MAX_VALUE
    var yMax: Int = Int.MIN_VALUE

    fun addPoint(point: Point2D) {
        sky.add(point)
    }

    private fun updateMinMax(point: Point2D) {
        xMin = Math.min(point.location.x, xMin)
        xMax = Math.max(point.location.x, xMax)
        yMin = Math.min(point.location.y, yMin)
        yMax = Math.max(point.location.y, yMax)
    }

    private fun resetMinMax() {
        xMin = Int.MAX_VALUE
        xMax = Int.MIN_VALUE
        yMin = Int.MAX_VALUE
        yMax = Int.MIN_VALUE
    }

    fun updateToTime(time: Int) {
        resetMinMax()

        for (point in sky) {
            point.updateLocationUsingTime(time)
            updateMinMax(point)
        }
    }

    fun getSortedPointsInSky(): List<Point2D> {
        return sky.sorted()
    }

    /**
     * checks whether there are rows in the sky that does not contain any points.
     * Assumption here is that when directions (text) is visible, no empty rows exists (since this would
     * mean "strikethrough" in the text)
     */
    fun noEmptyRows(): Boolean {
        var points = getSortedPointsInSky()
        var first = true
        var lastY = 0
        for (point in points) {
            val y = point.location.y
            if (first) {
                lastY = y
                first = false
            } else {
                if (y != lastY && y != lastY + 1) {
                    return false
                } else {
                    lastY = y
                }
            }
        }
        return true
    }

    fun init() {
        updateToTime(0)
    }
}
