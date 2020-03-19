package google.leetcode_2020.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfLastKElements {

    public static void main(String[] args) {
        Product p = new Product(3);
        p.insert(0);
        p.insert(1);
        p.insert(2);
        p.insert(3);
        System.out.println(p.get());
//        p.insert(0);
//        System.out.println(p.get());
        p.insert(4);
        System.out.println(p.get());
        p.insert(7);
        System.out.println(p.get());
        p.insert(2);
        System.out.println(p.get());
        p.insert(0);
        System.out.println(p.get());

        List<Integer> l = new ArrayList<>();
//        l.add();

    }


    static class Product {

        private int K;

        private int[] lastInserted;

        private int product;

        private int totalInserted;

        private int zeroCount;

        public Product(int K) {
            this.K = K;
            this.lastInserted = new int[K];
//            Arrays.fill(lastInserted, Integer.MAX_VALUE);
            this.product = 1;
            this.zeroCount = 0;
        }

        public void insert(int x) {
            int idx = totalInserted % K;
            if (totalInserted++ >= K) {
                int temp = lastInserted[idx];
                if (temp != 0) {
                    product /= temp;
                } else {
                    zeroCount--;
                }
            }

            lastInserted[idx] = x;
            if (x == 0) {
                zeroCount++;
            } else {
                product *= x;
            }
            System.out.println(Arrays.toString(lastInserted));
        }

        // get product of last K
        public int get() {
            if (zeroCount > 0) {
                return 0;
            }
            return product;
        }
    }
}
