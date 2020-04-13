package facebook.leetcode_2020.greedy;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        var ans = new TaskScheduler().leastInterval(tasks, n);
        System.out.println(ans);
    }

    private static final char IDLE = '?';

    // Time: O(N)
    // Space: O(1)
    public List<Character> leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return Collections.emptyList();
        }

        //build map to sum the amount of each task
        //O(26) = O(1) space.
        Map<Character, Task> map = new HashMap<>();
        for (char ch : tasks) {
            Task task = map.getOrDefault(ch, new Task(ch, 0));
            task.left += 1;
            map.put(ch, task);
        }

        // Max heap. get the maximum occurrences first
        // O(26 log 26) = O(26) = O(1)
        PriorityQueue<Task> queue = new PriorityQueue<>();
        queue.addAll(map.values());

        List<Character> tasksOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int interval = n + 1;

            // temporary list to update queue
            List<Task> tempList = new ArrayList<>();

            // fill the intervals with the next high freq task
            while (interval > 0 && !queue.isEmpty()) {
                Task task = queue.poll();
                task.left -= 1;
                tempList.add(task);
                interval--;
                tasksOrder.add(task.c);
            }

            // update the task values and add it back to queue
            for (Task task : tempList) {
                if (task.left > 0) {
                    queue.offer(task);
                }
            }

            // if there is any empty interval left after all tasks are filled
            while (!queue.isEmpty() && interval-- > 0) {
                tasksOrder.add(IDLE);
            }
        }

        return tasksOrder;
    }

    private class Task implements Comparable<Task> {
        char c;
        int left;

        public Task(char c, int left) {
            this.c = c;
            this.left = left;
        }

        @Override
        public int compareTo(Task that) {
            return that.left - this.left;
        }
    }


    // Time : O(N)
    // Space: O(1)
    // (c[25] - 1) * (n + 1) + 25 -i = 2 * 3 + 2 = 8
    public int leastInterval1(char[] tasks, int n) {
        //O(1)
        int[] count = new int[26];
        int maxN = 0;
        for (char task : tasks) {
            count[task - 'A']++;
            maxN = Math.max(maxN, count[task - 'A']);
        }
        int ans = (maxN - 1) * (n + 1);
        for (int i = 0; i < 26; i++) {
            // we need ideal for maximum frequency number
            if (count[i] == maxN) {
                ans++;
            }
        }
        return Math.max(ans, tasks.length);
    }
}


/**
 * A - A - A - B - B - B
 * <p>
 * <p>
 * order: A  - B
 * <p>
 * queue: A, A, B, B
 */
