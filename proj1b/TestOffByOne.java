import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testOffByOne() {
        assertTrue(offByOne.equalChars('t', 'u'));
        assertTrue(offByOne.equalChars('u', 'v'));
        assertFalse(offByOne.equalChars('t', 't'));
        assertFalse(offByOne.equalChars('T', 'u'));
        assertTrue(offByOne.equalChars('%', '&'));
    }
}
