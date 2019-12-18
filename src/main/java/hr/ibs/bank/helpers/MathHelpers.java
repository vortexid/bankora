package hr.ibs.bank.helpers;

public class MathHelpers {

    public static Double RoundDouble(Double num, int dec ) {

        Double scale = Math.pow(10,dec);

        return Math.round(num*scale)/scale;

    }

}
