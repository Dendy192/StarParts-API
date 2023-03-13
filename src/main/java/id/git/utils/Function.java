package id.git.utils;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class Function {
	private static Logger log = Logger.getLogger(Function.class.getName());

	public static String getPeriod() {
		String result = "";
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		if (month == 0) {
			result = "12" + (year - 1);
		} else if (month == 1 || month == 2 || month == 3 || month == 4
				|| month == 5 || month == 6 || month == 7 || month == 8
				|| month == 9) {
			result = "0" + month + year;
		} else if (month == 10 || month == 11) {
			result = String.valueOf(month) + String.valueOf(year);
		}
		return result;
	}

}
