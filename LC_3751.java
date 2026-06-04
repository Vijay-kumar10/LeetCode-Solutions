public class LC_3751 {
     public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i=num1;i<=num2;i++){
            if(i<100){ continue;} //skip this number
            int temp = i;
            int right = temp%10;  //rightMost element
            temp /= 10;
            int curr = temp%10;  //current mid element
            temp /= 10;
            while(temp>0){
                int left = temp%10;
                if(( (curr>left) && (curr>right) ) || (  (curr<left) && (curr<right)  )){
                    count++;
                }
                //now update the left,right,curr for next iteration
                right = curr;
                curr = left;
                temp /=10;
            }
        }
        return count;
    }
}
