public class SegmentTree {
    
    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }

    public static int buildST(int arr[],int i,int s,int e){
        if(s==e){
            tree[i] = arr[s];
            return arr[s];
        }
        int mid = (s+e)/2;
        int left = buildST(arr,2*i+1,s,mid);
        int right = buildST(arr,2*i+2,mid+1,e);
        tree[i] = left+right;
        return tree[i];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);
        for(int a : tree){
            System.out.print(a+", ");
        }
    }
}
