package com.advance.java.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeOperations {

	public static void main(String[] args) {

		System.out.println("========= Date Operations =========");

		System.out.println("Current Date : " + LocalDate.now());
		System.out.println("100th day of 2017 :" + LocalDate.ofYearDay(2017, 100));
		System.out.println("Specific Date :" + LocalDate.of(2017, Month.JANUARY, 15));
		System.out.println("Current Date in IST : " + LocalDate.now(ZoneId.of("Asia/Kolkata")));
		System.out.println("Date from base : " + LocalDate.ofEpochDay(365));

		System.out.println("========= Time Operations =========");

		System.out.println("Current Time : " + LocalTime.now());
		System.out.println("100th second of the day :" + LocalTime.ofSecondOfDay(100));
		System.out.println("Specific time :" + LocalTime.of(10, 12, 15, 50));
		System.out.println("Current Time in IST : " + LocalTime.now(ZoneId.of("Asia/Kolkata")));

		System.out.println("========= Date & Time Operations using local dateTime api =========");
		System.out.println("Current Date Time : " + LocalDateTime.now());
		System.out.println("Current Date Time : " + LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		System.out.println("Specific Datetime :" + LocalDateTime.of(2017, Month.JANUARY, 15, 10, 12, 15, 50));
		System.out.println("Current Date Time in IST : " + LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
		
		
		System.out.println("=== Date Parsing ===");
		LocalDate date = LocalDate.now();
		System.out.println("Default format of local Date : "+ date);
		System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(date.format(DateTimeFormatter.ofPattern("d:MMM:uuuu")));
		
	}

}
