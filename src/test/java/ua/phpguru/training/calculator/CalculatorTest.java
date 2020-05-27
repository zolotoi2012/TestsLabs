package ua.phpguru.training.calculator;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import ua.phpguru.training.calculator.Calculator;
import ua.phpguru.training.calculator.NegativeSqrtException;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.not;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() throws Exception {
         calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        if (calculator != null)
        {
            calculator = null;
            Runtime.getRuntime().gc();
        }
    }

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Ignore
    @Test
    public void givenLongRu_nningTest_whenTimout_thenTestFails() throws InterruptedException {
        TimeUnit.SECONDS.sleep(11);
    }

    @Test
    public void additionWrongResult(){
        Double expected = 10.0;
        Double actual = calculator.addition(5.0,8.0);
        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void subtractionWrongResult(){
        Double expected = 10.0;
        Double actual = calculator.addition(20.0,15.0);
        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void additionSuccess() {
        Double expected = 10.0;
        Double actual = calculator.addition(5.0,5.0);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subtractionSuccess() {
        Double expected = 10.0;
        Double actual = calculator.subtraction(20.0,10.0);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void multiplicationSuccess() {
        Double expected = 10.0;
        Double actual = calculator.multiplication(2.0,5.0);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void divideSuccess() {
        Double expected = 10.0;
        Double actual = calculator.divide(20.0,2.0);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void degreeSuccess(){
        Double expected = 27.0;
        Double actual = calculator.degree(3.0,3.0);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sqrtSuccess() {
        Double expected = 4.0;
        Double actual = calculator.sqrt(16.0);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void negativeSqrtExceptionTest() {
        thrown.expect(RuntimeException.class);
        thrown.expect(NegativeSqrtException.class);
        thrown.expectMessage("You can’t get a sqrt from a negative number!");
        throw new NegativeSqrtException();
    }

    @Test(expected = NegativeSqrtException.class)
    public void negativeSqrtOperationTest(){
        calculator.sqrt(-2.5);
    }

    @Test(expected = ArithmeticException.class)
    public void multiplicationOnZeroTest() {

        calculator.multiplication(2.0,0.0);

    }

    @Test(expected = ArithmeticException.class)
    public void divideOnZeroTest() {

        calculator.multiplication(2.0,0.0);

    }
}