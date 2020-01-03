package pvt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Start CalculatorTest");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Finish CalculatorTest");
    }

    @Before
    public void initTest() {
        calculator = new Calculator();
    }

    @Test
    public void getSum() {
        assertEquals(15, calculator.getSum(7, 8));
    }

    @Test
    public void getDeduct() {
        assertEquals(15, calculator.getDeduct(20, 5));
    }

    @Test
    public void getDivide() {
        assertEquals(20, calculator.getDivide(100, 5));
    }

    @Test
    public void getMultiple() {
        assertEquals(25, calculator.getMultiple(5, 5));
    }
}