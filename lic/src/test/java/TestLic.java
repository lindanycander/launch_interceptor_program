import com.group7.LaunchInterceptor;
import com.group7.LaunchInterceptor.ParameterRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
