public class LC_59 {

    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int sr = 0; //Start row
        int er = n-1; //end row
        int sc = 0; //Start column
        int ec = n-1; //end column
        int count = 1;
        while(sr<=er && sc<=ec){
            //upper
            for(int i=sc;i<=ec;i++){
                arr[sr][i] = count++;
            }
            //right
            for(int i=sr+1; i<=er;i++){
                arr[i][ec] = count++;
            }
            //bottum
            for(int i=ec-1;i>=sc;i--){
                if(sr==er){break;}
                arr[er][i] = count++;
            }
            //left
            for(int i=er-1;i>=sr+1;i--){
                if(sc==ec){break;}
                arr[i][sc] = count++;
            }
            sr++; er--; sc++; ec--;
        }
        return arr;   
    }
}