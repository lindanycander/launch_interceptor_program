import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

import com.decide.LaunchInterceptor;
import com.decide.LaunchInterceptor.ParameterRecord;

/**
 * Unit tests for the LaunchInterceptor class.
 */
public class TestLic {
    /**
     * Tests the lic0 method with input variables that should return true.
     */
    @Test
    void testLic0_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 3;
        double[][] points = { { 0, 3 }, { 1, 5 }, { 3, 8 } };
        double length1 = 3;
        ParameterRecord parameters = new ParameterRecord(length1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic0());
    }

    /**
     * Tests the lic0 method with input variables that should return false.
     */
    @Test
    void testLic0_false() {
        // Case 2, we know to be false according to input variables
        int numpoints = 3;
        double[][] points = { { -2, 3 }, { 1, -5 }, { -3, 8 } };
        double length1 = 50;
        ParameterRecord parameters = new ParameterRecord(length1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic0());
    }

    /**
     * Tests the lic0 method with illegal input variables.
     */
    @Test
    void testLic0_illegalArg() {
        // Case 3, we know to be throw exception since the length is negative
        int numpoints = 3;
        double[][] points = { { 0, 3 }, { 1, 5 }, { 3, 8 } };
        double length1 = -0.1;
        ParameterRecord parameters = new ParameterRecord(length1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic0());
    }

    /**
     * Tests the lic1 method with points within a circle, expecting false.
     */
    @Test
    void testLic1_withinCircle_false() {
        // Case 1, we know to be false according to input variables
        int numpoints = 3;
        double[][] points = { { 0, 0 }, { 1, 0 }, { 0.5, Math.sqrt(0.5) } };
        double radius1 = 1.0;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic1());
    }

    /**
     * Tests the lic1 method with points outside a circle, expecting true.
     */
    @Test
    void testLic1_outsideCircle_true() {
        // Case 2, we know to be true according to input variables
        int numpoints = 3;
        double[][] points = { { 0, 0 }, { 2, 0 }, { 1, Math.sqrt(0.5) } };
        double radius1 = 1.0;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic1());
    }

    /**
     * Tests the lic1 method with less than three points, expecting false.
     */
    @Test
    void testLic1_lessThanThreePoints_false() {
        // Case 3, we know to be false since there are too few points
        int numpoints = 2;
        double[][] points = { { 0, 0 }, { 1, 1 } };
        double radius1 = 1.0;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic1());
    }

    /**
     * Tests the lic1 method with points on a circle, expecting false.
     */
    @Test
    void testLic1_onCircle_false() {
        // Case 4, we know to be false according to input variables
        int numpoints = 3;
        double[][] points = { { 1, 0 }, { 0, 1 }, { -1, 0 } };
        double radius1 = 1.0;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic1());
    }

    /**
     * Tests the lic1 method with more than three points, expecting true.
     */
    @Test
    void testLic1_moreThanThreePoints_true() {
        // Case 5, we know to be true according to input variables
        int numpoints = 4;
        double[][] points = { { 0, 0 }, { 2, 0 }, { 1, Math.sqrt(3) }, { 0, 2 } };
        double radius1 = 1.0;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic1());
    }

    /**
     * Tests the lic1 method with more than three points, expecting true.
     */
    @Test
    void testLic1_illegalArg() {
        // Case 6, we know to throw exception since the radius is negative
        int numpoints = 4;
        double[][] points = { { 0, 0 }, { 2, 0 }, { 1, Math.sqrt(3) }, { 0, 2 } };
        double radius1 = -0.1;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic1());
    }

    /**
     * Tests the lic2 method with input variables that should return true.
     */
    @Test
    void testLic2_lessThanPi_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 3;
        double[][] points = { { 0, 5 }, { 0, 0 }, { 5, 0 } };
        double epsilon = 0.3;
        ParameterRecord parameters = new ParameterRecord(0, 0, epsilon, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic2());
    }

    /**
     * Tests the lic2 method with input variables that should return true.
     */
    @Test
    void testLic2_greaterThanPi_true() {
        // Case 2, we know to be true according to input variables
        int numpoints = 3;
        double[][] points = { { -1, -1 }, { 0, 0 }, { 1, 0 } };
        double epsilon = 0.2;
        ParameterRecord parameters = new ParameterRecord(0, 0, epsilon, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic2());
    }

    /**
     * Tests the lic2 method with input variables that should return false.
     */
    @Test
    void testLic2_false() {
        // Case 3, we know to be false according to input variables
        int numpoints = 3;
        double[][] points = { { 0, 0.5 }, { 0, 0 }, { 0.5, 0 } };
        double epsilon = 2;
        ParameterRecord parameters = new ParameterRecord(0, 0, epsilon, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic2());
    }

    /**
     * Tests the lic2 method with input variables that should return false (skip).
     */
    @Test
    void testLic2_skip_false() {
        // Case 4, we know to be false because one point is equal to the vertex-point
        int numpoints = 3;
        double[][] points = { { 0, 0 }, { 0, 0 }, { 1, 0 } };
        double epsilon = 1;
        ParameterRecord parameters = new ParameterRecord(0, 0, epsilon, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic2());
    }

    /**
     * Tests the lic2 method with input variables that should return false, parallel
     * vectors.
     */
    @Test
    void testLic2_parallel_false() {
        // Case 5, we know to be false since the vectors are parallel
        int numpoints = 3;
        double[][] points = { { 0, 0 }, { 2, 0 }, { 1, 0 } };
        double epsilon = 1;
        ParameterRecord parameters = new ParameterRecord(0, 0, epsilon, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic2());
    }

    /**
     * Tests the lic2 method with input variables that should cause an exception.
     */
    @Test
    void testLic2_illegalArg() {
        // Case 6, we know to throw exception since epsilon is negative
        int numpoints = 3;
        double[][] points = { { -1, -1 }, { 0, 0 }, { 1, 0 } };
        double epsilon = -0.2;
        ParameterRecord parameters = new ParameterRecord(0, 0, epsilon, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic2());
    }

    /**
     * Tests the lic3 method with input variables that should return true.
     */
    @Test
    void testLic3_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 3;
        double[][] points = { { -2, 3 }, { 1, -5 }, { -3, 8 } };
        double area1 = 1;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, area1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic3());
    }

    /**
     * Tests the lic3 method with input variables that should return false.
     */
    @Test
    void testLic3_false() {
        // Case 2, we know to be false according to input variables
        int numpoints = 3;
        double[][] points = { { -2, 3 }, { 1, -5 }, { -3, 8 } };
        double area1 = 50;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, area1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic3());
    }

    /**
     * Tests the lic3 method with input variables that should cause an exception.
     */
    @Test
    void testLic3_illegalArg() {
        // Case 3, we know to throw exception since the area is negative
        int numpoints = 3;
        double[][] points = { { -2, 3 }, { 1, -5 }, { -3, 8 } };
        double area1 = -1;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, area1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic3());
    }

    /**
     * Tests the lic4 method with input variables that should return true.
     */
    @Test
    void testLic4_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 3;
        double[][] points = { { -1, 1 }, { 2, 2 }, { 3, -1 } };
        int q_pts = 3;
        int quads = 2;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, q_pts, quads, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic4());
    }

    /**
     * Tests the lic4 method with input variables that should return false.
     */
    @Test
    void testLic4_false() {
        // Case 2, we know to be false according to input variables
        int numpoints = 3;
        double[][] points = { { 2, 1 }, { -1, 1 }, { 2, 0 } };
        int q_pts = 3;
        int quads = 2;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 1, q_pts, quads, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic4());
    }

    /**
     * Tests the lic4 method with input variables that handle a corner case,
     * expecting false.
     */
    @Test
    void testLic4_boundaries() {
        // Case 3, checks a special case (the bounderies), we know to be false
        // according to input variables
        int numpoints = 4;
        double[][] points = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int q_pts = 3;
        int quads = 3;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 1, q_pts, quads, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic4());
    }

    /**
     * Tests the lic4 method with input variables that should cause an exception.
     */
    @Test
    void testLic4_illegalArg() {
        // Case 4, we know to throw exception since the q_pts is less than 2
        int numpoints = 3;
        double[][] points = { { -1, 1 }, { 2, 2 }, { 3, -1 } };
        int q_pts = 1;
        int quads = 2;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, q_pts, quads, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic4());
    }

    /**
     * Tests the lic5 method with input variables that should return true.
     */
    @Test
    void testLic5_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 1, 1 }, { 1.5, 5 }, { 5, -3 }, { 3, 1.2 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic5());
    }

    /**
     * Tests the lic5 method with input variables that should return false.
     */
    @Test
    void testLic5_false() {
        // Case 2, we know to be false according to input variables
        int numpoints = 5;
        double[][] points = { { -5, -3 }, { -3.2, 1 }, { 0.5, 2 }, { 2, 3 }, { 3, 5 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic5());
    }

    /**
     * Tests the lic5 method with input variables that we expect to be true.
     */
    @Test
    void testLic5_tooFewNumpoints_false() {
        // Case 3, we know to be false since there are too few points
        int numpoints = 1;
        double[][] points = { { 0, 0 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic5());
    }

    @Test
    void testLic6_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 3;
        double[][] points = { { 0, 0 }, { 1, 1 }, { 2, 0 } };
        double distance = 0.9;
        int n_pts = 3;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, n_pts, distance, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic6());
    }

    /**
     * Tests the lic6 method with input variables that we expect to be false.
     */
    @Test
    void testLic6_false() {
        // Case 2, we know to be false according to input variables
        int numpoints = 6;
        double[][] points = { { 0, -1 }, { 0.5, 2 }, { 1, 0 }, { 0.5, -0.5 }, { 0, -0.5 }, { 0.5, 0 } };
        double distance = 2;
        int n_pts = 3;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, n_pts, distance, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic6());
    }

    /**
     * Tests the lic6 method with input variables that should cause an exception.
     */
    @Test
    void testLic6_illegalArg() {
        // Case 3, we know to throw exception since the distance is negative
        int numpoints = 3;
        double[][] points = { { 0, 0 }, { 1, 1 }, { 2, 0 } };
        double distance = -0.9;
        int n_pts = 3;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, n_pts, distance, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic6());
    }

    /**
     * Tests the lic7 method with input variables that should return true.
     */
    @Test
    void testLic7_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 3;
        double[][] points = { { -2, 3 }, { 1, -5 }, { -3, 8 } };
        int k_pts = 1;
        double length1 = 1;
        ParameterRecord parameters = new ParameterRecord(length1, 0, 0, 0, 0, 0, 0, 0, k_pts, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic7());
    }

    /**
     * Tests the lic7 method with input variables that should return false.
     */
    @Test
    void testLic7_false() {
        // Case 2, we know to be false according to input variables
        int numpoints = 3;
        double[][] points = { { 1, 5 }, { 0, 0 }, { 1, 1 } };
        int k_pts = 1;
        int length1 = 5;
        ParameterRecord parameters = new ParameterRecord(length1, 0, 0, 0, 0, 0, 0, 0, k_pts, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic7());
    }

    /**
     * Tests the lic7 method with input variables that should cause an exception.
     */
    @Test
    void testLic7_illegalArg() {
        // Case 3, we know to throw exception since k_pts is greater than NUMPOINTS - 2
        int numpoints = 3;
        double[][] points = { { -2, 3 }, { 1, -5 }, { -3, 8 } };
        int k_pts = 2;
        int length1 = 1;
        ParameterRecord parameters = new ParameterRecord(length1, 0, 0, 0, 0, 0, 0, 0, k_pts, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic7());
    }

    /**
     * Tests the lic8 method with input variables that should return true.
     */
    @Test
    void testLic8_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 5;
        double[][] points = { { 0, 2 }, { 3, 15 }, { 0, 0 }, { -5, -5 }, { 2, 0 } };
        double radius1 = 0.5;
        int a_pts = 1;
        int b_pts = 1;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, a_pts, b_pts, 0, 0, 0, 0, 0,
                0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic8());
    }

    /**
     * Tests the lic8 method with input variables that should return false (the
     * points are on a line).
     */
    @Test
    void testLic8_onLine_false() {
        // Case 2, we know to be false according to input variables (the points are on a
        // line)
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 } };
        double radius1 = 3;
        int a_pts = 1;
        int b_pts = 1;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, a_pts, b_pts, 0, 0, 0, 0, 0,
                0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic8());
    }

    /**
     * Tests the lic8 method with input variables that should return false.
     */
    @Test
    void testLic8_false() {
        // Case 3, we know to be false according to input variables
        int numpoints = 6;
        double[][] points = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 }, { -1, 0 }, { -1, -1 } };
        double radius1 = 2;
        int a_pts = 1;
        int b_pts = 1;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, a_pts, b_pts, 0, 0, 0, 0, 0,
                0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic8());
    }

    /**
     * Tests the lic8 method with input variables that should cause an exception.
     */
    @Test
    void testLic8_illegalArg() {
        // Case 4, we know to throw exception since the sum of a_pts and b_pts is
        // greater than NUMPOINTS - 3
        int numpoints = 5;
        double[][] points = { { 0, 2 }, { 3, 15 }, { 0, 0 }, { -5, -5 }, { 2, 0 } };
        double radius1 = 0.5;
        int a_pts = 1;
        int b_pts = 2;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, a_pts, b_pts, 0, 0, 0, 0, 0,
                0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic8());
    }

    /**
     * Tests the lic9 method with input variables that should return true.
     */
    @Test
    void testLic9_less_than_PI_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 12;
        double[][] points = { { 0, 5 }, { 0, 0 }, { 5, 0 }, { 0, 5 }, { 0, 0 }, { 5, 0 }, { 0, 5 }, { 0, 0 }, { 5, 0 },
                { 0, 5 }, { 0, 0 }, { 5, 0 } };
        double epsilon = 0.2;
        int c_pts = 3;
        int d_pts = 3;
        ParameterRecord parameters = new ParameterRecord(0, 0, epsilon, 0, 0, 0, 0, 0, 0, 0, 0, c_pts, d_pts, 0, 0, 0,
                0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic9());
    }

    /**
     * Tests the lic9 method with input variables that should return true.
     */
    @Test
    void testLic9_greater_than_PI_true() {
        // Case 2, we know to be true according to input variables
        int numpoints = 12;
        double[][] points = { { -1, -1 }, { 0, 0 }, { 1, 0 }, { -1, -1 }, { 0, 0 }, { 1, 0 }, { -1, -1 }, { 0, 0 },
                { 1, 0 }, { -1, -1 }, { 0, 0 }, { 1, 0 } };
        double epsilon = 0.2;
        int c_pts = 3;
        int d_pts = 3;
        ParameterRecord parameters = new ParameterRecord(0, 0, epsilon, 0, 0, 0, 0, 0, 0, 0, 0, c_pts, d_pts, 0, 0, 0,
                0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic9());
    }

    /**
     * Tests the lic9 method with input variables that should return false.
     */
    @Test
    void testLic9_false() {
        // Case 3, we know to be false according to input variables
        int numpoints = 12;
        double[][] points = { { 0, 5 }, { 0, 0 }, { 5, 0 }, { 0, 5 }, { 0, 0 }, { 5, 0 }, { 0, 5 }, { 0, 0 }, { 5, 0 },
                { 0, 5 }, { 0, 0 }, { 5, 0 } };
        double epsilon = 0.2;
        int c_pts = 5;
        int d_pts = 1;
        ParameterRecord parameters = new ParameterRecord(0, 0, epsilon, 0, 0, 0, 0, 0, 0, 0, 0, c_pts, d_pts, 0, 0, 0,
                0, 0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic9());
    }

    /**
     * Tests the lic9 method with input variables that should cause an exception.
     */
    @Test
    void testLic9_illegalArg() {
        // Case 4, we know to throw exception since the sum of c_pts and d_pts is
        // greater than NUMPOINTS - 3
        int numpoints = 12;
        double[][] points = { { 0, 5 }, { 0, 0 }, { 5, 0 }, { 0, 5 }, { 0, 0 }, { 5, 0 }, { 0, 5 }, { 0, 0 }, { 5, 0 },
                { 0, 5 }, { 0, 0 }, { 5, 0 } };
        double epsilon = 0.2;
        int c_pts = 3;
        int d_pts = 7;
        ParameterRecord parameters = new ParameterRecord(0, 0, epsilon, 0, 0, 0, 0, 0, 0, 0, 0, c_pts, d_pts, 0, 0, 0,
                0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic9());
    }

    /**
     * Tests the lic10 method with input variables that should return true.
     */
    @Test
    void testLic10_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 6;
        double[][] points = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 2, 0 }, { 0, 0 }, { 0, 6 } };
        double area1 = 1;
        int e_pts = 2;
        int f_pts = 1;
        ParameterRecord paramters = new ParameterRecord(0, 0, 0, area1, 0, 0, 0, 0, 0, 0, 0, 0, 0, e_pts, f_pts, 0, 0,
                0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, paramters, lcm, puv);
        assertTrue(lic.lic10());
    }

    /**
     * Tests the lic10 method with input variables that should return false.
     */
    @Test
    void testLic10_false_too_large_AREA1() {
        // Case 2, we know to be false according to input variables
        int numpoints = 6;
        double[][] points = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 2, 0 }, { 0, 0 }, { 0, 6 } };
        double area1 = 10;
        int e_pts = 2;
        int f_pts = 1;
        ParameterRecord paramters = new ParameterRecord(0, 0, 0, area1, 0, 0, 0, 0, 0, 0, 0, 0, 0, e_pts, f_pts, 0, 0,
                0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, paramters, lcm, puv);
        assertFalse(lic.lic10());
    }

    /**
     * Tests the lic10 method with input variables that should return false.
     */
    @Test
    void testLic10_false_to_few_numpoints_compared_to_E_F_PTS() {
        // Case 3, we know to throw exception since the number of points is less than
        int numpoints = 6;
        double[][] points = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 2, 0 }, { 0, 0 }, { 0, 6 } };
        double area1 = 1;
        int e_pts = 2;
        int f_pts = 2;
        ParameterRecord paramters = new ParameterRecord(0, 0, 0, area1, 0, 0, 0, 0, 0, 0, 0, 0, 0, e_pts, f_pts, 0, 0,
                0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, paramters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic10());
    }

    /**
     * Tests the lic10 method with input variables that should cause an exception.
     */
    @Test
    void testLic10_illegalArg() {
        // Case 4, we know to throw exception since the area is negative
        int numpoints = 6;
        double[][] points = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 2, 0 }, { 0, 0 }, { 0, 6 } };
        double area1 = -1;
        int e_pts = 2;
        int f_pts = 1;
        ParameterRecord paramters = new ParameterRecord(0, 0, 0, area1, 0, 0, 0, 0, 0, 0, 0, 0, 0, e_pts, f_pts, 0, 0,
                0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, paramters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic10());
    }

    /**
     * Tests the lic11 method with input variables that should return false.
     */
    @Test
    void testLic11_false() {
        // Case 1, we know to be false according to input variables
        int numpoints = 4;
        double[][] points = { { 0, 0 }, { 1, 1 }, { 2, 2 }, { 3, 3 } };
        int g_pts = 2;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, g_pts, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic11());
    }

    /**
     * Tests the lic11 method with input variables that should return true.
     */
    @Test
    void testLic11_true() {
        // Case 2, we know to be true according to input variables
        int numpoints = 5;
        double[][] points = { { 0, 2 }, { 5, 0 }, { 9, 3 }, { 7, 0 }, { 4, -3 } };
        int g_pts = 2;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, g_pts, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic11());
    }

    /**
     * Tests the lic11 method with input variables that should cause an exception.
     */
    @Test
    void testLic11_illegalArg() {
        // Case 3, we know to throw exception since the g_pts is greater than
        // NUMPOINTS - 2
        int numpoints = 5;
        double[][] points = { { 0, 2 }, { 5, 0 }, { 9, 3 }, { 7, 0 }, { 4, -3 } };
        int g_pts = 4;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, g_pts, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic11());
    }

    /**
     * Tests the lic12 method with input variables that should return true.
     */
    @Test
    void testLic12_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 5;
        double[][] points = { { 0, 2 }, { 3, 3 }, { -1, 2 }, { 0, 0 }, { -1, -1 } };
        double length1 = 1.5;
        double length2 = 3;
        int k_pts = 2;
        ParameterRecord parameters = new ParameterRecord(length1, 0, 0, 0, 0, 0, 0, 0, k_pts, 0, 0, 0, 0, 0, 0, 0,
                length2, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic12());
    }

    /**
     * Tests the lic12 method with input variables that should return false.
     */
    @Test
    void testLic12_false() {
        // Case 2, we know to be false according to input variables
        int numpoints = 5;
        double[][] points = { { 0, 2 }, { 0, 0.5 }, { 0, 0.2 }, { 0, 0 }, { 0, 0.2 } };
        double length1 = 2;
        double length2 = 2.01;
        int k_pts = 2;
        ParameterRecord parameters = new ParameterRecord(length1, 0, 0, 0, 0, 0, 0, 0, k_pts, 0, 0, 0, 0, 0, 0, 0,
                length2, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic12());
    }

    /**
     * Tests the lic12 method with input variables that should cause an exception.
     */
    @Test
    void testLic12_illegalArg() {
        // Case 3, we know to throw exception since length1 is negative
        int numpoints = 5;
        double[][] points = { { 0, 2 }, { 3, 3 }, { -1, 2 }, { 0, 0 }, { -1, -1 } };
        double length1 = -1.5;
        double length2 = 3;
        int k_pts = 2;
        ParameterRecord parameters = new ParameterRecord(length1, 0, 0, 0, 0, 0, 0, 0, k_pts, 0, 0, 0, 0, 0, 0, 0,
                length2, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic12());
    }

    /**
     * Tests the lic13 method with input variables that should return true.
     */
    @Test
    void testLic13_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 5;
        double[][] points = { { 0, 2 }, { 3, 15 }, { 0, 0 }, { -5, -5 }, { 2, 0 } };
        double radius1 = 0.5;
        double radius2 = 2;
        int a_pts = 1;
        int b_pts = 1;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, a_pts, b_pts, 0, 0, 0, 0, 0,
                0, radius2, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic13());
    }

    /**
     * Tests the lic13 method with input variables that should return false (the
     * points are on a line).
     */
    @Test
    void testLic13_onLine_false() {
        // Case 2, we know to be false according to input variables (the points are on a
        // line)
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 } };
        double radius1 = 3;
        double radius2 = 2;
        int a_pts = 1;
        int b_pts = 1;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, a_pts, b_pts, 0, 0, 0, 0, 0,
                0, radius2, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic13());
    }

    /**
     * Tests the lic13 method with input variables that should return false.
     */
    @Test
    void testLic13_false() {
        // Case 3, we know to be false according to input variables
        int numpoints = 6;
        double[][] points = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 }, { -1, 0 }, { -1, -1 } };
        double radius1 = 2;
        double radius2 = 0.5;
        int a_pts = 1;
        int b_pts = 1;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, a_pts, b_pts, 0, 0, 0, 0, 0,
                0, radius2, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic13());
    }

    /**
     * Tests the lic13 method with input variables that should cause an exception.
     */
    @Test
    void testLic13_illegalArg() {
        // Case 4, we know to throw expetion since the sum of a_pts and b_pts is greater
        // than NUMPOINTS - 3
        int numpoints = 5;
        double[][] points = { { 0, 2 }, { 3, 15 }, { 0, 0 }, { -5, -5 }, { 2, 0 } };
        double radius1 = 0.5;
        double radius2 = 2;
        int a_pts = 1;
        int b_pts = 2;
        ParameterRecord parameters = new ParameterRecord(0, radius1, 0, 0, 0, 0, 0, 0, 0, a_pts, b_pts, 0, 0, 0, 0, 0,
                0, radius2, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic13());
    }

    /**
     * Tests the lic14 method with input variables that should return true.
     */
    @Test
    void testLic14_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0.5, 0.5 }, { 2, 0 }, { -0.5, 0 }, { 0, 2 } };
        int e_pts = 1;
        int f_pts = 1;
        double area1 = 0.1;
        double area2 = 5;
        ParameterRecord parameters = new ParameterRecord(1, 0, 0, area1, 0, 0, 0, 0, 0, 0, 0, 0, 0, e_pts, f_pts, 0, 0,
                0, area2);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic14());
    }

    /**
     * Tests the lic14 method with input variables that should return false.
     */
    @Test
    void testLic14_false() {
        // Case 2, we know to be false according to input variables
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0.5, 0.5 }, { 2, 0 }, { -0.5, 0 }, { 0, 2 } };
        int e_pts = 1;
        int f_pts = 1;
        double area1 = 2;
        double area2 = 2;
        ParameterRecord parameters = new ParameterRecord(1, 0, 0, area1, 0, 0, 0, 0, 0, 0, 0, 0, 0, e_pts, f_pts, 0, 0,
                0, area2);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic14());
    }

    /**
     * Tests the lic14 method with input variables that should cause an exception.
     */
    @Test
    void testLic14_illegalArg() {
        // Case 3, we know to throw exception since area1 is negative
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0.5, 0.5 }, { 2, 0 }, { -0.5, 0 }, { 0, 2 } };
        int e_pts = 1;
        int f_pts = 1;
        double area1 = -0.1;
        double area2 = 5;
        ParameterRecord parameters = new ParameterRecord(1, 0, 0, area1, 0, 0, 0, 0, 0, 0, 0, 0, 0, e_pts, f_pts, 0, 0,
                0, area2);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertThrows(IllegalArgumentException.class, () -> lic.lic14());
    }
     
    @Test
    void testCMV_correct() {
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0, -1 }, { 1, 1 }, { 1, 0 }, { 0.5, 0 } };
            double length1 = 0.5;
        double radius1 = 0.5;
        double area1 = 0.5;
        int epsilon = 0;
        ParameterRecord parameters = new ParameterRecord(length1, radius1, epsilon, area1, 2, 2, 4, 0, 2, 1, 1, 1, 1, 1,
                   1, 1, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor cmv = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(cmv.CMV()[2]);
    }

    @Test
    void testPUM_correct() {
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0, -1 }, { 1, 1 }, { 1, 0 }, { 0.5, 0 } };
        double length1 = 0.5;
        double radius1 = 0.5;
        double area1 = 0.25;
        int epsilon = 0;
        ParameterRecord parameters = new ParameterRecord(length1, radius1, epsilon, area1, 2, 2, 4, 0, 2, 1, 1,
                        1, 1, 1,
                        1, 1, 0, 0, 0);
        String[][] lcm = {
                        { "ANDD", "ANDD", "ORR", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ANDD", "ANDD", "ORR", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ORR", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ANDD", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" }
        };
        boolean[] puv = { true, true, true, true, false, false, false, false, false, false, false, false, false,
                        false,
                        false };
        LaunchInterceptor li = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        boolean[][] answer = {
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true } };
        assertArrayEquals(answer, li.PUM());
    }

    @Test
    void testPUM_error_lcm_not_right_input() {
        int numpoints = 4;
        double[][] points = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
        double length1 = 0.5;
        double radius1 = 0.5;
        double area1 = 0.25;
        double epsilon = 0;
        ParameterRecord parameters = new ParameterRecord(length1, radius1, epsilon, area1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1,1, 1, 1, 1, 1);
        String[][] lcm = {
                        { "AND", "ANDD", "ORR", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ANDD", "ANDD", "ORR", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ORR", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ANDD", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" }
        };
        boolean[] puv = { true, true, true, true, false, false, false, false, false, false, false, false, false,
                        false,
                        false };
        LaunchInterceptor li = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        boolean[][] answer = {
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true } };
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                li.PUM();
        });
    };

    @Test
    void testPUM_error_lcm_not_symmetrical() {
        int numpoints = 4;
        double[][] points = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
        double length1 = 0.5;
        double radius1 = 0.5;
        double area1 = 0.25;
        double epsilon = 0;
        ParameterRecord parameters = new ParameterRecord(length1, radius1, epsilon, area1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1,1, 1, 1, 1, 1);
        String[][] lcm = {
                        { "ANDD", "ANDD", "ORR", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED","NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ORR", "ANDD", "ORR", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ORR", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ANDD", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" }
        };
        boolean[] puv = { true, true, true, true, false, false, false, false, false, false, false, false, false,
                        false,
                        false };
        LaunchInterceptor li = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        boolean[][] answer = {
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true },
                        { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                                        true } };
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        li.PUM();
        });
    }

    /**
     * Tests that the FUV method returns expected true value.
     */
    @Test
    void testFUV_true() {
        // test case 1 that should be true, tests only lic0-lic3
        String[][] LCM = {
                { "ANDD", "ANDD", "ORR", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ANDD", "ANDD", "ORR", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ORR", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ANDD", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" }
        };
        boolean[] PUV = { true, true, true, true, false, false, false, false, false, false, false, false, false, false,
                false };
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 0.5, 0 } };
        double length1 = 0.5;
        double radius1 = 0.5;
        double area1 = 0.25;
        int epsilon = 0;
        // ParameterRecord parameters = new ParameterRecord(length1, radius1, epsilon,
        // area1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0,
        // 0, 0, 0, 0, 0);
        ParameterRecord parameters = new ParameterRecord(length1, radius1, epsilon, area1, 2, 2, 4, 0, 2, 1, 1, 1, 1, 1,
                1, 1, 0, 0, 0);
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, LCM, PUV);
        boolean[] answer = { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                true };
        assertArrayEquals(answer, lic.FUV());
    }

    /**
     * Tests that the FUV method returns expected false value.
     */
    @Test
    void testFUV_falseArea() {
        // Test case 2, should be true, but lic0 and lic2 are false.
        String[][] LCM = {
                        { "ANDD", "ANDD", "ORR", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ANDD", "ANDD", "ORR", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ORR", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ANDD", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED","NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" }
        };
        boolean[] PUV = { true, true, true, true, false, false, false, false, false, false, false, false, false,
                        false,
                        false };
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 0.5, 0 } };
        double length1 = 0.5;
        double radius1 = 0.5;
        double area1 = 10;
        int epsilon = 0;
        ParameterRecord parameters = new ParameterRecord(length1, radius1, epsilon, area1, 2, 2, 4, 0, 2, 1, 1, 1, 1, 1,
                1, 1, 0, 0, 0);
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, LCM, PUV);
        boolean[] answer = { false, true, false, false, true, true, true, true, true, true, true, true, true, true,
                true };
        assertArrayEquals(answer, lic.FUV());
    }

    @Test
    void testFUV_falsePoint() {
        // case 3 that is true but several elements of the FUV will be false
        String[][] LCM = {
                        { "ANDD", "ANDD", "ORR", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ANDD", "ANDD", "ORR", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ORR", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "ANDD", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                        { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" }
        };
        boolean[] PUV = { true, true, true, true, false, false, false, false, false, false, false, false, false,
                        false,
                        false };
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0, -0.1 }, { 0.1, 0.1 }, { 0.1, 0 }, { 0.5, 0 } };
        double length1 = 0.5;
        double radius1 = 0.5;
        double area1 = 10;
        int epsilon = 0;
        ParameterRecord parameters = new ParameterRecord(length1, radius1, epsilon, area1, 2, 2, 4, 0, 2, 1, 1, 1, 1, 1,
                1, 1, 0, 0, 0);
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, LCM, PUV);
        boolean[] answer = { false, false, false, false, true, true, true, true, true, true, true, true, true, true,
                true };
        assertArrayEquals(answer, lic.FUV());
    }

    @Test
    void testDecide_true(){
        // test case 1 that should be true 
        String[][] LCM = {
                { "ANDD", "ANDD", "ORR", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ANDD", "ANDD", "ORR", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ORR", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ANDD", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" }
        };
        boolean[] PUV = { true, true, true, true, false, false, false, false, false, false, false, false, false, false,
                false };
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 0.5, 0 } };
        double length1 = 0.5;
        double radius1 = 0.5;
        double area1 = 0.25;
        int epsilon = 0;
        ParameterRecord parameters = new ParameterRecord(length1, radius1, epsilon, area1, 2, 2, 4, 0, 2, 1, 1, 1, 1, 1,
                1, 1, 0, 0, 0);
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, LCM, PUV);
        assertTrue(lic.decide());
    }

    @Test 
    void testDecide_false_case2(){
        // test case 2 that should be false
        String[][] LCM = {
                { "ANDD", "ANDD", "ORR", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ANDD", "ANDD", "ORR", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ORR", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ANDD", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" }
        };
        boolean[] PUV = { true, true, true, true, false, false, false, false, false, false, false, false, false, false,
                false };
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0, -0.1 }, { 0.1, 0.1 }, { 0.1, 0 }, { 0.5, 0 } };
        double length1 = 0.5;
        double radius1 = 0.5;
        double area1 = 10;
        int epsilon = 0;
        ParameterRecord parameters = new ParameterRecord(length1, radius1, epsilon, area1, 2, 2, 4, 0, 2, 1, 1, 1, 1, 1,
                1, 1, 0, 0, 0);
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, LCM, PUV);
        assertFalse(lic.decide());
    }

    @Test
    void testDecide_false_case3(){
        // test case 3 that should be false
        String[][] LCM = {
                { "ANDD", "ANDD", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ANDD", "ANDD", "ORR", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ANDD", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "ANDD", "ORR", "ANDD", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" },
                { "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED",
                        "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED" }
        };
        boolean[] PUV = { true, true, true, true, false, false, false, false, false, false, false, false, false, false,
                false };
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 0.5, 0 } };
        double length1 = 0.5;
        double radius1 = 0.5;
        double area1 = 10;
        int epsilon = 0;
        ParameterRecord parameters = new ParameterRecord(length1, radius1, epsilon, area1, 2, 2, 4, 0, 2, 1, 1, 1, 1, 1,
                1, 1, 0, 0, 0);
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, LCM, PUV);
        assertFalse(lic.decide());
        };

}
