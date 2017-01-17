package challenge;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by JavierSainz on 1/16/17.
 */
public class StringsRearrangement {
    boolean stringsRearrangement(String[] r) {
        int l = r.length, c, i = 0, j, k, v;
        int [][] a = new int[l][l];
        for (; i < l; i++)
            for (j = 0; j < l; j++) {
                String f = r[i], s = r[j];
                c = 0;
                for (k = 0; k < f.length(); k++)
                    if (f.charAt(k) != s.charAt(k))
                        c++;
                a[i][j] = c == 1 ? 1 : 0;
            }

        int[] p = new int[l];
        i = 0;
        while (i<l)
            p[i] = i++;
        do{
            v = 1;
            for(i=0; i< l - 1; i++)
                if(a[p[i]][p[i+1]] == 0){
                    v = 0;
                    break;
                }
            if(v > 0)
                return true;
        } while(n(p));
        return false;
    }
    boolean n(int[] a) {
        int l = a.length, i = l - 1, j = i, t;
        while (i > 0 && a[i - 1] >= a[i])
            i--;
        if (i < 1)
            return false;
        while (a[j] <= a[i - 1])
            j--;
        t = a[i - 1];
        a[i - 1] = a[j];
        a[j] = t;

        j = l - 1;
        while (i < j) {
            t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
        return true;
    }

    boolean stringsRearrangementClean(String[] inputArray) {
        int length = inputArray.length;
        int [][] adjacentList = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    String first = inputArray[i];
                    String second = inputArray[j];
                    int differentLettersCount = 0;
                    for (int index = 0; index < first.length(); index++) {
                        if (first.charAt(index) != second.charAt(index)) {
                            differentLettersCount++;
                        }
                    }
                    if (differentLettersCount == 1) {
                        adjacentList[i][j] = 1;
                    }
                }
            }
        }

        int[] path = new int[length];
        for(int i=0; i<length; i++) {
            path[i] = i;
        }
        do{
            boolean valid=true;
            for(int i=0; i< length - 1; i++){
                if(adjacentList[path[i]][path[i+1]] == 0){
                    valid = false;
                    break;
                }

            }
            if(valid) {
                return true;
            }
        } while(nextPermutation(path));
        return false;
    }


    boolean nextPermutation(int[] array) {
        // Find longest non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i < 1)
            return false;

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // Successfully computed the next permutation
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new StringsRearrangement()
                .stringsRearrangement(
                        new String[]{"aba",
                                "bbb",
                                "bab"}
                        ));
    }
}
