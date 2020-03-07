package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(5);
        arb.enqueue(15);
        arb.enqueue(52);
        arb.enqueue(53);
        arb.enqueue(54);
        arb.enqueue(55);
        arb.enqueue(56);
        arb.enqueue(57);
        arb.enqueue(58);
        arb.enqueue(5333);
        arb.dequeue();
        arb.enqueue(222);


    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
