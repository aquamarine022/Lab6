package common.Data;

import java.io.Serializable;

/**
 * Class to operate with coordinates
 */
public class Coordinates implements Comparable<Coordinates>, Serializable {
     /**
     *Coordinate x
     *Max value: 717, Can't be null
     */
     private Integer x;
     /**
     *Coordinate y
     */
     private float y;

    /**
     * Constructor
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Coordinates(int x, float y) {
            this.x = x;
            this.y = y;
        }

    /**
     * Method to get x coordinate
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Method to get y coordinate
     * @return y coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * Method to get formatted string representation of coordinate
     * @return String value
     */
    @Override
    public String toString() {
        return x + ";" + y;
    }

    @Override
    public int compareTo(Coordinates o) {
        return (int) (((this.x * this.x) + (this.y * this.y)) - ((o.x * o.x) + (o.y * o.y)));
    }
}
