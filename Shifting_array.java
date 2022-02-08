

// for any help or suggestion email me deepaksolanki9759@gmail.com
//This particular program is written to shift the whole array, we can also make changes in program to find value at a particular ind

import java.util.Arrays;

class Main {

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10}; // creating a simple array or this value can be user taken also.
        int n = arr.length; //length of array, in this particular case it 10
        int k = 1; //number of times we want to shift our array, for example if it is 1 then our array will be {10,1,2,3,4,5,6,7,8,9,10}
        k = k%n; //reducing the value of k because 2k = 3k = 4k means the same thing b
        int[] narr = new int[n]; //  new array to store the shifted array
        for (int i =  0; i<n; i++){
            int temp = (i-k<0)? i-k+n:i-k; //this particular line does the magic
            narr[i] = arr[temp];
        }

        System.out.println(Arrays.toString(narr));

    }

}
