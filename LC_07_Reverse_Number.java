public class LC_07_Reverse_Number {
    public int reverse(int x) {
        boolean sign = x < 0;
        //long is used to handle more than max values
        String str = String.valueOf(Math.abs((long)x)); 
        StringBuilder sb = new StringBuilder(str).reverse();
        try {
            int num = Integer.parseInt(sb.toString());
            if (sign) {
                num = -num;
            }
            return num;
        } catch (NumberFormatException e) {
            return 0; //means no out of integer range
        }
    }
}
