package facebook.leetcode_2020.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPoints {

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {2, -2}};
        int[][] ans = new KClosestPoints().kClosest(points, 1);
        System.out.println(Arrays.deepToString(ans));
    }

    // Quick sort and select the kth
    // Theoretically, the average time complexity is O(N)
    // but just like quick sort, in the worst case, O(N^2)
    public int[][] kClosest(int[][] points, int K) {
        int l = 0;
        int h = points.length - 1;
        while (l <= h) {
            int pivot = quickSelect(l, h, points);
            if (pivot == K) {
                break;
            }

            if (pivot < K) {
                l = pivot + 1;
            } else {
                h = pivot - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    public int quickSelect(int l, int h, int[][] points) {
        int pivot = l;
        int dpivot = distance(l, points);
        while (l <= h) {
            while (l <= h && distance(l, points) <= dpivot) {
                l++;
            }
            while (l <= h && distance(h, points) > dpivot) {
                h--;
            }
            if (l > h) {
                break;
            }
            swap(l, h, points);
        }
        swap(pivot, h, points);
        return h;
    }

    public void swap(int i, int j, int[][] points) {
        int tempx = points[i][0];
        int tempy = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = tempx;
        points[j][1] = tempy;
    }

    public int distance(int l, int[][] points) {
        return points[l][0] * points[l][0] + points[l][1] * points[l][1];
    }



    public int[][] kClosest2(int[][] points, int K) {
        int n = points.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = quickSelect(points, low, high);
            if (mid == K - 1) {
                break;
            }
            if (mid < K - 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return Arrays.copyOfRange(points, 0, K);
    }

    private int quickSelect(int[][] points, int low, int high) {

        int[] pivot = points[low];

        while (low < high) {

            while (low < high && compare(points[high], pivot) >= 0) {
                high--;
            }
            points[low] = points[high];
            while (low < high && compare(points[low], pivot) <= 0) {
                low++;
            }
            points[high] = points[low];

        }
        points[low] = pivot;
        return low;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

    // space: O(k)
    // Time: O( n log k)
    public int[][] kClosest1(int[][] points, int K) {
        int[][] kClosestPoints = new int[K][2];

        // Max Heap
        PriorityQueue<Tuple> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] point : points) {
//            double distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            int distance = point[0] * point[0] + point[1] * point[1];
            heap.add(new Tuple(point[0], point[1], distance));
            if (heap.size() > K) {
                heap.poll();
            }
        }

        int i = 0;
        while (!heap.isEmpty()) {
            Tuple t = heap.poll();
            kClosestPoints[i][0] = t.x;
            kClosestPoints[i][1] = t.y;
            i++;
        }
        return kClosestPoints;
    }

    private class Tuple implements Comparable<Tuple> {

        int value;

        int x;

        int y;

        public Tuple(int x, int y, int value) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.value - that.value;
        }
    }
}
