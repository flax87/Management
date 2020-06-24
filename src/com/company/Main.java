/*
 * @author  Oleksii Shevchenko KNUTE 1m
 *
 *
 * @version 23.06.20
 *
 *
 * Modul 4 task 1
 *
 * THome task. Files management.

1. Parse the file logs.txt (see the attachment).  Extract to a separate file all the logs.

2. Calculate the total number of logs (lines).

3. Calculate the total  number of  ERROR logs. Use previous skills - String.split

4.  Calculate the total number of ERROR logs. Use Files.lines.

5. Compare two results.
 */
package com.company;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {




        static class MyFirstThread extends Thread {

            @Override
            public void run() {
                LogsServicelmpl service1 = new LogsServicelmpl();
                try {
                    service1.getLogsByDate("2019-10-14");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        static class MyThread extends Thread {

            private String date;

            MyThread(String date){
                this.date = date;
            }

            @Override
            public void run() {
                LogsServicelmpl service = new LogsServicelmpl();
                try {
                    service.getLogsByDate(date);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        public static void main(String[] args) throws IOException {

            LogsServicelmpl service1 = new LogsServicelmpl();
            LocalDateTime start = LocalDateTime.now();

            /**/
            new MyFirstThread().start();  // 13 October
            new MyThread("2019-10-16").start();
            new MyThread("2019-10-17").start();
            new MyThread("2019-10-18").start();
            new MyThread("2019-10-19").start();






            System.out.println("TOTAL DURATION of threads"
                    + ChronoUnit.MILLIS.between(start, LocalDateTime.now()) + " ms");

            System.out.println("---------------------");
            start = LocalDateTime.now();

            service1.getLogsByDate("2019-10-14");
            service1.getLogsByDate("2019-10-16");
            service1.getLogsByDate("2019-10-17");
            service1.getLogsByDate("2019-10-18");
            service1.getLogsByDate("2019-10-19");

            System.out.println("TOTAL DURATION concequently "
                    + ChronoUnit.MILLIS.between(start, LocalDateTime.now()) + " ms");
            /*
             */
        }
    }


