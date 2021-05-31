import static org.junit.jupiter.api.Assertions.*;


class GaussTest {

    Gauss gauss;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        gauss = new Gauss();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() { }

    @org.junit.jupiter.api.Test
    void gaussTestCube() {
        double[][] a = {{2, 4, 1},
                        {5, 2, 1},
                        {2, 3, 4}};
        double[] y   =  {36, 47, 37};
        double[] x;
        double[] x_check   =  {7, 5, 2};
        
        gauss.setA(a);
        gauss.setY(y);
	gauss.solve();
	x = gauss.getX();
	
        assertArrayEquals(x, x_check);
    }

    @org.junit.jupiter.api.Test
    void gaussTestDecision() {
        double[][] a = {{0, 1, 1},
                        {0, 1, 1},
                        {0, 1, 1}};
        double[] y   =  {0, 1, 1};
        double[] x;
        double[] x_check   =  {};
        
        gauss.setA(a);
        gauss.setY(y);

        //метод для catch исключения о том, что СЛАУ решений не имеет, throw из метода gauss.solve(a, y, n)
        try {
            gauss.solve();
            x = gauss.getX();
            assertArrayEquals(x, x_check);
            System.out.println("The test has been passed");
        }
        catch(IllegalArgumentException e) {
            System.out.println("gaussTestDecision: " + e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void gaussTestSizes() {
        double[][] a = {{0, 1, 1},
                        {0, 1, 1},
                        {0, 1, 1}};
        double[] y   =  {0, 1};
        double[] x;
        double[] x_check   =  {};

        gauss.setA(a);
        gauss.setY(y);
        
        //метод для catch исключения о том, что СЛАУ решений не имеет, throw из метода gauss.solve(a, y, n)
        try {
            gauss.solve();
            x = gauss.getX();
            assertArrayEquals(x, x_check);
            System.out.println("The test has been passed");
        }
        catch(IndexOutOfBoundsException  e) {
            System.out.println("gaussTestSizes: " + e.getMessage());
        }
    }
}
