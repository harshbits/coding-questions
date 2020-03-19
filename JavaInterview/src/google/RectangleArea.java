package google;

public class RectangleArea {

    public static void main(String[] args) {
        int A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2;
        int ans = new RectangleArea().computeArea(A, B, C, D, E, F, G, H);
        System.out.println(ans);
    }


    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaRect1 = (A - C) * (B - D);
        int areaRect2 = (E - G) * (F - H);
//        System.out.println(areaRect1);
//        System.out.println(areaRect2);
        int newLength = overLappingLength(A, C, E, G);
        System.out.println(newLength);
        int newWidth = overLappingLength(B, D, F, H);
        System.out.println(newWidth);

        return areaRect1 + areaRect2 - (newLength * newWidth);
    }

    private int overLappingLength(int A, int C, int E, int G) {
        if (C < E || A > G) {
            return 0;
        }
        return Math.min(C, G) - Math.max(A, E);
    }
}

