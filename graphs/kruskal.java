import java.util.ArrayList;

public class kruskal {
    
    static class implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int wt){
            this.src = s;
            this.dest= d;
            this.wt= wt;
    }
    @Override
    public int compareTo(Edge e2){
        return this.wt-e2.wt;
    }
}

public void kruskal(ArrayList<Edge> edges , int V){

    Collections.sort(edges);
    int mstCost=0;
    int count =0;

    for(int i =0;count<V-1;i++){
        Edge e = edges.get(i);
        int parA = find(e.src);
        int parB = find(e.dest);
        if(parA!=parB){
            union(parA,parB);
            mincost +=e.wt;
            count++;
        }
    }
    }


}
