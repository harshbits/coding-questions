package leetcode.uber;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * Design a logger system that receive stream of messages along with its
 * timestamps, each message should be printed if and only if it is not printed
 * in the last 10 seconds.
 * 
 * Given a message and a timestamp (in seconds granularity), return true if the
 * message should be printed in the given timestamp, otherwise returns false.
 * 
 * It is possible that several messages arrive roughly at the same time.
 * 
 * @author habhavsar
 *
 */
public class LoggerRateLimiter {

	public static void main(String[] args) {

		LoggerRateLimiter logger = new LoggerRateLimiter();

		// logging string "foo" at timestamp 1
		System.out.println(logger.shouldPrintMessage(1, "foo"));

		// logging string "bar" at timestamp 2
		System.out.println(logger.shouldPrintMessage(2, "bar"));

		// logging string "foo" at timestamp 3
		System.out.println(logger.shouldPrintMessage(3, "foo"));

		// logging string "bar" at timestamp 8
		System.out.println(logger.shouldPrintMessage(8, "bar"));

		// logging string "foo" at timestamp 10
		System.out.println(logger.shouldPrintMessage(10, "foo"));

		// logging string "foo" at timestamp 11
		System.out.println(logger.shouldPrintMessage(11, "foo"));

	}

	private Map<String, Integer> map;

	/** Initialize your data structure here. */
	public LoggerRateLimiter() {
		this.map = new HashMap<>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will not
	 * be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {

		if (!map.containsKey(message) || (timestamp - map.get(message)) >= 10) {
			map.put(message, timestamp);
			cleanUp(timestamp);
			return true;
		}
		cleanUp(timestamp);
		return false;
	}

	/**
	 * Clean Up method to avoid unnecessary data.
	 * 
	 * @param timestamp
	 */
	private void cleanUp(int timestamp) {
		this.map = map.entrySet().stream().filter(e -> (timestamp - e.getValue()) < 10)
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

	}
}
