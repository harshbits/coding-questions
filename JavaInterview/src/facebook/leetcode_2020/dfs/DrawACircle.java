package facebook.leetcode_2020.dfs;

public class DrawACircle {

    public static void main(String[] args) {
        new DrawACircle().drawCircle(0, 0, 1);
    }

    // based on: r*r = (x-a)*(x-a) + (y-b)*(y-b)
    public void drawCircle(int a, int b, int r) {
        if (r == 0) {
            return;
        }

        // formula = x^2 + y^2 = r^2
        // y = sqrt (r^2 - x^2)
        int rSq = r * r;
        for (int x = 0; x <= rSq; x++) {
            int y = (int) Math.sqrt(rSq - x * x);
            drawPoint(a + x, b + y);
            drawPoint(a + y, b + x);
            drawPoint(a + x, b - y);
            drawPoint(a + y, b - x);
            drawPoint(a - x, b + y);
            drawPoint(a - y, b + x);
            drawPoint(a - x, b - y);
            drawPoint(a - y, b - x);
        }
    }

    public void drawPoint(int x, int y) {
        System.out.println(x + ", " + y);

        // print logic
    }
}
