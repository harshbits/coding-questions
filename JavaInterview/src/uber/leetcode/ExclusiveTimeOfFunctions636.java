package uber.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions636 {

	public static void main(String[] args) {

		var logs = List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6");
		int[] ans = new ExclusiveTimeOfFunctions636().exclusiveTime(2, logs);
		System.out.println(Arrays.toString(ans));

	}

	public int[] exclusiveTime(int n, List<String> logs) {
		int[] ans = new int[n];

		if (n < 1 || logs == null || logs.size() < 1) {
			return ans;
		}

		// can improve performance by aray
		Stack<Integer> stack = new Stack<>();
//		int lastTime = 0;
		int[] lastTime = new int[1];

		// Very poor performance
		
		logs.parallelStream().map(log -> new Log(log)).sequential().forEach(log -> {
			if (log.isStart) {
				if (!stack.isEmpty()) {
					int val = stack.peek();
					int diff = log.timestamp - lastTime[0];
					ans[val] += diff;
				}
				lastTime[0] = log.timestamp;
				stack.push(log.id);
			}
			// end
			else {
				int val = stack.pop();
				int diff = log.timestamp - lastTime[0] + 1;
				ans[val] += diff;
				lastTime[0] = log.timestamp + 1;
			}
		});

//		for (String log : logs) {
//			Log l = new Log(log);
////			String[] data = log.split(":");
////			int funId = Integer.parseInt(data[0]);
////			int timeStamp = Integer.parseInt(data[2]);
////
//			// Start
////			if ("start".equals(data[1])) {
//			if (l.isStart) {
//				if (!stack.isEmpty()) {
//					int val = stack.peek();
//					int diff = l.timestamp - lastTime;
//					ans[val] += diff;
//				}
//				lastTime = l.timestamp;
//				stack.push(l.id);
//			}
//			// end
//			else {
//				int val = stack.pop();
//				int diff = l.timestamp - lastTime + 1;
//				ans[val] += diff;
//				lastTime = l.timestamp + 1;
//			}
//		}

		return ans;
	}
	
	class Log {
		int id;
		int timestamp;
		boolean isStart;

		Log(String s) {
			String[] data = s.split(":");
			this.id = Integer.parseInt(data[0]);
			this.timestamp = Integer.parseInt(data[2]);
			this.isStart = data[1].equalsIgnoreCase("start");
		}
	}
}
