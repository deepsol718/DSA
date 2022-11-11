
public class Solution {
	
		
public static void placeNQueens(int n){
    
    for (int i = 0; i < n; i++){
        int[] column = new int[n];
        column[0] = i;
        placeNQueens(column, 1);
    }
	}
    
    
public static void placeNQueens(int[] column, int j){
    int n = column.length;
    
    if (j == n){
        for (int i = 0; i < n; i++){
            for (int k = 0; k < n; k++){
                if (k == column[i]){
                    System.out.print(1+" ");
                }
                else System.out.print(0+" ");
            }
        }
        
        System.out.println();
        return;
    }
    
    int[] row = new int[n];
    
    for (int i = 0; i < j; i++){
        int index = column[i];
        row[index] = 1;
        if (index + (j-i) < n) row[index + (j-i)] = 1;
        if (index - (j-i) >= 0) row[index - (j-i)] = 1;
    }
    
    for (int i = 0; i < n; i++){
        if (row[i] == 0){
            column[j] = i;
            placeNQueens(column, j+1);
        }
    }
}
	
}
