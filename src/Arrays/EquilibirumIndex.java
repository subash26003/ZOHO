package Arrays;

public class EquilibirumIndex {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,-1};

        int sum = a[0];
        int[] indexSum = new int[a.length];

        for(int i = 1 ; i < a.length ; i++){
            indexSum[i] = sum;
            sum += a[i];
        }

        int index = -1;
        int rightSum = a[a.length-1];
        for(int i = a.length - 2  ; i >= 0 ; i--){
            if(indexSum[i] == rightSum){
                index = i;
            }
            rightSum += a[i];
        }

        System.out.println(index);

    }
}
