import java.util.PriorityQueue;
import java.util.Queue;

public class a1514MaximumProbablityPath {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] distances = new double[n];
        distances[start_node] = 1;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> Double.compare(distances[b],distances[a]));
        queue.add(start_node);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(visited[node])
                continue;
            visited[node] = true;
            for(int i = 0; i < edges.length; i++){
                if(edges[i][0] == node){
                    int next = edges[i][1];
                    if(distances[next] < distances[node] * succProb[i]){
                        distances[next] = distances[node] * succProb[i];
                        queue.add(next);
                    }
                }
                else if(edges[i][1] == node){
                    int next = edges[i][0];
                    if(distances[next] < distances[node] * succProb[i]){
                        distances[next] = distances[node] * succProb[i];
                        queue.add(next);
                    }
                }
            }
        }
        return distances[end_node];
    }
    public static void main(String[] args){
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0;
        int end = 2;
        a1514MaximumProbablityPath prob = new a1514MaximumProbablityPath();
        System.out.println(prob.maxProbability(n,edges,succProb,start,end));
    }
}
