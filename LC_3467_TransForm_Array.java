public class LC_3467_TransForm_Array {
    public int[] transformArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        while(i<n){
            if(arr[i]%2 == 0){
                arr[j++] = 0;
            }
            i++;
        }
        while(j<n){
            arr[j++]=1;
        }
        return arr;
    }
}