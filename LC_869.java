import java.util.Arrays;

public class LC_869 {
    public boolean reorderedPowerOf2(int n) {
        String target = sortStr(String.valueOf(n));
        int power = 1;
        for (int i = 0; i <= 30; i++) {
            if (sortStr(String.valueOf(power)).equals(target)) {
                return true;
            }
            power *= 2;
        }
        return false;
    }

    // sort function to sort the digit
    public String sortStr(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
