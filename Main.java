package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.OCTOBER, 25);
        calendar.set(Calendar.HOUR, (0-12));
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dateExam = calendar.getTime();
        System.out.println("Назначенная дата экзамена: " + simpleDateFormat.format(dateExam));
        BufferedReader string = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите дату dd-MM-yyyy, например: 01-01-2021:");
        String dateInput = null;
        try {
            dateInput = string.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date dateAnother = null;
        try {
            dateAnother = simpleDateFormat.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dateExam.compareTo(dateAnother) == 0){
            System.out.println("Сегодня экзамен!");
        }else if (dateExam.compareTo(dateAnother) == 1){
            System.out.println("Осталось " + getDaysBetween(dateExam, dateAnother) + " дней.");
        }else {
            System.out.println("Прошло " + getDaysBetween(dateExam, dateAnother) + " дней.");
        }
    }

    private static int getDaysBetween(Date dateExam, Date dateAnother) {
        int days = Math.abs((int) ((dateExam.getTime() - dateAnother.getTime()) / 1000 / 24 / 60 / 60));
        return days;
    }
}
