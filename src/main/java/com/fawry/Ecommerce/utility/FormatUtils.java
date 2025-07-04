package com.fawry.Ecommerce.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatUtils {
    public static String formatMoney(double amount) {
        return String.format("%.2f", amount);
    }

    public static String formatWeightInKg(double weight) {
        return String.format("%.1f", weight);
    }
    public static String formatWeightInGram(double weight) {
        return String.format("%.0fg", weight * 1000);
    }

    public static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}

