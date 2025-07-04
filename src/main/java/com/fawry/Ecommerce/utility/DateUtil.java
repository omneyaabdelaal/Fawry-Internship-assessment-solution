package com.fawry.Ecommerce.utility;

import java.time.LocalDate;

public class DateUtils {
    public static boolean isExpired(LocalDate expiryDate) {
        return LocalDate.now().isAfter(expiryDate);
    }

    public static boolean isValidExpiryDate(LocalDate expiryDate) {
        return expiryDate != null && !expiryDate.isBefore(LocalDate.now());
    }
}