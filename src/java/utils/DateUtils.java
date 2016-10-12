/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author macintoshhd
 */
public class DateUtils {

    public static boolean isAfterDate(String val) {
        boolean isAfter = false;
        Date date, currentDate;
        SimpleDateFormat formatter = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                Locale.ENGLISH);
        try {
            date = formatter.parse(val);
            Date current = new Date();
            String dat = formatter.format(current);
            currentDate = formatter.parse(dat);
            if (date.after(currentDate)) {
                isAfter = true;
            } else {
                isAfter = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAfter;
    }

    public static String formatDate(String val) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        SimpleDateFormat sdfs = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                Locale.ENGLISH);
        String result = null;
        try {
            Date current = sdfs.parse(val);
            result = sdfs.format(current);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
