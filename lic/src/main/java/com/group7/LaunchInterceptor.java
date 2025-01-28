package com.group7;

public class LaunchInterceptor {

    // Define all global variables
    public int NUMPOINTS;
    public double[][] POINTS;

    public record ParameterRecord(double LENGTH1, double RADIUS1, double EPSILON, double AREA1, int Q_PTS, int QUADS,
            int N_PTS, double DIST, int K_PTS, int A_PTS, int B_PTS, int C_PTS, int D_PTS, int E_PTS, int F_PTS,
            int G_PTS, double LENGTH2, double RADIUS2, double AREA2) {

    }

    public ParameterRecord PARAMETERS;

    public String[][] LCM;
    public boolean[] PUV;

    /**
     * The constructor for the Launch_interceptor class.
     * 
     * @param numpoints  Number of points.
     * @param points     Array of points.
     * @param parameters Parameter record.
     * @param lcm        Launch criteria matrix.
     * @param puv        Preliminary unlocking vector.
     */
    public LaunchInterceptor(int numpoints, double[][] points, ParameterRecord parameters, String[][] lcm,
            boolean[] puv) {
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

    public boolean lic1() {
        // There exists at least one set of three consecutive data points that cannot
        // all be contained within or on a circle of radius RADIUS1.
        boolean state = false;

        double epsilon = 1e-9; // a small tolerance value for floating-point comparison

        // start on third point, compare with previous two points
        for (int i = 2; i < this.NUMPOINTS; i++) {
            double[] point1 = this.POINTS[i - 2];
            double[] point2 = this.POINTS[i - 1];
            double[] point3 = this.POINTS[i];

            // calculate the distance between the three points, forming the three lengths of
            // a triangle
            double a = Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
            double b = Math.sqrt(Math.pow(point2[0] - point3[0], 2) + Math.pow(point2[1] - point3[1], 2));
            double c = Math.sqrt(Math.pow(point3[0] - point1[0], 2) + Math.pow(point3[1] - point1[1], 2));

            // calculate the semiperimeter of the triangle using s = (a+b+c)/2
            double s = (a + b + c) / 2;

            // calculate the area of the circle using heron's formula
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

            // now we can calculcate the circumradius of the circle using the formula,
            // fetched from https://artofproblemsolving.com/wiki/index.php/Circumradius
            double circumradius = (a * b * c) / (4 * area);

            // if the circumradius is greater than the radius, the condition is met
            if (circumradius > this.PARAMETERS.RADIUS1 + epsilon) {
                state = true;
                break;
            }
        }
        return state;
    }

    public boolean lic3() {
        // There exists at least one set of three consecutive data points that are the
        // vertices of a triangle with area greater than AREA1
        boolean state = false;
        for (int i = 2; i < this.NUMPOINTS; i++) {
            double[] point1 = this.POINTS[i - 2];
            double[] point2 = this.POINTS[i - 1];
            double[] point3 = this.POINTS[i];
            // calculate the area between 3 points in 2d space
            double area = Math.abs(point1[0] * (point2[1] - point3[1]) + point2[0] * (point3[1] - point1[1])
                    + point3[0] * (point1[1] - point2[1])) / 2;
            if (area > this.PARAMETERS.AREA1) {
                state = true;
            }
        }
        return state;
    }

    public boolean lic4() {
        // There exists at least one set of Q_PTS consecutive data points that lie in
        // more than QUADS quadrants. Where there is ambiguity as to which quadrant
        // contains a given point, priority of decision will be by quadrant number,
        // i.e., I, II, III, IV. For example, the data point (0,0) is in quadrant I, the
        // point (-1,0) is in quadrant II, the point (0,-1) is in quadrant III, the
        // point (0,1) is in quadrant I and the point (1,0) is in quadrant I. (2 ≤ Q_PTS
        // ≤ NUMPOINTS), (1 ≤ QUADS ≤ 3)

        boolean state = false;

        // check that we have more than 2 points, Q_PTS is at least 2, and QUADS is at
        // least 1 and at most 3
        if (this.NUMPOINTS >= 2 && this.PARAMETERS.Q_PTS >= 2 && this.PARAMETERS.QUADS >= 1
                && this.PARAMETERS.QUADS <= 3) {

            // iterate over all points, start from 0 and go to NUMPOINTS
            for (int i = 0; i < this.NUMPOINTS; i++) {
                // create an array to store the count of points in each quadrant
                int[] quadrants = new int[4];

                // iterate over Q_PTS from this point and check the condition
                for (int j = 0; j < this.PARAMETERS.Q_PTS; j++) {
                    // calculate the quadrant of the point
                    double[] point = this.POINTS[(i + j) % this.NUMPOINTS];
                    int quadrant = 0;
                    if (point[0] >= 0 && point[1] >= 0) {
                        quadrant = 1;
                    } else if (point[0] < 0 && point[1] >= 0) {
                        quadrant = 2;
                    } else if (point[0] < 0 && point[1] < 0) {
                        quadrant = 3;
                    } else if (point[0] >= 0 && point[1] < 0) {
                        quadrant = 4;
                    }

                    // increment the count of the quadrant
                    quadrants[quadrant - 1]++;
                }

                // check if the number of quadrants is greater than QUADS
                int count = 0;
                for (int j = 0; j < 4; j++) {
                    if (quadrants[j] > 0) {
                        count++;
                    }
                }

                if (count > this.PARAMETERS.QUADS) {
                    state = true;
                    break;
                }
            }
        }

        return state;
    }

    public boolean lic2() {
        boolean state = false;
        for (int i = 2; i < this.NUMPOINTS; i++) {
            double[] point1 = this.POINTS[i - 2];
            double[] point2 = this.POINTS[i - 1];
            double[] point3 = this.POINTS[i];
            double[] vector1 = { point2[0] - point1[0], point2[1] - point1[1] };
            double[] vector2 = { point3[0] - point2[0], point3[1] - point2[1] };
            double dotProduct = vector1[0] * vector2[0] + vector1[1] * vector2[1];
            double magnitude1 = Math.sqrt(Math.pow(vector1[0], 2) + Math.pow(vector1[1], 2));
            double magnitude2 = Math.sqrt(Math.pow(vector2[0], 2) + Math.pow(vector2[1], 2));

            // Skip if either vector has zero magnitude
            if (magnitude1 == 0 || magnitude2 == 0) {
                continue;
            }
            // Skip if any point coincides the vertex
            if (point1[0] == point2[0] && point1[1] == point2[1] || point2[0] == point3[0] && point2[1] == point3[1]) {
                continue;
            }

            double angle = Math.acos(dotProduct / (magnitude1 * magnitude2));
            if (angle < (Math.PI - this.PARAMETERS.EPSILON) || angle > (Math.PI + this.PARAMETERS.EPSILON)) {
                state = true;
            }
        }
        return state;
    }

    // returns true if xj-xi<0 for two consecutive points (xi,yi), (xj,yj)
    public boolean lic5() {
        boolean state = false;
        for (int i = 1; i < this.NUMPOINTS; i++) {
            double[] point1 = this.POINTS[i - 1];
            double[] point2 = this.POINTS[i];
            if (point2[0] - point1[0] < 0) {
                state = true;
            }
        }
        return state;
    }

    public boolean lic6() {
        // If there is less than 3 points, return false
        if (this.NUMPOINTS < 3) {
            return false;
        }
        for (int i = this.PARAMETERS.N_PTS - 1; i < this.NUMPOINTS; i++) {
            // Check distance between each point between the first and last point within a
            // sequence of N_PTS points
            int firstPointIndex = i - this.PARAMETERS.N_PTS + 1;
            double[] firstPoint = this.POINTS[firstPointIndex];
            double[] lastPoint = this.POINTS[i];
            double[] vector = { lastPoint[0] - firstPoint[0], lastPoint[1] - firstPoint[1] };

            for (int j = 1; j < this.PARAMETERS.N_PTS - 1; j++) {
                // Calculate distance between the vector and each point between the first
                // and last point.
                double[] point = this.POINTS[firstPointIndex + j];
                double a = vector[0];
                double b = -vector[1];
                double c = -firstPoint[0] * vector[1] + firstPoint[1] * vector[0];
                double distance = Math.abs(a * point[0] + b * point[1] + c)
                        / Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

                // If the distance is greater than the distance parameter, return true
                if (distance > this.PARAMETERS.DIST) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean lic7() {
        // There exists at least one set of two data points separated by exactly K PTS
        // consecutive intervening points that are a distance greater than the length,
        // LENGTH1, apart. The condition
        // is not met when NUMPOINTS < 3.
        // 1 ≤ K PTS ≤ (NUMPOINTS−2)
        boolean state = false;
        if (this.NUMPOINTS >= 3 && this.PARAMETERS.K_PTS >= 1 && this.PARAMETERS.K_PTS <= this.NUMPOINTS - 2) {
            for (int i = this.PARAMETERS.K_PTS; i < this.NUMPOINTS; i++) {
                double[] point1 = this.POINTS[i - this.PARAMETERS.K_PTS];
                double[] point2 = this.POINTS[i];
                // calculate the euclidian distance between two points
                double distance = Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
                if (distance > this.PARAMETERS.LENGTH1) {
                    state = true;
                }
            }
        }
        return state;
    }

    public boolean lic9() {
        boolean state = false;

        if (this.NUMPOINTS >= 5 && this.PARAMETERS.C_PTS >= 1 && this.PARAMETERS.D_PTS >= 1
                && this.PARAMETERS.C_PTS + this.PARAMETERS.D_PTS <= this.NUMPOINTS - 3) {
            int lastPointIndex = this.PARAMETERS.C_PTS + this.PARAMETERS.D_PTS + 2;
            for (int i = lastPointIndex; i < this.NUMPOINTS; i++) {
                double[] point1 = this.POINTS[i - lastPointIndex];
                double[] point2 = this.POINTS[i - this.PARAMETERS.D_PTS - 1];
                double[] point3 = this.POINTS[i];
                double[] vector1 = { point2[0] - point1[0], point2[1] - point1[1] };
                double[] vector2 = { point3[0] - point2[0], point3[1] - point2[1] };
                double dotProduct = vector1[0] * vector2[0] + vector1[1] * vector2[1];
                double magnitude1 = Math.sqrt(Math.pow(vector1[0], 2) + Math.pow(vector1[1], 2));
                double magnitude2 = Math.sqrt(Math.pow(vector2[0], 2) + Math.pow(vector2[1], 2));

                // Skip if either vector has zero magnitude
                if (magnitude1 == 0 || magnitude2 == 0) {
                    continue;
                }
                // Skip if any point coincides the vertex
                if (point1[0] == point2[0] && point1[1] == point2[1]
                        || point2[0] == point3[0] && point2[1] == point3[1]) {
                    continue;
                }

                double angle = Math.acos(dotProduct / (magnitude1 * magnitude2));
                if (angle < (Math.PI - this.PARAMETERS.EPSILON) || angle > (Math.PI + this.PARAMETERS.EPSILON)) {
                    state = true;
                }
            }
        }

        return state;
    }

    // Check if there exists two points with G_PTS number of points inbetween such
    // that xi>xj and i<j
    public boolean lic11() {
        boolean state = false;
        if (this.NUMPOINTS < 3) {
            return state;
        }
        if (this.PARAMETERS.G_PTS + 2 > this.NUMPOINTS) {
            return state;
        } else {
            for (int i = 0; i < this.NUMPOINTS - this.PARAMETERS.G_PTS - 1; i++) {
                double[] point1 = this.POINTS[i];
                double[] point2 = this.POINTS[i + this.PARAMETERS.G_PTS + 1];
                if (point1[0] > point2[0]) {
                    state = true;
                }
            }
        }
        return state;
    }

    public boolean lic12() {
        if (this.NUMPOINTS < 3) {
            return false;
        }
        boolean distanceGreaterThanLength = false;
        boolean distanceLessThanLength = false;
        int secondPointIndex = this.PARAMETERS.K_PTS + 1;
        for (int i = secondPointIndex; i < this.NUMPOINTS; i++) {
            double[] point1 = this.POINTS[i - secondPointIndex];
            double[] point2 = this.POINTS[i];
            double distance = Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));

            if (distance > this.PARAMETERS.LENGTH1) {
                distanceGreaterThanLength = true;
            }
            if (distance < this.PARAMETERS.LENGTH2) {
                distanceLessThanLength = true;
            }

            // If both conditions are met, for some points, return true
            if (distanceGreaterThanLength && distanceLessThanLength) {
                return true;
            }
        }
        return false;
    }

    public boolean lic13() {
        if (this.NUMPOINTS < 5) {
            return false;
        }
        boolean notWithinRadius1 = false;
        boolean withinRadius2 = false;
        int lastPointIndex = this.PARAMETERS.A_PTS + this.PARAMETERS.B_PTS + 2;
        for (int i = lastPointIndex; i < this.NUMPOINTS; i++) {
            double[] point1 = this.POINTS[i - lastPointIndex];
            double[] point2 = this.POINTS[i - this.PARAMETERS.B_PTS - 1];
            double[] point3 = this.POINTS[i];

            // Calculate the sides of the triangle
            double a = Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
            double b = Math.sqrt(Math.pow(point3[0] - point2[0], 2) + Math.pow(point3[1] - point2[1], 2));
            double c = Math.sqrt(Math.pow(point1[0] - point3[0], 2) + Math.pow(point1[1] - point3[1], 2));

            // Calculate the area of the triangle
            double area = Math.abs(point1[0] * (point2[1] - point3[1]) + point2[0] * (point3[1] - point1[1])
                    + point3[0] * (point1[1] - point2[1])) / 2.0;

            // If the area is zero, the points are collinear, so the circumcircle radius is
            // infinite and therefore, we continue to next iteration. However, if the line
            // is shorter than the diameter of the circle, the points fit within the circle
            // and we return true.
            if (area == 0) {
                double maxLength = Math.max(Math.max(a, b), c) / 2;
                if (maxLength > this.PARAMETERS.RADIUS1 && maxLength <= this.PARAMETERS.RADIUS2) {
                    return true;
                }
                continue;
            }

            // Calculate the circumcircle radius using the formula from
            // https://artofproblemsolving.com/wiki/index.php/Circumradius
            double circumcircleRadius = (a * b * c) / (4 * area);

            if (circumcircleRadius > this.PARAMETERS.RADIUS1) {
                notWithinRadius1 = true;
            }
            if (circumcircleRadius <= this.PARAMETERS.RADIUS2) {
                withinRadius2 = true;
            }
            if (notWithinRadius1 && withinRadius2) {
                return true;
            }
        }
        return false;
    }

    public boolean lic14() {
        // There must be at least 5 points
        if (this.NUMPOINTS < 5) {
            return false;
        }
        boolean greaterThanArea1 = false;
        boolean lessThanArea2 = false;
        int point3Index = this.PARAMETERS.E_PTS + this.PARAMETERS.F_PTS + 2;
        for (int i = point3Index; i < this.NUMPOINTS; i++) {
            double[] point1 = this.POINTS[i - point3Index];
            double[] point2 = this.POINTS[i - this.PARAMETERS.F_PTS - 1];
            double[] point3 = this.POINTS[i];

            // Calculate the area between 3 points in 2d space
            double area = Math.abs(point1[0] * (point2[1] - point3[1]) + point2[0] * (point3[1] - point1[1])
                    + point3[0] * (point1[1] - point2[1])) / 2;
            if (area > this.PARAMETERS.AREA1) {
                greaterThanArea1 = true;
            }
            if (area < this.PARAMETERS.AREA2) {
                lessThanArea2 = true;
            }
            // If both conditions are met, return true, otherwise false
            if (greaterThanArea1 && lessThanArea2) {
                return true;
            }
        }
        return false;
    }

}
