public class TestPlanet {
    public static void main(String args[]) {

        String x = "false";
        Planet sun = new Planet(10e12, 2 * 10e11, 0, 0, 2 * 10e30, x);
        Planet saturn = new Planet(2.3 * 10e12, 9.5 * 10e11, 0, 0, 6 * 10e26, x);

        System.out.println(sun.calcForceExertedBy(saturn));
    }
}
