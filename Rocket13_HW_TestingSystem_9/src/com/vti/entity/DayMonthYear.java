package com.vti.entity;

public class DayMonthYear {
	public int day, month, year;
	public class hourMinuteSeconds{
		public int hour, minutes, seconds;
		public void printInfo() {
			System.out.println("Day: "+day+"Month: "+month+"Year: "+year);
			System.out.println("Hour: "+hour+"Minutes: "+minutes+"Seconds: "+seconds);
		}
	}
	
	public void ex2_Ques2() {
		DayMonthYear date = new DayMonthYear();
		date.day = 20;
		date.month = 05;
		date.year = 2021;
		
		hourMinuteSeconds time = date.new hourMinuteSeconds();
		time.hour = 10;
		time.minutes = 10;
		time.seconds = 10;
		time.printInfo();
	}
}
