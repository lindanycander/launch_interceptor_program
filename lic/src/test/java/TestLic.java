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
        double[][] points = {{0,3},{1,5},{3,8}};
        ParameterRecord parameters = new ParameterRecord(3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints,points,parameters,lcm,puv);
        assertTrue(lic.lic0());
    }

    @Test
    void testLic_false() {
        // Case 2, we know to be false according to input variables
        System.out.println("Test lic0");
        int numpoints = 3;
        double[][] points = {{-2,3},{1,-5},{-3,8}};
        ParameterRecord parameters = new ParameterRecord(50,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints,points,parameters,lcm,puv);
        assertFalse(lic.lic0());
    }

    @Test
    void testLic3_true() {
        // Case 1, we know to be true according to input variables
        System.out.println("Test lic3");
        int numpoints = 3;
        double[][] points = {{-2,3},{1,-5},{-3,8}};
        ParameterRecord parameters = new ParameterRecord(0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints,points,parameters,lcm,puv);
        assertTrue(lic.lic3());
    }

    @Test
    void testLic3_false() {
        // Case 2, we know to be false according to input variables
        System.out.println("Test lic3");
        int numpoints = 3;
        double[][] points = {{-2,3},{1,-5},{-3,8}};
        ParameterRecord parameters = new ParameterRecord(0,0,0,50,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        String[][] lcm = new String[15][15];
        boolean[] puv = new boolean[15];
        LaunchInterceptor lic = new LaunchInterceptor(numpoints,points,parameters,lcm,puv);
        assertFalse(lic.lic3());
    }
}
