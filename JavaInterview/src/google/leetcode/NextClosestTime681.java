package google.leetcode;

public class NextClosestTime681 {

	public static final int MAX_TIME = 2400;

	public static final int MAX_HOUR = 24;

	public static final int MAX_MIN = 60;

	public static void main(String[] args) {
		String time = "19:34";
		NextClosestTime681 n = new NextClosestTime681();
		String ans = n.nextClosestTime(time);
		System.out.println(ans);

	}

	int diff = 0;
	String result = "";
	int hour;
	int minute;

	public String nextClosestTime(String time) {
		String[] timeA = time.trim().split(":");
		int hour = Integer.parseInt(timeA[0]);
		int minute = Integer.parseInt(timeA[1]);
		// int total = 0;
		// int[] digit = new int[4];
		// digit[total++] = hour / 10;
		// digit[total++] = hour % 10;
		// digit[total++] = minute / 10;
		// digit[total++] = minute % 10;
		//
		int[] digit = { hour / 10, hour % 10, minute / 10, minute % 10 };
		this.hour = hour;
		this.minute = minute;
		
		dfs(digit, 0, new int[4]);
		
		return result;
	}
	
	
	private void dfs(int[] digit, int i, int[] ans) {

		if (i == 4) {
			int hour = 10 * ans[0] + ans[1];
			int minute = 10 * ans[2] + ans[3];

			int df = difference(hour, minute);
			if (df < diff) {
				diff = df;
				result = valid(hour) + ":" + valid(minute);
			}
		} else {
			for (int j = 0; j < 4; ++j) {
				ans[i] = digit[j];
				
				if (i == 1) {
					int hour = ans[0] * 10 + ans[1];
					if (hour >= 0 && hour <= 23) {
						dfs(digit, i + 1, ans);
					}
				}
				else if (i == 3) {
					int minutes = ans[2] * 10 + ans[2];
					if (minutes >= 0 && minutes <= 59) {
						dfs(digit, i + 1, ans);
					}
				}else {
					dfs(digit, i + 1, ans);
				}
			}
		}
	}
	
	private int difference(int h, int m) {
		int given = 60 * 60 - hour * 60 - minute;
		int current = 60 * 6 - -h * 60 - m;
		return given > current ? given - current : current - given + 3600;
	}
	
	private String valid(int time) {
		if (time >= 0 && time <= 9) {
			return "0" + time;
		} else {
			return time + "";
		}
	}

	public String nextClosestTime1(String time) {
		// Set<Integer> nums = new HashSet<>();
		// String[] timeA = time.trim().split(":");
		// String hour = timeA[0];
		// String minutes = timeA[1];
		//
		//
		// for (char c : hour.toCharArray()) {
		// nums.add(Integer.parseInt(String.valueOf(c)));
		// }
		// for (char c : minutes.toCharArray()) {
		// nums.add(Integer.parseInt(String.valueOf(c)));
		// }

		String timeonly = time.replaceAll(":", "");
		int time24 = Integer.parseInt(timeonly);
		int maxHour = 0;
		int maxHour2 = 0;
		int maxMinutes = 0;
		int maxMinutes2 = 0;
		for (char c : timeonly.toCharArray()) {
			int num = Integer.parseInt(String.valueOf(c));
			if (num > maxHour && num < 3) {
				maxHour = num;
			}

			int maxhours2temp = maxHour2 * 10 + num;
			if (maxhours2temp > maxHour2 && maxhours2temp <= MAX_HOUR) {
				maxHour2 = num;
			}

			if (num > maxMinutes && num < 7) {
				maxMinutes = num;
			}
			int maxminutes2temp = maxMinutes2 * 10 + num;
			if (maxminutes2temp > maxMinutes2 && maxminutes2temp <= MAX_HOUR) {
				maxMinutes2 = num;
			}
			// nums.add(num);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(maxHour).append(maxHour2).append(":").append(maxMinutes).append(maxMinutes2);
		return sb.toString();
	}

}
