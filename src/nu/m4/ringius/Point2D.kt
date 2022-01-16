package nu.m4.ringius

/**
 * Class representing an elf point in the sky. The point has an initial location, and a velocity.
 */

class Point2D(var location: Vector2D, private val velocity: Vector2D) : Comparable<Point2D> {

    // Update the location in place
    fun updateLocationUsingTime(time: Int) {
        this.location += (velocity * time)
    }

    override fun compareTo(other: Point2D) = location.compareTo(other.location)
}

