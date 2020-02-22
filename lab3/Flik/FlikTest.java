import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {


    @Test
    public void testisSameNumber() {
        int a = 129;
        int b = 129;
        assertTrue(Flik.isSameNumber(a, b));
    }

    /** Performs a few arbitrary tests to see if the sum method is correct */



    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", FlikTest.class);
    }
}