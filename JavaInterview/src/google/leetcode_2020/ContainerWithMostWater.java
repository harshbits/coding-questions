package google.leetcode_2020;

import java.lang.reflect.Array;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};
        int ans = new ContainerWithMostWater().maxArea(height);
        System.out.println(ans);
    }

    public int maxArea(int[] height) {
        if(height.length < 2){
            return 0;
        }
        int l = 0, r = height.length - 1,area = 0;
        while (l < r){
//            area = Math.max(area, Math.min(height[r],height[l]) * (r - l));
            if(height[l] < height[r]){
                area = Math.max(area, height[l]* (r - l));
                l++;
            }else{
                area = Math.max(area, height[r]* (r - l));
                r--;
            }
        }
        return area;
    }
}


// [1,8,6,2,5,4,8,3,7]

// wont work
// i = 0; j = 1 => 1
// i = 1; j = 2 = > 6
// i = 1; j =


// l = 0, r = 8


