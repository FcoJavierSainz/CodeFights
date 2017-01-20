package challenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JavierSainz on 1/19/17.
 */
public class PossibleRing {
    int possibleRingClean(String formula) {
        int carbons = 0; // (C);
        int nitrogens = 0; // (N);
        int hydrogens = 0; // (H);
        int oxygens = 0; // (O);
        int halogens = 0; // (Cl, F, Br or I).
        Pattern pattern = Pattern.compile("([A-Z][a-z]*)(\\d*)");
        Matcher matcher = pattern.matcher(formula);
        while (matcher.find()) {
            String countString = matcher.group(2);
            int count = countString.isEmpty() ? 1 : Integer.parseInt(countString);
            switch (matcher.group(1)) {
                case "C":
                    carbons += count;
                    break;
                case "N":
                    nitrogens += count;
                    break;
                case "H":
                    hydrogens += count;
                    break;
                case "O":
                    oxygens += count;
                    break;
                default:
                    halogens += count;

            }
        }
        System.out.println("C: " + carbons + ", H: " + hydrogens + ", N: "
                + nitrogens + ", O: " + oxygens + ", Ha: " + halogens);
        //DBE = <number of carbons> + <number of nitrogens>/2 - <number of hydrogens and halogens>/2 + 1
        double dbe = carbons + nitrogens / 2.0 - (hydrogens + halogens) / 2.0 + 1;
        //If DBE is not an integer, it is invalid.
        if (Double.isInfinite(dbe) || dbe % 1 != 0) {
            return -1;
        }
        //the number of rings can't be greater than
        //<number of carbons> + <number of nitrogens> + <number of oxygens> - 2
        if (dbe > (carbons + nitrogens + oxygens - 2)) {
            return -1;
        }

        if (dbe <= 0) {
            return -1;
        }

        return (int) dbe;
    }

    int possibleRing(String f) {
        int c = 0, n = 0, h = 0, o = 0, a = 0, t;
        Matcher m = Pattern.compile("([A-Z][a-z]*)(\\d*)").matcher(f);
        while (m.find()) {
            String s = m.group(2);
            t = s.isEmpty() ? 1 : Integer.parseInt(s);
            switch (m.group(1)) {
                case "C":
                    c = t;
                    break;
                case "N":
                    n = t;
                    break;
                case "H":
                    h = t;
                    break;
                case "O":
                    o = t;
                    break;
                default:
                    a += t;

            }
        }
        double x = 2, dbe = c + n / x - (h + a) / x + 1;
        if (dbe % 1 != 0 || dbe > c + n + o - x || dbe <= 0)
            return -1;
        return (int) dbe;
    }

    public static void main(String[] args) {
        System.out.println(new PossibleRing().possibleRing("C2H4O"));
    }

}
