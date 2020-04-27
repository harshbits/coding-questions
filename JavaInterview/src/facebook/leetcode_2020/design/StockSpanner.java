package facebook.leetcode_2020.design;

import java.util.Stack;

public class StockSpanner {

    public static void main(String[] args) {
        StockSpanner S = new StockSpanner();

        System.out.println(S.next(100)); //is called and returns 1,
        System.out.println(S.next(80)); // is called and returns 1,
        System.out.println(S.next(60)); //is called and returns 1,
        System.out.println(S.next(70)); //is called and returns 2,
        System.out.println(S.next(60)); //is called and returns 1,
        System.out.println(S.next(75)); //is called and returns 4,
        System.out.println(S.next(85)); //is called and returns 6.
    }

    //////////////////////////////////////////////
    ///////////////IMPLEMENTATION/////////////////
    //////////////////////////////////////////////

    private Stack<StockData> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }

    public int next(int price) {
        int days = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            StockData data = stack.pop();
            days += data.days;
        }
        stack.push(new StockData(days, price));
        return days;
    }

    private class StockData {
        int days;
        int price;

        public StockData(int days, int price) {
            this.days = days;
            this.price = price;
        }
    }
}
