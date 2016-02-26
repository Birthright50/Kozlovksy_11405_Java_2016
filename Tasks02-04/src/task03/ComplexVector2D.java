package task03;

/**
 * Created by Birthright on 23.02.2016.
 */
public class ComplexVector2D {
    private ComplexNumber x;
    private ComplexNumber y;


    public ComplexVector2D(ComplexNumber x, ComplexNumber y) {
        this.x = x;
        this.y = y;
    }

    public ComplexVector2D() {
        this(new ComplexNumber(), new ComplexNumber());
    }

    public ComplexNumber getX() {
        return x;
    }

    public void setX(ComplexNumber x) {
        this.x = x;
    }

    public ComplexNumber getY() {
        return y;
    }

    public void setY(ComplexNumber y) {
        this.y = y;
    }

    public ComplexVector2D add(ComplexVector2D v) {
        return new ComplexVector2D(this.x.add(v.getX()), this.y.add(v.getY()));
    }

    public String toString() {
        return this.x.toString() + " , " + this.y.toString();
    }

    public ComplexNumber scalarProduct(ComplexVector2D v) {
        ComplexNumber h = (this.x.mult(v.getX())).add(this.y.mult(v.getY()));
        return new ComplexNumber(h.getReal(), h.getImaginary());
    }

    public boolean equals(ComplexVector2D v) {
        return this.getX().equals(v.getX()) && this.getY().equals(v.getY());
    }}
