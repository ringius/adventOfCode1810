package nu.m4.ringius

/**
 * Simple minimal 2D vector with scalar multiplication and addition operators.
 */

class Vector2D(val x: Int, val y: Int) : Comparable<Vector2D> {
    // scalar multiplication
    operator fun times(t: Int): Vector2D {
        return Vector2D(x * t, y * t)
    }

    operator fun plus(b: Vector2D) = Vector2D(x + b.x, y + b.y)

    // sort first using y-coordinate, if same y - use x as tie-breaker.
    override fun compareTo(other: Vector2D): Int {
        if (y != other.y) {
            return y - other.y
        }
        return x - other.x
    }
}