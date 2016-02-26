package task02;

/**
 * Created by Birthright on 23.02.2016.
 */
public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this(0, 0);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.getX(), this.y + v.getY());
    }

    public void add2(Vector2D v) {
        this.x += v.getX();
        this.y += v.getY();
    }

    public Vector2D sub(Vector2D v) {
        return new Vector2D(this.x - v.getY(), this.y - v.getY());
    }

    public void sub2(Vector2D v) {
        this.x -= v.getX();
        this.y -= v.getY();
    }

    public Vector2D mult(double v) {
        return new Vector2D(this.x * v, this.y * v);
    }

    public void mult2(double v) {
        this.x *= v;
        this.y *= v;
    }

    public String toString() {
        return "(" + this.x + " , " + this.y + ")";
    }


    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double scalarProduct(Vector2D v) {
        return this.x * v.getX() + this.y * v.getY();
    }

    public double cos(Vector2D v) {
        return (this.scalarProduct(v)) / this.length() / v.length();
    }

    public boolean equals(Vector2D v) {
        return this.x == v.getX() && this.y == v.getY();
    }
}
