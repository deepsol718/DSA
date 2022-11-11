public class DynamicProgramming {
    DynamicProgramming(){
//    sumEqualToK();\
//        int[][] arr = {{5,7,2,4},{1,8,1,3},{6,2,9,5},{1,6,2,8}};
//        for (int[] x: arr){
//            for (int y : x){
//                System.out.print(y+" ");
//            }
//            System.out.println();
//        }
//        System.out.println(minCostPath(arr));
//        new Pattern();
        lcs();//longest common substring
    }

    private void lcs() {
        String s1 = "sdfsf";
        String s2 = "dfgvbrghcf";
        int ans = lcsHelper(s1,s2);
    }

    private int lcsHelper(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) return 0;

        if (s1.charAt(0) == s2.charAt(0)){
            return 1 + lcsHelper(s1.substring(1) , s2.substring(1));
        }
        else{
            int one = lcsHelper(s1, s2.substring(1));
            int two = lcsHelper(s1.substring(1), s2);
            return Math.max(one,two);
        }
    }


    public void sumEqualToK(){
        int[] coins = {1,2,3,4,5,6};

        int sum = 6;
        printCoinsUpToK(coins, sum, "");

    }

    public void printCoinsUpToK(int[] coins, int k, String s){
        if (k == 0){
            System.out.println(s);
            return;
        }
        if (k < 0) return;

        for (int i = 0; i < coins.length; i++){
            printCoinsUpToK(coins,k-coins[i], s +" "+coins[i]);
        }
    }

    public static int minCostPath(int[][] input) {
        int m = input.length;
        int n = input[0].length;
        int[][] dp = new int[m][n];

        int index = 1;

        int min = Math.min(m,n);

        while(index <= min){
            int i = m - index;
            int j = n - index;
            for ( ; i >=0; i-- ){
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                int c = Integer.MAX_VALUE;

                if (i + 1 < m) a = dp[i+1][j];
                if (j + 1 < n) b = dp[i][j+1];
                if (i + 1 < m && j + 1 < n) c = dp[i+1][j+1];

                int minimum = Math.min(a,Math.min(b,c));

                if (minimum == Integer.MAX_VALUE){
                    dp[i][j] = input[i][j];
                    continue;
                }

                dp[i][j] = input[i][j] + minimum;

            }

            i = m - index;
            for ( ; j >=0; j-- ){
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                int c = Integer.MAX_VALUE;

                if (i + 1 < m) a = dp[i+1][j];
                if (j + 1 < n) b = dp[i][j+1];
                if (i + 1 < m && j + 1 < n) c = dp[i+1][j+1];

                int minimum = Math.min(a,Math.min(b,c));

                if (minimum == Integer.MAX_VALUE){
                    dp[i][j] = input[i][j];
                    continue;
                }

                dp[i][j] = input[i][j] + minimum;

            }

            index++;
        }
//        for (int[] x: dp){
//            for (int y : x){
//                System.out.print(y+" ");
//            }
//            System.out.println();
//        }
        return dp[0][0];
    }
}
