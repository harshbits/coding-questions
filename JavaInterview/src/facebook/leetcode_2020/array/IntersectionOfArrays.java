package facebook.leetcode_2020.array;

import java.lang.reflect.Array;
import java.util.*;

public class IntersectionOfArrays {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] ans = new IntersectionOfArrays().intersection(nums1, nums2);
        System.out.println(Arrays.toString(ans));

        ans = new IntersectionOfArrays().intersectionII(nums1, nums2);
        System.out.println(Arrays.toString(ans));

        ans = new IntersectionOfArrays().intersectFU2(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

    //
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] ans = new int[intersect.size()];
        int i = 0;
        for (int x : intersect) {
            ans[i++] = x;
        }
        return ans;
    }

    // O(Max(m,n))
    // Array is sorted
    public int[] intersectionFollowUp1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1); // assuming array is sorted
        Arrays.sort(nums2); // assuming array is sorted
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }


    // Time: O(N + N)
    // as many time as it appear
    public int[] intersectionII(int[] nums1, int[] nums2) {
        // number and total count
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    // Follow up 1
    // What if the given array is already sorted? How would you optimize your algorithm?
    // Time: O(Max(m,n)
    public int[] intersectFU1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < n && j < m) {
            int a = nums1[i], b = nums2[j];
            if (a == b) {
                list.add(a);
                i++;
                j++;
            } else if (a < b) {
                i++;
            } else {
                j++;
            }
        }
        int[] ret = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ret[k] = list.get(k);
        }
        return ret;
    }

    // Follow Up 2
    // What if nums1's size is small compared to nums2's size? Which algorithm is better?
    // Time: O(k log n)
    // k = nums2 size, n = nums1 size
    public int[] intersectFU2(int[] nums1, int[] nums2) {

        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // doing this for the problem
        Arrays.sort(nums1); // this will be sorted already

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            // can use inbuilt binary search
//            if(Arrays.binarySearch(nums1, nums2[i]) != -1){
//            }
            if (binarySearch(nums1, nums2[i])) {
                list.add(nums2[i]);
            }
        }

        int[] ret = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ret[k] = list.get(k);
        }
        return ret;
    }

    // O(log n)
    private boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    // Follow Up 3
    // 1. external sort (if both are large)
    // 2. Map Reduce (if num2 is in disk)
    // 3.


    // Intersection of 3 arrays
    // Time: O(min(m,n,l))
    // Space: O(1)
    // Arrays are strictly sorted
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> intersection = new ArrayList<>();

        int i = 0;
        int j = 0;
        int k = 0;

        // we only need to pass one array fully.
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            // found a match
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                intersection.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return intersection;
    }
}
