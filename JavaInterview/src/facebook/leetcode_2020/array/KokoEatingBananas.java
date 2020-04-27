package facebook.leetcode_2020.array;

// Similar Question
// // Cut the wood
public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas kb = new KokoEatingBananas();
        int[] wood = {5, 9, 7};
        System.out.println(kb.cutWood(wood, 3));

        int[] piles = {30, 11, 23, 4, 20};
        System.out.println(kb.minEatingSpeed(piles, 5));
    }

    // Time: O(n * log n)
    // Space: O(1)
    public int minEatingSpeed(int[] piles, int H) {
        if (piles == null || piles.length == 0 || H == 0) {
            return 0;
        }

        // binary search
        // int low = 1;
        // if we know max then we can use max;
        // int high = Integer.MAX_VALUE;

        int low = 1;
        int high = 0;
        for (int p : piles) {
            high = Math.max(high, p);
        }

        // bibary search to find the smallest valid K.
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canEatAll(piles, mid, H)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // O(n)
    // Can Koko eat all bananas in H hours with eating speed K?
    private boolean canEatAll(int[] piles, int K, int H) {
        int count = 0;
        for (int p : piles) {
            count += (p - 1) / K + 1;
        }
        return count <= H;
    }

    // Time: O(n * log n)
    // Related Problem
    // Max wood cut
    public int cutWood(int[] wood, int k) {
        // corner cases:
        if (wood == null || wood.length == 0 || k == 0) {
            return 0;
        }

        // binary search
        int low = 1;
        int high = Integer.MAX_VALUE;
        // if we know max then we can use max;

        // corner case.
        if (!isValidCut(wood, low, k)) {
            return 0;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isValidCut(wood, mid, k)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // O(n)
    private boolean isValidCut(int[] wood, int currentLength, int k) {
        int count = 0;
        for (int w : wood) {
            // floor
            count += w / currentLength;
        }
        return count >= k;
    }
}
