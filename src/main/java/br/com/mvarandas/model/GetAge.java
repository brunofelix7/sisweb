package br.com.mvarandas.model;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class GetAge {

	public static String getAgeTest(){
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(1989, Month.NOVEMBER, 6);
		Period p = Period.between(birthday, today);
		return "" + p.getYears();
	}
	
	public static int getAge(Date dateOfBirth){
		Calendar today = Calendar.getInstance();
	    Calendar birthDate = Calendar.getInstance();
	    birthDate.setTime(dateOfBirth);
	    if(birthDate.after(today)){
	        throw new IllegalArgumentException("You don't exist yet");
	    }
	    int todayYear = today.get(Calendar.YEAR);
	    int birthDateYear = birthDate.get(Calendar.YEAR);
	    int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
	    int birthDateDayOfYear = birthDate.get(Calendar.DAY_OF_YEAR);
	    int todayMonth = today.get(Calendar.MONTH);
	    int birthDateMonth = birthDate.get(Calendar.MONTH);
	    int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
	    int birthDateDayOfMonth = birthDate.get(Calendar.DAY_OF_MONTH);
	    int age = todayYear - birthDateYear;

	    if((birthDateDayOfYear - todayDayOfYear > 3) || (birthDateMonth > todayMonth)){
	        age--;
	    
	    }else if((birthDateMonth == todayMonth) && (birthDateDayOfMonth > todayDayOfMonth)){
	        age--;
	    }
	    return age;
	}
	
}
