package utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ESTTimeZone {

	 public static String getCurrentDate(String format) {
		 LocalDateTime today =LocalDateTime.now();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		 return today.format(formatter);
	 }
}
