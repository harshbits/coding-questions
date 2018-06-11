package amazon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class CheckDateMonthBefore {

	public static void main(String[] args) throws ParseException {
		LocalDate date1 = LocalDate.parse("2017-01-05");
		LocalDate date2 = LocalDate.parse("2017-02-05");

		// LocalDate date1 = LocalDate.parse("2017-02-04");
		// LocalDate date2 = LocalDate.parse("2017-03-05");

		boolean usingLocalDate = isMonthBefore(date1, date2);
		System.out.println(usingLocalDate);

		SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");

		// Date date11 = sdfSource.parse("2017-01-05");
		// Date date22 = sdfSource.parse("2017-02-05");

		Date date11 = sdfSource.parse("2017-02-04");
		Date date22 = sdfSource.parse("2017-03-05");
		boolean usingDate = isMonthBeforeDate(date11, date22);
		System.out.println(usingDate);
	}

	private static boolean isMonthBefore(LocalDate date1, LocalDate date2) {
		// return date1.isBefore(date2.minusMonths(1)) ||
		// date1.isEqual(date2.minusMonths(1));
		return date1.isEqual(date2.minusMonths(1));
	}

	private static boolean isMonthBeforeDate(Date date1, Date date2) {
		// return date1.isBefore(date2.minusMonths(1)) ||
		// date1.isEqual(date2.minusMonths(1));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date2);
		calendar.add(Calendar.MONTH, -1);
		return date1.compareTo(calendar.getTime()) == 0;

	}

}
