package util;

public class PNRGenerator {

    private static int nextPNR = 1000000000;

    public static String generatePNR() {

        String pnr = String.valueOf(nextPNR);
        nextPNR++;

        return pnr;
    }
}