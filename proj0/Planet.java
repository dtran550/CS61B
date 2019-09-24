public class Planet {

    /** Static variable*/
    public static final double gravConstant = 6.67e-11;

    /** Instance variables for Planet object */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /** Constructor for a Planet object */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /** Constructor for a Planet object that takes in a planet and creates a
    copy */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /** Method that calculates the distance between two planets*/
    public double calcDistance(Planet p) {
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    /** Method that calculates the total force exerted by a planet*/
    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return (gravConstant * mass * p.mass) / (r * r);
    }

    /** Methods that calculates the force exerted by a planet in the x and y
    directions, respectively*/
    public double calcForceExertedByX(Planet p) {
        double F = calcForceExertedBy(p);
        double dx = p.xxPos - xxPos;
        double r = calcDistance(p);
        return F * dx / r;
    }

    public double calcForceExertedByY(Planet p) {
        double F = calcForceExertedBy(p);
        double dy = p.yyPos - yyPos;
        double r = calcDistance(p);
        return F * dy / r;
    }


    /** Methods that calculates the force exerted by a planet in the x and y
    directions, respectively. For loop and enhanced For loop utilized.*/
    public double calcNetForceExertedByX(Planet[] planets) {
        double netForceX = 0;
        int arrLength = planets.length;
        for (int x = 0; x < arrLength; x++) {
            if (this.equals(planets[x])) {
                continue;
            }
            else {
                netForceX += calcForceExertedByX(planets[x]);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double netForceY = 0;
        for (Planet p : planets) {
            if (this.equals(p)) {
                continue;
            }
            else {
                netForceY += calcForceExertedByY(p);
            }
        }
        return netForceY;
    }

    /** Method that calculates the acceleration of a planet, and updates the
    position and velocity of the planet, in the x and y vectors.*/
    public void update(double dt, double xForce, double yForce) {
        double xxAcc = xForce / mass;
        double yyAcc = yForce / mass;
        xxVel += xxAcc * dt;
        yyVel += yyAcc * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    /** Method that utilizes stdDraw in order to draw a planet at it's given
    position.*/
    public void draw() {
        String filename = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos , filename);
    }
}
