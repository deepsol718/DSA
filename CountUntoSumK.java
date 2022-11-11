import java.util.Arrays;

public class CountUntoSumK {

    public static int threeSum(int[] arr, int k){
        int max = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i]>max) max = arr[i];
        }

        int[] brr = new int[max+1];

        for (int i = 0; i < arr.length; i++){
            brr[arr[i]]++;
        }

        System.out.println(Arrays.toString(brr));


        int count = 0;

        for (int i = 0 ; i < brr.length; i++){
            int t = brr[i];
            if ( t>0 && (k-i) > -1 ){
                brr[i]--;
                System.out.print("i :"+i+", k :"+(k-i)+", Count : ");
                count += t*twoSum(k-i,brr);
                brr[i] = t;
            }

            if (3*i == k){
                count += (t*(t-1)*(t-2))/2;
            }
        }

        return count/3;
    }

    // the function is connected to three sum, therefore it can not be used separately for twoSum
    public static int twoSum (int k, int[] arr){
        int count = 0;

        int[] brr = new int[arr.length];

        for (int i = 0 ; i < brr.length; i++){
            brr[i] = arr[i];
        }

        //System.out.println(Arrays.toString(brr));

        for (int i = 0; i < brr.length; i++){
            if (brr[i]>0 && (k-i) > -1 && (k-i) <= brr.length){
                if (brr[k-i]>0 && 2*i != k){
                    count += brr[i]*brr[k-i];
                    brr[i] = 0;
                    brr[k-i] = 0;
                }
                if (2*i == k){
                    count += (brr[i]-1)*brr[i]/2;
                }
            }
        }
        System.out.print(count);
        System.out.println("");
        return count;

    }

    
}
