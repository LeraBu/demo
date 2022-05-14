package com.example.demo;

import org.joda.time.LocalDate;
import org.joda.time.Period;

public class Task {
    public static void main(String[] args) {
        String route = "NSEWNSWENSNNNNNNNN";
        System.out.println(isItAGoodRoute(route));

        LocalDate date1 = new LocalDate(2022, 1, 10);
        System.out.println(howManyDays(date1));

    }

    public static String isItAGoodRoute(String route){
        String routeForTenDays = route.substring(0, 10);
        int x = 0;
        int y = 0;
        char[] result = routeForTenDays.toCharArray();
        for (char c : result) {
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else if (c == 'W') x--;
            else System.out.println("Error in building route");
        }
        if ((x == 0) && (y == 0))
        return "This is a good route";
        else return "This is a bad route";
    }

    public static Period howManyDays(LocalDate date){
        return new Period(LocalDate.now(), date);
    }
}

