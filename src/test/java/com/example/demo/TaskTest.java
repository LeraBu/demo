package com.example.demo;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest extends Task {

    @Test
    void testIsItAGoodRoute() {
        String route1 = "NNNNNNNNNN";
        assertEquals("This is a bad route", Task.isItAGoodRoute(route1));
    }

    @Test
    void testHowManyDays() {
        LocalDate date2 = new LocalDate(2022, 1, 10);
        assertEquals((new Period(LocalDate.now(), date2)), Task.howManyDays(date2));
    }
}