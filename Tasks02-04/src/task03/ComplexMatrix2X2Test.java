package task03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Birthright on 23.02.2016.
 */
public class ComplexMatrix2X2Test {
    public ComplexMatrix2X2 complexMatrix2X2;
    public ComplexMatrix2X2 complexMatrix2X2WithZeroDet;

    @Before
    public void createSomeMatrix() {
        complexMatrix2X2 = new ComplexMatrix2X2(new ComplexNumber(1, 0), new ComplexNumber(2, 5),
                new ComplexNumber(-5, 3), new ComplexNumber(7, 5));
        complexMatrix2X2WithZeroDet = new ComplexMatrix2X2(new ComplexNumber(1, 0), new ComplexNumber(2, 0), new ComplexNumber(1, 0), new ComplexNumber(2, 0));
    }


    @Test
    public void threeConstructorsShouldBeEquals() {
        ComplexNumber complexNumber = mock(ComplexNumber.class);
        when(complexNumber.getReal()).thenReturn(0.0);
        when(complexNumber.getImaginary()).thenReturn(0.0);
        ComplexMatrix2X2 cm1 = new ComplexMatrix2X2();
        ComplexMatrix2X2 cm2 = new ComplexMatrix2X2(complexNumber);
        ComplexMatrix2X2 cm3 = new ComplexMatrix2X2(complexNumber, complexNumber, complexNumber, complexNumber);
        Assert.assertTrue(cm1.equals(cm2) && cm1.equals(cm3));
    }

    @Test
    public void equalsShouldBeWork() {
        Assert.assertFalse(complexMatrix2X2.equals(new ComplexMatrix2X2()));
    }

    @Test
    public void getterAndSetterShouldBeWork() {
        ComplexNumber complexNumber = mock(ComplexNumber.class);
        when(complexNumber.getReal()).thenReturn(0.0);
        when(complexNumber.getImaginary()).thenReturn(0.0);
        ComplexNumber[][] array = new ComplexNumber[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = complexNumber;
            }
        }
        complexMatrix2X2.setA(array);

        Assert.assertTrue(Arrays.deepEquals(complexMatrix2X2.getA(), array));
    }

    @Test
    public void toStringShouldBeWorkCorrect() {
        String s = complexMatrix2X2.getA()[0][0].getReal() + " + " + complexMatrix2X2.getA()[0][0].getImaginary()
                + " * i   " + complexMatrix2X2.getA()[0][1].getReal() + " + " + complexMatrix2X2.getA()[0][1].getImaginary()
                + " * i\n" + complexMatrix2X2.getA()[1][0].getReal() + " + " + complexMatrix2X2.getA()[1][0].getImaginary()
                + " * i   " + complexMatrix2X2.getA()[1][1].getReal() + " + " + complexMatrix2X2.getA()[1][1].getImaginary() +
                " * i";

        Assert.assertTrue(s.equals(complexMatrix2X2.toString()));
    }

    @Test
    public void addShouldBeWork() {
        ComplexNumber complexNumber = mock(ComplexNumber.class);
        when(complexNumber.getReal()).thenReturn(1.0);
        when(complexNumber.getImaginary()).thenReturn(1.0);
        ComplexMatrix2X2 complexMatrix2X2 = mock(ComplexMatrix2X2.class);
        when(complexMatrix2X2.getA()).thenReturn(new ComplexNumber[][]{
                {complexNumber, complexNumber}, {complexNumber, complexNumber}
        });
        ComplexNumber complexNumber1 = mock(ComplexNumber.class);
        ComplexNumber complexNumber2 = mock(ComplexNumber.class);
        ComplexNumber complexNumber3 = mock(ComplexNumber.class);
        ComplexNumber complexNumber4 = mock(ComplexNumber.class);
        when(complexNumber1.getReal()).thenReturn(2.0);
        when(complexNumber1.getImaginary()).thenReturn(1.0);
        when(complexNumber2.getReal()).thenReturn(3.0);
        when(complexNumber2.getImaginary()).thenReturn(6.0);
        when(complexNumber3.getReal()).thenReturn(-4.0);
        when(complexNumber3.getImaginary()).thenReturn(4.0);
        when(complexNumber4.getReal()).thenReturn(8.0);
        when(complexNumber4.getImaginary()).thenReturn(6.0);

        ComplexMatrix2X2 complexMatrix = mock(ComplexMatrix2X2.class);
        when(complexMatrix.getA()).thenReturn(new ComplexNumber[][]{
                {complexNumber1, complexNumber2}, {complexNumber3, complexNumber4}
        });
        Assert.assertTrue(this.complexMatrix2X2.add(complexMatrix2X2).equals(complexMatrix));
    }

    @Test
    public void multShouldBeWork() {
        ComplexNumber complexNumber = mock(ComplexNumber.class);
        when(complexNumber.getReal()).thenReturn(1.0);
        when(complexNumber.getImaginary()).thenReturn(1.0);
        ComplexMatrix2X2 complexMatrix2X2 = mock(ComplexMatrix2X2.class);
        when(complexMatrix2X2.getA()).thenReturn(new ComplexNumber[][]{
                {complexNumber, complexNumber}, {complexNumber, complexNumber}
        });
        ComplexNumber complexNumber1 = mock(ComplexNumber.class);
        ComplexNumber complexNumber2 = mock(ComplexNumber.class);
        ComplexNumber complexNumber3 = mock(ComplexNumber.class);
        ComplexNumber complexNumber4 = mock(ComplexNumber.class);
        when(complexNumber1.getReal()).thenReturn(-2.0);
        when(complexNumber1.getImaginary()).thenReturn(8.0);
        when(complexNumber2.getReal()).thenReturn(-2.0);
        when(complexNumber2.getImaginary()).thenReturn(8.0);
        when(complexNumber3.getReal()).thenReturn(-6.0);
        when(complexNumber3.getImaginary()).thenReturn(10.0);
        when(complexNumber4.getReal()).thenReturn(-6.0);
        when(complexNumber4.getImaginary()).thenReturn(10.0);

        ComplexMatrix2X2 complexMatrix = mock(ComplexMatrix2X2.class);
        when(complexMatrix.getA()).thenReturn(new ComplexNumber[][]{
                {complexNumber1, complexNumber2}, {complexNumber3, complexNumber4}
        });

        Assert.assertTrue(this.complexMatrix2X2.mult(complexMatrix2X2).equals(complexMatrix));
    }

    @Test
    public void determinantShouldBeCorrect() {
        ComplexNumber complexNumber = mock(ComplexNumber.class);
        when(complexNumber.getReal()).thenReturn(32.0);
        when(complexNumber.getImaginary()).thenReturn(24.0);
        Assert.assertTrue(complexMatrix2X2.det().equals(complexNumber));
    }

    @Test
    public void determinantWithEqualMultDiagonalShouldBeZero() {
        ComplexNumber complexNumber = mock(ComplexNumber.class);
        when(complexNumber.getReal()).thenReturn(0.0);
        when(complexNumber.getImaginary()).thenReturn(0.0);

        Assert.assertTrue(this.complexMatrix2X2WithZeroDet.det().equals(complexNumber));
    }

    @Test
    public void multVectorShouldBeWork() {
        ComplexNumber c1 = mock(ComplexNumber.class);
        ComplexNumber c2 = mock(ComplexNumber.class);
        when(c1.getImaginary()).thenReturn(1.0);
        when(c2.getImaginary()).thenReturn(1.0);
        when(c1.getReal()).thenReturn(1.0);
        when(c2.getReal()).thenReturn(1.0);
        ComplexVector2D complexVector2D = mock(ComplexVector2D.class);
        when(complexVector2D.getX()).thenReturn(c1);
        when(complexVector2D.getY()).thenReturn(c2);


        ComplexVector2D finalVector = mock(ComplexVector2D.class);
        ComplexNumber c3 = mock(ComplexNumber.class);
        ComplexNumber c4 = mock(ComplexNumber.class);
        when(c3.getImaginary()).thenReturn(8.0);
        when(c4.getImaginary()).thenReturn(10.0);
        when(c3.getReal()).thenReturn(-2.0);
        when(c4.getReal()).thenReturn(-6.0);
        when(finalVector.getX()).thenReturn(c3);
        when(finalVector.getY()).thenReturn(c4);

        Assert.assertTrue((complexMatrix2X2.multVector(complexVector2D)).equals(finalVector));
    }
}
