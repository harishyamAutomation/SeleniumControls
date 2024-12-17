package com.ui.helper;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTestHelper {

	public static void createFolder(String path) {
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
	}
	
	public static String currentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd MMM YYYY");
		String formattedDate = currentDate.format(formatter).replace(" ", "_");
		return formattedDate;
	}
	
	public static String timeStamp() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd MMM YYYY HH:mm:ss");
		String formattedTimeStamp = currentDateTime.format(formatter).replace(":", "_").replace(" ", "_");
		return formattedTimeStamp;
	}
}
