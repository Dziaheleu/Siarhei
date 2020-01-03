import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class StringOperationTest {
    @DataProvider(name = "testNameCompareIgnoreCaseData")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"Sergei", "SERGEI"}, {"sergei", "Sergei"}, {"Sergei", "sergei"}};
    }

    static StringOperation stringOperation;

    @BeforeClass
    public void setUp() {
        stringOperation = new StringOperation();
    }

    @Test
    public void testIsStartWith() {
        assertTrue(stringOperation.isStartWith("Sergei", "S"));
    }

    private void assertTrue(boolean startWith) {
    }

    @Test
    public void testIsStartWithNegative() {
        assertFalse(stringOperation.isStartWith("Sergei", "A"));
    }

    @Test
    public void testSergeiMan() {
        String actual = stringOperation.sergeiMan("Sergei is Woman");
        String expected = "Sergei is Man";
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "testNameCompareIgnoreCaseData")
    public void testNameCompareIgnoreCase(String name1, String name2) {
        assertTrue(stringOperation.nameCompareIgnoreCase(name1, name2));
    }

    @Test
    public void testTrimmer() {
        String actual = stringOperation.trimmer("Sergei");
        String expected = "Sergei";
        assertEquals(actual, expected);
    }

    @Test
    public void testCharByIndex() {
        char actual = stringOperation.charByIndex("Sergei", 3);
        char expected = 'g';
        assertEquals(actual, expected);
    }
}