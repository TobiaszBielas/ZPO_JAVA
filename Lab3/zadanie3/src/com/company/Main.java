package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        LocalDate Start = LocalDate.of(1939, 9, 1);
        LocalDate Stop = LocalDate.of(1945, 5, 8);
        DaysBetweenDates(Start,Stop);

        Start = LocalDate.of(2016,1,1);
        GetDateFromDayOfYear(Start, 67);

        LocalTime First = LocalTime.of(11,45);
        LocalTime Second = LocalTime.of(22,30);
        sumOfHoursMinutes(First,Second);

        LocalDate B_day = LocalDate.of(1998,04,20);
        HowManyLapYear(B_day);

    }

    public static void DaysBetweenDates(LocalDate Start_date, LocalDate Stop_date) {
        final long days = ChronoUnit.DAYS.between(Start_date, Stop_date) + 1;
        System.out.println("Days between: " + days);
    }

    public static void GetDateFromDayOfYear(LocalDate year, int day){
        System.out.println(year.plusDays(day).getMonth() + " - " + year.plusDays(day).getDayOfMonth());
    }

    public static void sumOfHoursMinutes(LocalTime First, LocalTime Second){
        int counter = 0;
        int val;
        do{
            int temp = 0;
            temp += Character.getNumericValue(First.toString().charAt(0));
            temp += Character.getNumericValue(First.toString().charAt(1));
            temp += Character.getNumericValue(First.toString().charAt(3));
            temp += Character.getNumericValue(First.toString().charAt(4));
            if(temp == 15){
                counter += 1;
            }
            First = First.plusMinutes(1);
        }while(First.compareTo(Second) != 0);
        System.out.println(counter);
    }

    public static void HowManyLapYear(LocalDate B_day){
        int counter = 0;
        while(B_day.isBefore(LocalDate.now())) {
//            System.out.println(B_day);
            if(B_day.isLeapYear()) {
                ++counter;
//                System.out.println(counter);
            }
            B_day = B_day.plusYears(1);
        }
        System.out.println(counter);
    }
}
