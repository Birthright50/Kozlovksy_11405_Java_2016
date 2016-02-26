package task02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Birthright on 23.02.2016.
 */
public class Matrix2X2Test {
    public static Matrix2X2 matrix2X2;


    @Before
    public void createSomeMatrix() {
        matrix2X2 = new Matrix2X2(1, 2, 3, 4);
    }

    @Test
    public void fourConstructorShouldGiveOneResult() {
        double[][] a = new double[2][2];
        Matrix2X2 m1 = new Matrix2X2(a);
        Matrix2X2 m2 = new Matrix2X2(0);
        Matrix2X2 m3 = new Matrix2X2(0, 0, 0, 0);
        Matrix2X2 m4 = new Matrix2X2();
        Assert.assertTrue(m1.equals(m2) && m1.equals(m3) && m1.equals(m4));
    }

    @Test
    public void getterAndSetterShouldBeWork() {
        double[][] a = new double[2][2];
        matrix2X2.setA(a);
        Assert.assertTrue(Arrays.deepEquals(matrix2X2.getA(), a));
    }

    @Test
    public void transposeMatrixShouldBeWork() {
        matrix2X2.transpon();
        Assert.assertTrue(matrix2X2.equals(new Matrix2X2(1, 3, 2, 4)));
    }

    @Test
    public void inverseMatrixShouldBeWork() {
        Assert.assertTrue(matrix2X2.inverseMatrix().equals(new Matrix2X2(-2, 1, 1.5, -0.5)));
    }

    @Test
    public void equivalentDiagonalShoudBeTrue() {
        Assert.assertTrue(matrix2X2.equivalentDiagonal().equals(new Matrix2X2(1, 0, 0, 4)));
    }

    @Test
    public void toStringShouldBeEquals() {
        String s = "1.0 2.0 \n3.0 4.0 \n";
        Assert.assertTrue(matrix2X2.toString().equals(s));
    }
    @Test
    public void addShouldBeCorrect(){
        Matrix2X2 m1 = new Matrix2X2(1, 1, 1, 1);
        Matrix2X2 m2 = new Matrix2X2(2, 3, 4, 5);
        Assert.assertTrue(matrix2X2.add(m1).equals(m2));
        matrix2X2.add2(m1);
        Assert.assertTrue(matrix2X2.equals(m2));
    }
    @Test
    public void subShouldBeCorrect(){
        Matrix2X2 m1 = new Matrix2X2(1, 1, 1, 1);
        Matrix2X2 m2 = new Matrix2X2(0, 1, 2, 3);
        Assert.assertTrue(matrix2X2.sub(m1).equals(m2));
        matrix2X2.sub2(m1);
        Assert.assertTrue(matrix2X2.equals(m2));
    }

    @Test
    public void multNumberShouldBeCorrect(){
        int number = 2;
        Matrix2X2 m = new Matrix2X2(2, 4, 6, 8);
        Assert.assertTrue(matrix2X2.multNumber(number).equals(m));
        matrix2X2.multNumber2(number);
        Assert.assertTrue(matrix2X2.equals(m));
    }

    @Test
    public void multShouldBeCorrect(){
        Matrix2X2 m = new Matrix2X2(5, 10, 15, 20);
        Matrix2X2 mF = new Matrix2X2(35, 50, 75, 110);
        Assert.assertTrue(matrix2X2.mult(m).equals(mF));
        matrix2X2.mul2(m);
        System.out.println(matrix2X2);
        Assert.assertTrue(matrix2X2.equals(mF));
    }

    @Test
    public void multVectorShoulBeWork(){
        Vector2D v = new Vector2D(4, 10);
        Assert.assertTrue(matrix2X2.multVector(new Vector2D(2, 1)).equals(v));
    }


}
