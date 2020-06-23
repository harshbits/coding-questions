package amazon.oa;

import java.util.*;

public class PrisonAfterNDays {

    public static void main(String[] args) {
//         1 1 1 0 1111 / 2

        int[] cells = {1, 1, 1, 0, 1, 1, 1, 1};

        PrisonAfterNDays p = new PrisonAfterNDays();
        int[] ans = p.prisonAfterNDays(cells, 2);
        System.out.println(Arrays.toString(ans));

    }


    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> map = new HashMap<>();
        int cycle = 0;
        int i = 0;
        int remaining = 0;
        while (i < N) {
            int key = toNum(cells);
            if (map.containsKey(key)) {
                cycle = i - map.get(key);
                remaining = (N - i) % cycle;
                break;
            }
            map.put(key, i);
            cells = getNext(cells);
            i++;
        }

        int j = 0;
        while (j < remaining) {
            cells = getNext(cells);
            j++;
        }
        return cells;
    }

    public int[] getNext(int[] cells) {
        int[] ans = new int[cells.length];
        for (int i = 1; i < ans.length - 1; i++) {
            if ((cells[i - 1] == 1 && cells[i + 1] == 1) || (cells[i - 1] == 0 && cells[i + 1] == 0)) {
                ans[i] = 0;
            } else {
                ans[i] = 1;
            }

        }
        return ans;
    }

    public int toNum(int[] cells) {
        int ans = 0;
        int mask = 1;
        for (int i = cells.length - 1; i >= 0; i--) {
            ans += cells[i] * (mask << (cells.length - 1 - i));
        }
        return ans;
    }
}
