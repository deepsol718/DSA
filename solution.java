/*
	To apply the method explained in the hint video, we have to add two more parameters in the function call. This can be done by calling a helper function from given function. The helper function can have three parameters: array, start index, end index.

	Skeleton code to achieve this:
	public class Solution {
		public static void quickSort(int[] input, int startIndex, int endInedx) {
			// your code goes here
		}

		public static void quickSort(int[] input) {
			quickSort(input, 0, input.length - 1);
		}

	}

*/


import java.util.Scanner;

public class solution {



    public static void solver(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();

        int[] A = new int[n];

        for (int i = 0; i < n; i++){
            A[i] = scan.nextInt();
        }

        mergeSort(A, 0, n-1);

        int count = 1;

        for(int i = 1; i < n; i++)
        {
            if (A[i] != A[i-1]) count++;
        }

       // System.out.println("non repeated elements: "+count);

        int[] arr = new int[count];

        int j = 0;
        arr[j]++;
        for (int i = 1; i < n; i++){

            if ( A[i] != A[i-1] ){
                j++;

            }
            arr[j]++;

        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++)
        {
            //System.out.print(arr[i]+" ");
            if (arr[i] > 1) sum += arr[i] - 1;
        }

        x -= sum;

        if (x > 0){
            x = arr.length - x;
        }
        else
        {
            x = arr.length;
        }

        System.out.println(x);


    }

    public static void mergeSort(int[] A, int b, int e)
    {
        int mid = (b+e)/2;

        if (b>=e) return ;

        mergeSort(A,b,mid);
        mergeSort(A,mid+1,e);

        merge(A,b,e);
    }

    public static void merge(int[]A, int b, int e){
        int mid = (b+e)/2;

        int n = e-b+1;

        int[] ans = new int[n];

        int j = b, k = mid+1;

        for (int i = 0; i < n; i++){
            int B = Integer.MAX_VALUE, C = Integer.MAX_VALUE;

            if (j <= mid) B = A[j];
            if (k <= e) C = A[k];

            if (B < C)
            {
                ans[i] = B;
                j++;
            }
            else
            {
                ans[i] = C;
                k++;
            }


        }

        for (int i = 0; i < n ; i++){
            A[b+i] = ans[i];
        }
    }
}