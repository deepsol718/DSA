public class Solution {

	public static int numConnected(int[][] edges, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        
    	for (int i = 0; i < n; i++){
            if (!visited[i]){
                count++;
                numConnected(edges, visited, i);
            }
        }
        
        return count;
	}
    
    public static void numConnected(int[][] edges, boolean[] visited, int index){
        visited[index] = true;
        
        for (int i = 0; i < edges.length; i++){
            if (!visited[i] && edges[index][i] == 1){
                numConnected(edges, visited, i);
            }
        }
        
    }


}
