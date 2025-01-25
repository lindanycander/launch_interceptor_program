package com.group7;

public class LaunchInterceptor {

    // Define all global variables
    public int NUMPOINTS;
    public double[][] POINTS;

    public record ParameterRecord(
            double LENGTH1,
            double RADIUS1,
            double EPSILON,
            double AREA1,
            int Q_PTS,
            int QUADS,
            int N_PTS,
            double DIST,
            int K_PTS,
            int A_PTS,
            int B_PTS,
            int C_PTS,
            int D_PTS,
            int E_PTS,
            int F_PTS,
            int G_PTS,
            double LENGTH2,
            double RADIUS2,
            double AREA2) {

    }
    public ParameterRecord PARAMETERS;

    public String[][] LCM;
    public boolean[] PUV;

    /**
     * The constructor for the Launch_interceptor class.
     * 
     * @param numpoints Number of points.
     * @param points Array of points.
     * @param parameters Parameter record.
     * @param lcm Launch criteria matrix.
     * @param puv Preliminary unlocking vector.
     */
    public LaunchInterceptor(int numpoints, double[][] points, ParameterRecord parameters, String[][] lcm, boolean[] puv) {
        this.NUMPOINTS = numpoints;
        this.POINTS = points;
        this.PARAMETERS = parameters;
        this.LCM = lcm;
        this.PUV = puv;
    }



    public static void main(String[] args) {
        System.out.println("Launch interceptor program!");
    }

    public boolean lic0() {
        boolean state = false;
        for (int i = 1; i < this.NUMPOINTS; i++) {
            double[] point1 = this.POINTS[i - 1];
            double[] point2 = this.POINTS[i];
            // calculate the euclidian distance between two points
            double distance = Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
            if (distance > this.PARAMETERS.LENGTH1) {
                state = true;
            }
        }
        return state;
    }
}
