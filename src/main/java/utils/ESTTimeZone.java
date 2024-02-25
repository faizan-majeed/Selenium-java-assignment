package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ESTTimeZone {

	 public static String getCurrentDate(String format) {
		 LocalDateTime today =LocalDateTime.now();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		 return today.format(formatter);
	 }
}
