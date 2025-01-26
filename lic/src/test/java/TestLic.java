import com.group7.LaunchInterceptor;
import com.group7.LaunchInterceptor.ParameterRecord;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

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
    void testLic2_lessThanPi_true() {
        // Case 1, we know to be true according to input variables
        System.out.println("Test lic1");
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
        // Case 3, we know to be true according to input variables
        System.out.println("Test lic2");
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
        // Case 2, we know to be false according to input variables
        System.out.println("Test lic2");
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
        // Case 5, we know to be false because one point is equal to the vertex-point
        System.out.println("Test lic2");
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
        // Case 6, we know to be false since the vectors are parallel
        System.out.println("Test lic2");
        int numpoints = 3;
        double[][] points = { { 0, 0 }, { 2, 0 }, { 1, 0 } };
        ParameterRecord parameters = new ParameterRecord(3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints, points, parameters, lcm, puv);
        assertFalse(lic.lic2());
    }

}
