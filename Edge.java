public class Edge implements Comparable<Edge>{
    int source;
    int destination;
    int weight;
    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
