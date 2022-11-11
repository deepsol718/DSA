import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrabalExam {


//    public static int jumps(int[] arr, int i, int min){
//        if (i >= arr.length){
//            return min ;
//        }
//
//        int n = arr[i];
//
//        int ans = Integer.MAX_VALUE;
//
//        for (int j = n; j > 0; j--){
//            int temp  = jumps(arr, i + j, min +1);
//            if (ans > temp) ans = temp;
//
//        }
//
//        return ans;
//    }
//
//    static int minJumps(int arr[], int l, int h)
//    {
//        // Base case: when source
//        // and destination are same
//        if (h == l)
//            return 0;
//
//        // When nothing is reachable
//        // from the given source
//        if (arr[l] == 0)
//            return Integer.MAX_VALUE;
//
//        // Traverse through all the points
//        // reachable from arr[l]. Recursively
//        // get the minimum number of jumps
//        // needed to reach arr[h] from these
//        // reachable points.
//        int min = Integer.MAX_VALUE;
//        for (int i = l + 1; i <= h
//                && i <= l + arr[l];
//             i++) {
//            int jumps = minJumps(arr, i, h);
//            if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
//                min = jumps + 1;
//        }
//        return min;
//    }

    public static void exam(){
//        int[] arr = new int[]{1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
//
//        int ans = jumps(arr,0,0);
//
//        if (ans == Integer.MAX_VALUE){
//            System.out.println("infinite");
//        }
//        else{
//            System.out.println(ans);
//        }
//
//        ans = minJumps(arr, 0, arr.length-1);
//        System.out.println("gfg ans: "+ ans);
        Scanner scan = new Scanner(System.in);
        int noOfPlayers = scan.nextInt();

        Map<Integer, Player> playerMap = new HashMap<>();
        for (int i = 1; i <= noOfPlayers; i++) {
            Player player = new Player(scan.next(), scan.nextInt(), scan.nextDouble());
            playerMap.put(i, player);
        }
        scan.close();
        Map<Player,Integer> treeMapOfPlayers = getMapOfSelectedPlayers(playerMap);
        System.out.println(treeMapOfPlayers);

    }

    public static TreeMap<Player, Integer> getMapOfSelectedPlayers(Map<Integer, Player> playerMap){
        List<Player> list = new ArrayList<>();

        for (int i = 1; i <= playerMap.size(); i++){
            list.add(playerMap.get(i));
        }
       // System.out.println("list size: "+list.size());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }

        TreeMap<Player, Integer> ans = new TreeMap<>();

        for (int i = 0; i < list.size(); i++){
            ans.put(list.get(i),list.get(i).getNoOfGoals());
        }

        return ans;
    }

}
