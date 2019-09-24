public class NBody {
    /** Method that reads a file and returns the radius of the universe*/
    public static double readRadius(String s) {
        In in = new In(s);
        int N = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /** Method that reads from a file, and returns an array of Planet objects
    with the specifications provided from file */
    public static Planet[] readPlanets(String s) {
        In in = new In(s);
        int N = in.readInt();
        Planet[] planets = new Planet[N];
        double radius = in.readDouble();
        for (int i = 0; i < N; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String planetName = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, planetName);
        }
        return planets;
    }

    public static void main(String args[]) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double r = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-r, r);
        StdDraw.picture(0, 0, "images/starfield.jpg");

        for (Planet p : planets) {
            p.draw();
        }

        StdDraw.enableDoubleBuffering();
        int N = planets.length;
        double varTime = 0;
        while (varTime < T) {
            double[] xForces = new double[N];
            double[] yForces = new double[N];
            for (int i = 0; i < N; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < N; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(5);
            varTime += dt;
        }
        System.out.println(N);
        System.out.println(r);
        for (int i = 0; i < N; i++) {
            System.out.printf("%-11.4e %11.4e %11.4e %11.4e %11.4e %12s%n", planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
