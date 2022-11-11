import java.util.Arrays;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Graph {
    Graph(){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("No of vetex: ");
//        int v = scan.nextInt();
//        System.out.println("No of edges: ");
//        int e = scan.nextInt();
//        int[][] edges = new int[v][v];
//        for (int i = 0; i < e; i++){
//            int fv = scan.nextInt();
//            int sv = scan.nextInt();
//            edges[fv][sv] = 1;
//            edges[sv][fv] = 1;
//        }

//        dfs(edges, 0);
//        bfs(edges);
//        MST(v,e,scan,edges); //MST stands for minimum spanning tree
//        MST(v,e, scan); //MST stands for minimum spanning tree
        solve();
    }


    public void dfs(int[][] edges, int fv){
        int n = edges.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!visited[i]) dfsHelper(edges, i, visited);
        }
    }

    public void dfsHelper(int[][] edges, int fv, boolean[] visited){
        System.out.println(fv);
        visited[fv] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++){
            if (edges[fv][i] == 1 && !visited[i]) dfsHelper(edges, i, visited);
        }
    }

    public void bfs (int[][] edges){
        int n = edges.length;
        boolean visited[] = new boolean[n];
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                Q.add(i);
                visited[i] = true;
                while (!Q.isEmpty()){
                    int vertex = Q.remove();
                    System.out.println(vertex);
                    for (int j = 0; j < n; j++){
                        if (edges[vertex][j] == 1 && !visited[j]){
                            visited[j] = true;
                            Q.add(j);
                        }
                    }
                }
            }
        }
    }

    //MST = Minimum Spanning trees
    public void MST(int v, int e, Scanner scan){
        Edge[]  input = new Edge[e];
        for (int i = 0; i < e; i++){
            input[i] = new Edge();
            input[i].source = scan.nextInt();
            input[i].destination = scan.nextInt();
            input[i].weight = scan.nextInt();
        }
        kruskals(input, v);
    }

    public void kruskals(Edge[] input, int n){
        Arrays.sort(input);

        Edge[] output = new Edge[n-1];

        int parent[] = new int[n];
        for (int i = 0 ; i < n; i++) parent[i] = i;

        int count = 0;
        int i = 0;

        while(count < n -1){
            Edge currentEdge = input[i];

            int sourceParent = findParent(parent,currentEdge.source);
            int destParent = findParent(parent,currentEdge.destination);

            if (sourceParent != destParent){
                output[count] = currentEdge;
                count++;
                parent[sourceParent] = destParent;
            }
            i++;
        }

        for (Edge x: output){
            System.out.println(x.source +" "+ x.destination+" " + x.weight);
        }
    }

    public int findParent(int[] parent, int i){
        if (parent[i] == i) return i;
        return findParent(parent,parent[i]);
    }

    public void MST(int v, int e, Scanner scan, int[][] adjacencyMatrix){

        for (int i = 0; i < e; i++){
            int fv = scan.nextInt();
            int sv = scan.nextInt();
            int weight = scan.nextInt();
            adjacencyMatrix[fv][sv] = weight;
            adjacencyMatrix[sv][fv] = weight;
        }

//        prims(adjacencyMatrix);
        dijkastra(adjacencyMatrix);
    }

    private void dijkastra(int[][] adjacencyMatrix) {
        int v = adjacencyMatrix.length;
        boolean[] visited = new boolean[v];
        int distance[] = new int[v];
        for (int i = 0; i < v; i++) distance[i] = Integer.MAX_VALUE;
        distance[0] = 0;

        for (int i = 0; i < v; i++){
            int minVertex = findMinVertex(distance,visited);
            visited[minVertex] = true;
            for (int j = 0; j < v; j++){
                if (adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MIN_VALUE){
                    int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    if (newDist < distance[j]){
                        distance[j] = newDist;
                    }
                }
            }
        }

        for (int i = 1; i < v; i++){
            System.out.println(i + " "+ distance[i]);
        }
    }

    private void prims(int[][] adjacencyMatrix) {
        int v = adjacencyMatrix.length;
        int[] parent = new int[v];
        int[] weight = new int[v];
        boolean[] visited = new boolean[v];
        weight[0] = 0;
        parent[0] = -1;
        for (int i = 0; i < v; i++) weight[i] = Integer.MAX_VALUE;

        for (int i = 0; i < v; i++){
            int minVertex = findMinVertex(weight, visited);
            visited[minVertex] = true;
            for (int j = 0; j < v; j++){
                if(adjacencyMatrix[minVertex][j] > 0 && !visited[j] ){
                    if (adjacencyMatrix[minVertex][j] < weight[j]){
                        weight[j] = adjacencyMatrix[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }

        for (int i = 1; i < v; i++){
            if (parent[i] < i){
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            }
            else System.out.println(i + " " + parent[i] + " " + weight[i]);
        }

    }

    public int findMinVertex(int[] weight, boolean[] visited){
        int minVertex = -1;

        for (int i = 0; i < weight.length; i++){
            if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])){
                minVertex = i;
            }
        }

        return minVertex;
    }

    //Codingninja quesions

    public void solve()
    {
        int N = 5;
        int M = 5;
//        String[] Graph = {"CANI","OOJN","DDIG","JNIN"};
        String[] Graph = {"DANDO","NNINJ","AXGJC","INJAA","CODDI"};
        //CANI
        //OOJN
        //DDIG
        //JNIN

        String S = "CODINGNINJA";
        int ans = 0;

        for (int j = 0; j < N; j++){
            for (int i = 0; i < Graph[j].length(); i++){
                if (Graph[j].charAt(i) == 'C' && ans == 0){
                    boolean[][] visited = new boolean[N][M];
                    ans = solveHelper(Graph, visited, j, i, S, 1);
                    // System.out.println("NO");
                }
            }
        }

        System.out.println(ans);
    }

    //Codingninja quesions
    int solveHelper(String[] Graph, boolean[][] visited, int i, int j, String S, int index){
        if (index > S.length() - 1) return 1;

        visited[i][j] = true;
        // System.out.println("HI");

        int ans = 0;

        int N = Graph.length;
        int M = Graph[0].length();


        int a = i - 1;
        int b = j - 1;
        if ( ans == 0 && a >= 0 && b >= 0 && Graph[a].charAt(b) == S.charAt(index) && !visited[a][b]) {
            System.out.println("(" + a + ", " + b + ")" + Graph[a].charAt(b) +" "+S.charAt(index) );
            ans = solveHelper(Graph, visited, a, b, S, index + 1);
//            visited[a][b] = false;
        }

        a = i - 1;
        b = j;
        if ( ans == 0 && a >= 0 && Graph[a].charAt(b) == S.charAt(index) && !visited[a][b]){
            System.out.println("(" + a + ", " + b + ")" + Graph[a].charAt(b) +" "+S.charAt(index) );
            ans = solveHelper(Graph, visited, a, b, S, index + 1);
//            visited[a][b] = false;
        }

        a = i - 1;
        b = j + 1;
        if ( ans == 0 && a >= 0 && b < M && Graph[a].charAt(b) == S.charAt(index) && !visited[a][b]){
            System.out.println("(" + a + ", " + b + ")" + Graph[a].charAt(b) +" "+S.charAt(index) );
            ans =  solveHelper(Graph, visited, a, b, S, index + 1);
//            visited[a][b] = false;
        }

        a = i;
        b = j - 1;
        if ( ans == 0 && b >= 0 && Graph[a].charAt(b) == S.charAt(index) && !visited[a][b]) {
            System.out.println("(" + a + ", " + b + ")" + Graph[a].charAt(b) +" "+S.charAt(index) );
            ans = solveHelper(Graph, visited, a, b, S, index + 1);
//            visited[a][b] = false;
        }

        a = i;
        b = j + 1;
        if (ans == 0 &&  b < M && Graph[a].charAt(b) == S.charAt(index) && !visited[a][b]){
            System.out.println("(" + a + ", " + b + ")" + Graph[a].charAt(b) +" "+S.charAt(index) );
            ans = solveHelper(Graph, visited, a, b, S, index + 1);
//            visited[a][b] = false;
        }

        a = i + 1;
        b = j - 1;
        if ( ans == 0 && a < N && b >= 0 && Graph[a].charAt(b) == S.charAt(index) && !visited[a][b]){
            System.out.println("(" + a + ", " + b + ")" + Graph[a].charAt(b) +" "+S.charAt(index) );
            ans = solveHelper(Graph, visited, a, b, S, index + 1);
//            visited[a][b] = false;
        }

        a = i + 1;
        b = j;
        if ( ans == 0 && a < N && Graph[a].charAt(b) == S.charAt(index) && !visited[a][b]){
            System.out.println("(" + a + ", " + b + ")" + Graph[a].charAt(b) +" "+S.charAt(index) );
            ans = solveHelper(Graph, visited, a, b, S, index + 1);
//            visited[a][b] = false;
        }

        a = i + 1;
        b = j + 1;
        if (ans == 0 &&  a < N && b < M && Graph[a].charAt(b) == S.charAt(index) && !visited[a][b]){
            System.out.println("(" + a + ", " + b + ")" + Graph[a].charAt(b) +" "+S.charAt(index) );
            ans = solveHelper(Graph, visited, a, b, S, index + 1);
//            visited[a][b] = false;

        }
        visited[i][j] = false;
//        System.out.println("Hi");
        return ans;

    }

}


/*
krushal's
source: destination: weight
6 11
2 4 9
3 4 11
0 3 3
1 3 1
4 5 5
2 3 6
1 2 8
3 5 7
0 2 4
0 1 2
2 5 10

source: destination: weight
5 7
0 1 4
0 2 8
1 3 6
1 2 2
2 3 3
2 4 9
3 4 5


coding ninja
5 5
DANDO
NNINJ
AXGJC
INJAA
CODDI

 */
