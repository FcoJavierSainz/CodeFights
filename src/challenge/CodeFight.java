package challenge;

/**
 * Created by JavierSainz on 12/16/16.
 */
public class CodeFight {

    String[] CodeFight(int n) {
        String[] s = new String[n];
        for (; n > 0; n--)
            s[n - 1] = (n % 5 > 0 ? "" : "Code") + (n % 7 > 0 ? n %  5 > 0? n : "" : "Fight");
        return s;
    }

    String[] CodeFight2(int n) {
        String e = "", s= e;
        for (; n > 0; n--)
            s = (n % 5 > 0 ? e : "Code") + (n % 7 > 0 ? n %  5 > 0? n : e : "Fight") + "," + s;
        return s.split(",");
    }
}
