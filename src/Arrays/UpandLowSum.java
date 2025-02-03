package Arrays;

public class UpandLowSum {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6} ,{7,8,9}};
        getSum(arr);
    }

    static void getSum(int[][] arr){
        int n = arr.length -1 , m = arr[0].length - 1;

        int upSUM = 0;
        int downSum = 0;
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= n - i ; j++){
                upSUM += arr[i][j];
            }

            for(int k = n ; k >= n - i ; k--){
                downSum += arr[i][k];
            }
        }

        System.out.println(upSUM +  " " + downSum);

    }
}
