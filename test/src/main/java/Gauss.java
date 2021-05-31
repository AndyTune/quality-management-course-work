public class Gauss {

    private double[][] a;
    private double[] y;
    private double[] x;
    
    public double[][] getA() { return a; }
    void setA(double[][] a) { this.a = a; }
    public double[] getY() { return y; }
    void setY(double[] y) { this.y = y; }
    public double[] getX() { return x; }
    void setX(double[] x) { this.x = x; }
    
    
    public void solve() {
        int n = 3;

        if (a.length != y.length || a.length != n) {
            throw new IndexOutOfBoundsException("Square matrix size and vector length are different");
        }

        x = new double[n];
        double max = 0;
        int k, index;
        double eps = 0.00001;  // точность

        k = 0;
        while (k < n) {
            // Поиск строки с максимальным a[i][k]
            max = Math.abs(a[k][k]);
            index = k;
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(a[i][k]) > max) {
                    max = Math.abs(a[i][k]);
                    index = i;
                }
            }
            // Перестановка строк
            if (max < eps) {
                // нет ненулевых диагональных элементов
                throw new IllegalArgumentException("Matrix has no decisions");
            }
            for (int j = 0; j < n; j++) {
                double temp = a[k][j];
                a[k][j] = a[index][j];
                a[index][j] = temp;
            }
            double temp = y[k];
            y[k] = y[index];
            y[index] = temp;
            // Нормализация уравнений
            for (int i = k; i < n; i++) {
                temp = a[i][k];
                if (Math.abs(temp) < eps) continue; // для нулевого коэффициента пропустить
                for (int j = 0; j < n; j++) {
                    a[i][j] = a[i][j] / temp;
                }
                y[i] = y[i] / temp;
                if (i == k) {
                    continue;
                }
                // уравнение не вычитать само из себя
                for (int j = 0; j < n; j++) {
                    a[i][j] = a[i][j] - a[k][j];
                }
                y[i] = y[i] - y[k];
            }
            k++;
        }

        // обратная подстановка
        for (k = n - 1; k >= 0; k--) {
            x[k] = Math.round(y[k]);
            for (int i = 0; i < k; i++)
                y[i] = y[i] - a[i][k] * x[k];
        }
    }
}
