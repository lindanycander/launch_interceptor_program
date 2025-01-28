import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.group7.LaunchInterceptor;
import com.group7.LaunchInterceptor.ParameterRecord;

public class TestLic {
    @Test
    void testLic0_true() {
        // Case 1, we know to be true according to input variables
        System.out.println("Test lic0");
        int numpoints = 3;
        double[][] points = { { 0, 3 }, { 1, 5 }, { 3, 8 } };
        ParameterRecord parameters = new ParameterRecord(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic0());
    }

    @Test
    void testLic0_false() {
        // Case 2, we know to be false according to input variables
        System.out.println("Test lic0");
        int numpoints = 3;
        double[][] points = { { -2, 3 }, { 1, -5 }, { -3, 8 } };
        ParameterRecord parameters = new ParameterRecord(50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic0());
    }

    @Test
    void testLic1_withinCircle_false() {
        int numpoints = 3;
        double[][] points = { { 0, 0 }, { 1, 0 }, { 0.5, Math.sqrt(0.5) } };
        ParameterRecord parameters = new ParameterRecord(0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic1());
    }

    @Test
    void testLic1_outsideCircle_true() {
        int numpoints = 3;
        double[][] points = { { 0, 0 }, { 2, 0 }, { 1, Math.sqrt(0.5) } };
        ParameterRecord parameters = new ParameterRecord(0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic1());
    }

    @Test
    void testLic1_lessThanThreePoints_false() {
        int numpoints = 2;
        double[][] points = { { 0, 0 }, { 1, 1 } };
        ParameterRecord parameters = new ParameterRecord(0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic1());
    }

    @Test
    void testLic1_onCircle_false() {
        int numpoints = 3;
        double[][] points = { { 1, 0 }, { 0, 1 }, { -1, 0 } };
        ParameterRecord parameters = new ParameterRecord(0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic1());
    }

    @Test
    void testLic1_moreThanThreePoints_true() {
        int numpoints = 4;
        double[][] points = { { 0, 0 }, { 2, 0 }, { 1, Math.sqrt(3) }, { 0, 2 } };
        ParameterRecord parameters = new ParameterRecord(0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic1());
    }

    @Test
    void testLic2_lessThanPi_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 3;
        double[][] points = { { 0, 5 }, { 0, 0 }, { 5, 0 } };
        ParameterRecord parameters = new ParameterRecord(3, 0, 0.3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic2());
    }

    @Test
    void testLic2_greaterThanPi_true() {
        // Case 2, we know to be true according to input variables
        int numpoints = 3;
        double[][] points = { { -1, -1 }, { 0, 0 }, { 1, 0 } };
        ParameterRecord parameters = new ParameterRecord(3, 0, 0.2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic2());
    }

    @Test
    void testLic2_false() {
        // Case 3, we know to be false according to input variables
        int numpoints = 3;
        double[][] points = { { 0, 0.5 }, { 0, 0 }, { 0.5, 0 } };
        ParameterRecord parameters = new ParameterRecord(3, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic2());
    }

    @Test
    void testLic2_skip_false() {
        // Case 4, we know to be false because one point is equal to the vertex-point
        int numpoints = 3;
        double[][] points = { { 0, 0 }, { 0, 0 }, { 1, 0 } };
        ParameterRecord parameters = new ParameterRecord(3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic2());
    }

    @Test
    void testLic2_parallel_false() {
        // Case 5, we know to be false since the vectors are parallel
        int numpoints = 3;
        double[][] points = { { 0, 0 }, { 2, 0 }, { 1, 0 } };
        ParameterRecord parameters = new ParameterRecord(3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic2());
    }

    @Test
    void testLic3_true() {
        // Case 1, we know to be true according to input variables
        System.out.println("Test lic3");
        int numpoints = 3;
        double[][] points = { { -2, 3 }, { 1, -5 }, { -3, 8 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic3());
    }

    @Test
    void testLic3_false() {
        // Case 2, we know to be false according to input variables
        System.out.println("Test lic3");
        int numpoints = 3;
        double[][] points = { { -2, 3 }, { 1, -5 }, { -3, 8 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic3());
    }

    @Test
    void testLic4_true() {
        // Case 1, we know to be true according to input variables
        int numpoints = 3;
        double[][] points = { { -1, 1 }, { 2, 2 }, { 3, -1 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic4());
    }

    @Test
    void testLic4_false() {
        // Case 2, we know to be false according to input variables
        int numpoints = 3;
        double[][] points = { { 2, 1 }, { -1, 1 }, { 2, 0 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic4());
    }

    @Test
    void testLic4_boundaries() {
        // Case 2, we know to be false according to input variables
        int numpoints = 4;
        double[][] points = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 1, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic4());
    }

    @Test
    void tistLic5_true() {
        int numpoints = 5;
        double[][] points = { { 0, 0 }, { 1, 1 }, { 1.5, 5 }, { 5, -3 }, { 3, 1.2 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic5());
    }

    @Test
    void tistLic5_false() {
        int numpoints = 5;
        double[][] points = { { -5, -3 }, { -3.2, 1 }, { 0.5, 2 }, { 2, 3 }, { 3, 5 } };
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
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 3, distance, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic6());
    }

    @Test
    void testLic6_false() {
        // Case 1, we know to be true according to input variables
        int numpoints = 6;
        double[][] points = { { 0, -1 }, { 0.5, 2 }, { 1, 0 }, { 0.5, -0.5 }, { 0, -0.5 }, { 0.5, 0 } };
        double distance = 2;
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 3, distance, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic6());
    }

    @Test
    void testLic7_true() {
        // We know to be true according to input variables
        System.out.println("Test lic7");
        int numpoints = 3;
        double[][] points = { { -2, 3 }, { 1, -5 }, { -3, 8 } };
        ParameterRecord parameters = new ParameterRecord(1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic7());
    }

    @Test
    void testLic7_false_to_few_NUMPOINTS() {
        // We know to be false according to input variables
        System.out.println("Test lic7");
        int numpoints = 2;
        double[][] points = { { 1, -5 }, { -3, 8 } };
        ParameterRecord parameters = new ParameterRecord(1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic7());
    }

    @Test
    void testLic7_false_K_PTS_greater_than_NUMPOINTS() {
        // We know to be false according to input variables
        System.out.println("Test lic7");
        int numpoints = 2;
        double[][] points = { { 1, -5 }, { -3, 8 } };
        ParameterRecord parameters = new ParameterRecord(1, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic7());
    }

    @Test
    void testLic8_true() {
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

    @Test
    void testLic8_onLine_false() {
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

    @Test
    void testLic8_false() {
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

    @Test
    void testLic9_less_than_PI_true() {
        System.out.println("Test lic9");
        int numpoints = 12;
        double[][] points = { { 0, 5 }, { 0, 0 }, { 5, 0 }, { 0, 5 }, { 0, 0 }, { 5, 0 }, { 0, 5 }, { 0, 0 }, { 5, 0 },
                { 0, 5 }, { 0, 0 }, { 5, 0 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0.2, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic9());
    }

    @Test
    void testLic9_greater_than_PI_true() {
        System.out.println("Test lic9");
        int numpoints = 12;
        double[][] points = { { -1, -1 }, { 0, 0 }, { 1, 0 }, { -1, -1 }, { 0, 0 }, { 1, 0 }, { -1, -1 }, { 0, 0 },
                { 1, 0 }, { -1, -1 }, { 0, 0 }, { 1, 0 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0.2, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic9());
    }

    @Test
    void testLic9_false() {
        System.out.println("Test lic9");
        int numpoints = 12;
        double[][] points = { { 0, 5 }, { 0, 0 }, { 5, 0 }, { 0, 5 }, { 0, 0 }, { 5, 0 }, { 0, 5 }, { 0, 0 }, { 5, 0 },
                { 0, 5 }, { 0, 0 }, { 5, 0 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0.2, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic9());
    }

    @Test
    void testLic10_true() {
        int numpoints = 6;
        double[][] points = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 2, 0 }, { 0, 0 }, { 0, 6 } };
        ParameterRecord paramters = new ParameterRecord(0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, paramters, lcm, puv);
        assertTrue(lic.lic10());
    }

    @Test
    void testLic10_false_too_large_AREA1() {
        int numpoints = 6;
        double[][] points = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 2, 0 }, { 0, 0 }, { 0, 6 } };
        ParameterRecord paramters = new ParameterRecord(0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, paramters, lcm, puv);
        assertFalse(lic.lic10());
    }

    @Test
    void testLic10_false_to_few_numpoints_compared_to_E_F_PTS() {
        int numpoints = 6;
        double[][] points = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 2, 0 }, { 0, 0 }, { 0, 6 } };
        ParameterRecord paramters = new ParameterRecord(0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, paramters, lcm, puv);
        assertFalse(lic.lic10());
    }

    @Test
    void testLic11_false_input() {
        int numpoints = 4;
        double[][] points = { { 0, 0 }, { -1, 0 }, { -2, 0 }, { -3, 0 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic11());
    }

    @Test
    void testLic11_false() {
        int numpoints = 4;
        double[][] points = { { 0, 0 }, { 1, 1 }, { 2, 2 }, { 3, 3 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic11());
    }

    @Test
    void testLic11_true() {
        int numpoints = 5;
        double[][] points = { { 0, 2 }, { 5, 0 }, { 9, 3 }, { 7, 0 }, { 4, -3 } };
        ParameterRecord parameters = new ParameterRecord(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertTrue(lic.lic11());
    }

    @Test
    void testLic12_true() {
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

    @Test
    void testLic12_false() {
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

    @Test
    void testLic13_true() {
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

    @Test
    void testLic13_onLine_false() {
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

    @Test
    void testLic13_false() {
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

    @Test
    void testLic14_true() {
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

    @Test
    void testLic14_false() {
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
}
