/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("one");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("two");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("three");
        passed = checkSize(3, lld1.size()) && passed;

        lld1.addLast("four");
        passed = checkSize(4, lld1.size()) && passed;

        lld1.addLast("five");
        passed = checkSize(5, lld1.size()) && passed;

        lld1.addLast("six");
        passed = checkSize(6, lld1.size()) && passed;

        lld1.addLast("seven");
        passed = checkSize(7, lld1.size()) && passed;

        lld1.addLast("eight");
        passed = checkSize(8, lld1.size()) && passed;

        lld1.addLast("nine");
        passed = checkSize(9, lld1.size()) && passed;

        lld1.addLast("ten");
        passed = checkSize(10, lld1.size()) && passed;

        System.out.println(lld1.removeLast());
        System.out.println(lld1.removeLast());
        System.out.println(lld1.removeLast());
        System.out.println(lld1.removeLast());
        System.out.println(lld1.removeLast());
        System.out.println(lld1.removeLast());
        System.out.println(lld1.removeLast());
        System.out.println(lld1.removeLast());



        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);
        System.out.println("Testing get() function now... ");
        String str = lld1.get(0);
        System.out.println(str);
        str = lld1.get(1);
        System.out.println(str);
        str = lld1.get(2);
        System.out.println(str);
        str = lld1.get(3);
        System.out.println(str);


    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        Integer num = lld1.removeFirst();
        if (num == null) {
            System.out.println("Correctly skipping removeFirst");
        } else {
            passed = false;
        }
        num = lld1.removeLast();
        if (num == null) {
            System.out.println("Correctly skipping removeLast");
        } else {
            passed = false;
        }
        printTestStatus(passed);
    }



    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }
}