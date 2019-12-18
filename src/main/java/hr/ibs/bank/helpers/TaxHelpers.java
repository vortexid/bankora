package hr.ibs.bank.helpers;

import java.time.LocalDate;

public class TaxHelpers {

    public static String getJOOPId(LocalDate date) {
        return String.valueOf(((date.getYear()-2000)*1000)+date.getDayOfYear());
    }

}
