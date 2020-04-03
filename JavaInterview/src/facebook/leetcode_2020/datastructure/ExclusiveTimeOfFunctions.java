package facebook.leetcode_2020.datastructure;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    public static void main(String[] args) {

        List<String> logs = List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        int n = 2;
        int[] ans = new ExclusiveTimeOfFunctions().exclusiveTime(n, logs);
        System.out.println(Arrays.toString(ans));

    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        Stack<Integer> stack = new Stack<>();
        int lastTimestamp = 0;
        for (String log : logs) {
            int[] data = parse(log);
            if (data[1] == 0) {
                if (!stack.isEmpty()) {
                    int lastFunction = stack.peek();
                    int timeDiff = data[2] - lastTimestamp;
                    time[lastFunction] += timeDiff;
                }
                lastTimestamp = data[2];
                stack.push(data[0]);
            } else {
                int lastFunction = stack.pop();
                int timeDiff = data[2] - lastTimestamp + 1;
                time[lastFunction] += timeDiff;
                lastTimestamp = data[2] + 1;
            }
        }
        return time;
    }


    private int[] parse(String log) {

        int i = 0;
        // function Id
        int functionId = 0;
        for (; log.charAt(i) != ':'; i++) {
            functionId = functionId * 10 + (log.charAt(i) - '0');
        }
        // function indicator
        int functionIndicator = log.charAt(++i) == 's' ? 0 : 1;

        i = functionIndicator == 0 ? i + 6 : i + 4;
        // timestamp
        int timestamp = 0;
        for (; i < log.length(); i++) {
            timestamp = timestamp * 10 + (log.charAt(i) - '0');
        }
        return new int[]{functionId, functionIndicator, timestamp};
    }

}
