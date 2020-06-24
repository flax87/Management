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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class LogsServicelmpl {

    private String dateTime;

    public LogsServicelmpl() {
    }

    public LogsServicelmpl(String dateTime) {
        this.dateTime = dateTime;
    }
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /*
     *
     * @param String str - a date of searching in a format yyyy-mm-dd
     *
     * */

    public int getLogsByDate(String str) throws IOException {
        LocalDateTime start = LocalDateTime.now();
        System.out.println(str + " search is started at - " + start);


        int count = (int) Files.lines(Paths.get("C:\\Users\\London\\Desktop\\logs.txt"))
                .filter(line -> line.contains(str))
                // .filter(line -> line.contains("ERROR"))
                .count();

        LocalDateTime finish = LocalDateTime.now();


        long duration = ChronoUnit.MILLIS.between(start, finish);

        System.out.println(str + " search is OVER at - " + LocalDateTime.now() + ". duration - "+ duration);
        System.out.println("lines amount - " + count);

        return count;
    }

    private void toFile(List<String> list, String fileAndPath) throws IOException {

        String stringToFile = "";

        for (String line:list){
            stringToFile += line + System.lineSeparator();
        }
        Files.write(Paths.get(fileAndPath), stringToFile.getBytes());

    }


}