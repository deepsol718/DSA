/*
	Note:
	To get all the test cases accepted, make recursive calls in following order: Top, Down, Left, Right.
	This means that if the current cell is (x, y), then order of calls should be: top cell (x-1, y), 
	down cell (x+1, y), left cell (x, y-1) and right cell (x, y+1).
*/  

public class Solution {
    static int[][] step = {{0,-1},{-1,0},{0,1},{1,0}};


	static void ratInAMaze(int maze[][], int n) {
		boolean visited[][] = new boolean[n][n];
        int[][] path = new int[n][n];
        path[0][0] = 1;
        ratInMaze(maze,visited, 0, 0, path, n);
        
	}
    
    public static void ratInMaze(int maze[][], boolean[][] visited, int i, int j, int[][] path, int n){
        if (i == n-1 && j == n-1){
            path[i][j] = 1;
            for (int[] x : path){
                for (int y : x) System.out.print(y+" ");
            }
            System.out.println();
            return;
        }
        
        visited[i][j] = true;
        
        boolean ans = false;
        
        for (int k = 0; k < step.length; k++){
            int a = i + step[k][0];
            int b = j + step[k][1];
            
            if (a >= 0 && a < n && b >= 0 && b < n && !visited[a][b] && !ans && maze[a][b] == 1){
                path[a][b] = 1;
                ratInMaze(maze, visited, a, b, path,n);
            }
        }
        
        visited[i][j] = false;
        path[i][j] = 0;
    
    }

}

