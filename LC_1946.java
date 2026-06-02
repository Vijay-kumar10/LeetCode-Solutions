public class LC_1946 {

     public String maximumNumber(String num, int[] arr) {
        boolean flag = false;
        StringBuilder sb = new StringBuilder(num);
        for(int i=0;i<num.length();i++){
            int digit = num.charAt(i)-'0';
            int newDigit = arr[digit];
            if(newDigit > digit){
            flag = true;
            sb.setCharAt(i, (char)(newDigit + '0'));
            }else if(flag && newDigit < digit){
                break;
            }
        }
        return sb.toString();
    }
}