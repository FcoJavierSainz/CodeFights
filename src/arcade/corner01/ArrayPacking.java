package arcade.corner01;

/**
 * Created by JavierSainz on 11/9/16.
 */
public class ArrayPacking {
    int arrayPacking(int[] a) {
        int M = 0;
        for (int index = a.length - 1; index >= 0; index--) {
            M = (M << 8) + a[index];
        }
        return M;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayPacking().arrayPacking(new int[]{24, 85, 0}));
    }
}
