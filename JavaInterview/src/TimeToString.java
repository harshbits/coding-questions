public class TimeToString {

	public static void main(String[] args) {
		
		int T = 7500;
		String ans = new TimeToString().solution(T);
		System.out.println(ans);
		
	}

	public String solution(int T) {

		if (T <= 0) {
			return "0h0m0s";
		}
		
		if (T > 86400) {
			throw new RuntimeException("Invalid Input");
		}
		// answer
		StringBuilder time = new StringBuilder();

		// hours
		int hours = T / 3600;
//		System.out.println(hours);

		// minutes
		int minutes = (T % 3600) / 60;
//		System.out.println(minutes);

		// seconds
		int seconds = (T % 3600) % 60;
//		System.out.println(seconds);

		// Return time
		time.append(hours).append("h").append(minutes).append("m").append(seconds).append("s");

		return time.toString();
	}
}
