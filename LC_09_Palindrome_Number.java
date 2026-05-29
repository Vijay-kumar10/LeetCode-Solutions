public class LC_09_Palindrome_Number {
     public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int n = str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i) != str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
}
