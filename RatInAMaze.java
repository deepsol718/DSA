
public class Solution {
     static int[][] step = {{0,-1},{-1,0},{0,1},{1,0}};

	public static boolean ratInAMaze(int maze[][]){
		int n = maze.length;
		
        boolean visited[][] = new boolean[n][n];
        
        return ratInMaze(maze,visited, 0, 0);

	}
    
	public static boolean ratInMaze(int maze[][], boolean[][] visited, int i, int j){
        int n = maze.length;
        if (i == n-1 && j == n-1) return true;
        
        visited[i][j] = true;
        
        boolean ans = false;
        
        for (int k = 0; k < step.length; k++){
            int a = i + step[k][0];
            int b = j + step[k][1];
            
            if (a >= 0 && a < n && b >= 0 && b < n && !visited[a][b] && !ans && maze[a][b] == 1){
                ans = ratInMaze(maze, visited, a, b);
            }
        }
        
        visited[i][j] = false;
        
        return ans;
    }
}
