public class PrintSubsetsSumK {
    public static void printSubsets(int[] input, int i, int[] arr, int k){

        if (input.length == i){
            if (k==0){
                for (int j = 0; j < arr.length; j++){
                    System.out.print(arr[j]+" ");
                }
                System.out.println("");
            }
            return;
        }

        int[] newArr = new int[arr.length+1] ;

        for (int j = 0; j < arr.length; j++){
            newArr[j] = arr[j];
        }

        newArr[arr.length] = input[i];

        printSubsets(input, i+1,arr, k);
        printSubsets(input, i+1,newArr, k-input[i]);

    }
}
