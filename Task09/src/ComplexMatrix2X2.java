/**
 * Created by Birthright on 23.02.2016.
 */
public class ComplexMatrix2X2 {
    private ComplexNumber[][] a = new ComplexNumber[2][2];

    public ComplexMatrix2X2(ComplexNumber v) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.a[i][j] = v;
            }
        }
    }

    public ComplexMatrix2X2() {
        this(new ComplexNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexMatrix2X2)) return false;

        ComplexMatrix2X2 that = (ComplexMatrix2X2) o;
        ComplexNumber[][] a = this.a;
        ComplexNumber[][] b = that.getA();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (a[i][j].getReal()!=b[i][j].getReal() || a[i][j].getImaginary()!=b[i][j].getImaginary()){
                    return false;
                }
            }
        }
        return true;

    }



    public ComplexMatrix2X2(ComplexNumber v, ComplexNumber v1, ComplexNumber v2, ComplexNumber v3) {
        this.a[0][0] = v;
        this.a[0][1] = v1;
        this.a[1][0] = v2;
        this.a[1][1] = v3;
    }

    public ComplexNumber[][] getA() {
        return a;
    }

    public void setA(ComplexNumber[][] a) {
        this.a = a;
    }

    public ComplexMatrix2X2 add(ComplexMatrix2X2 v) {
        return new ComplexMatrix2X2((this.a[0][0]).add(v.getA()[0][0]), this.a[0][1].add(v.getA()[0][1]), (this.a[1][0]).add(v.getA()[1][0]), (this.a[1][1]).add(v.getA()[1][1]));
    }

    public ComplexMatrix2X2 mult(ComplexMatrix2X2 v) {
        return new ComplexMatrix2X2((this.a[0][0].mult(v.getA()[0][0]).add(this.a[0][1].mult(v.getA()[1][0]))), (this.a[0][0].mult(v.getA()[0][1]).add(this.a[0][1].mult(v.getA()[1][1]))), (this.a[1][0].mult(v.getA()[0][0]).add(this.a[1][1].mult(v.getA()[1][0]))), (this.a[1][0].mult(v.getA()[0][1]).add(this.a[1][1].mult(v.getA()[1][1]))));
    }

    public ComplexNumber det() {
        if (this.getA()[0][0].mult(this.getA()[1][1]).equals(this.getA()[1][0].mult(this.getA()[0][1]))) {
            return new ComplexNumber();
        }
        ComplexNumber x = (this.a[0][0].mult(this.a[1][1])).sub(this.a[1][0].mult(this.a[0][1]));
        return new ComplexNumber(x.getReal(), x.getImaginary());
    }

    public ComplexVector2D multVector(ComplexVector2D v) {

        return new ComplexVector2D(((this.a[0][0].mult(v.getX())).add(this.a[0][1].mult(v.getY()))),
                ((this.a[1][0].mult(v.getX())).add(this.a[1][1].mult(v.getY()))));
    }

    public String toString() {
        return this.a[0][0].toString() + "   " + this.a[0][1].toString() + "\n" + this.a[1][0].toString() + "   " + this.a[1][1].toString();
    }
}
