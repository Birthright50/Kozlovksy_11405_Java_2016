package task03;

/**
 * Created by Birthright on 23.02.2016.
 */
public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public String toString() {
        if (imaginary >= 0)
            return real + " + " + imaginary + " * i";
        else
            return real + " - " + -imaginary + " * i";
    }

    public ComplexNumber() {
        this(0.0, 0.0);
    }

    public ComplexNumber add(ComplexNumber v) {
        return new ComplexNumber(this.real + v.getReal(), this.imaginary + v.getImaginary());
    }

    public void add2(ComplexNumber v) {
        this.real += v.getReal();
        this.imaginary += v.getImaginary();
    }

    public ComplexNumber sub(ComplexNumber v) {
        return new ComplexNumber(this.real - v.getReal(), this.imaginary - v.getImaginary());
    }

    public void sub2(ComplexNumber v) {
        this.real -= v.getReal();
        this.imaginary -= v.getImaginary();
    }

    public ComplexNumber multNumber(double v) {
        return new ComplexNumber(this.real * v, this.imaginary * v);
    }

    public void multNumber2(double v) {
        this.real *= v;
        this.imaginary *= v;
    }

    public ComplexNumber mult(ComplexNumber v) {
        return new ComplexNumber(this.real * v.getReal() - this.imaginary * v.getImaginary(), this.imaginary * v.getReal() + this.real * v.getImaginary());
    }

    public void mult2(ComplexNumber v) {
        double b = this.real;
        this.real = this.real * v.getReal() - this.imaginary * v.getImaginary();
        this.imaginary = b * v.getImaginary() + this.imaginary * v.getReal();
    }

    public ComplexNumber div(ComplexNumber v) {
        ComplexNumber div = new ComplexNumber();
        double h, z;
        if (Math.abs(v.getReal()) >= Math.abs(v.getImaginary())) {
            h = v.getImaginary() / v.getReal();
            z = v.getReal() + h * v.getImaginary();
            div.real = (this.real + h * this.imaginary) / z;
            div.imaginary = (this.imaginary - h * this.real) / z;
            return div;
        } else {
            h = v.getReal() / v.getImaginary();
            z = v.getImaginary() + h * v.getReal();
            div.real = (h * this.real + this.imaginary) / z;
            div.imaginary = (h * this.imaginary - this.real) / z;
            return div;
        }
    }

    public void div2(ComplexNumber v) {
        double h, z;
        if (Math.abs(v.getReal()) >= Math.abs(v.getImaginary())) {
            h = v.getImaginary() / v.getReal();
            z = v.getReal() + h * v.getImaginary();
            this.real = (this.real + h * this.imaginary) / z;
            this.imaginary = (this.imaginary - h * this.real) / z;

        } else {
            h = v.getReal() / v.getImaginary();
            z = v.getImaginary() + h * v.getReal();
            this.real = (h * this.real + this.imaginary) / z;
            this.imaginary = (h * this.imaginary - this.real) / z;
        }
    }

    public double length() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    }

    public double arg() {
        return Math.atan2(this.imaginary, this.real);
    }

    public ComplexNumber pow(double v) {
        ComplexNumber pow = new ComplexNumber();
        pow.real = Math.pow(this.length(), v) * Math.cos(v * this.arg());
        pow.imaginary = Math.pow(this.length(), v) * Math.sin(v * this.arg());
        return pow;
    }

    public boolean equals(ComplexNumber v) {
        return this.real == v.getReal() && this.imaginary == v.getImaginary();
    }
}