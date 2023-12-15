package graphs;

import java.util.*; 

class graph_intro{

    static class Edges{

        int src ;
        int dest;
        int weight;

        public Edges(int s, int d, int wt){

            this.src = s;
            this.dest =d;
            this.weight = wt;

        }

        /*
         *                           {6}
         *                    5 -----------------1 
         *                                        \ 
         *                                         \    2
         *                                      {4}  \  /{2}
         *                                          \ /
         *                                3 ---------0--------4
         *                                       {2}    {3}
        */


        public static void main(String[] args) {
            int V =6;
            ArrayList<Edges>[]   graph = new ArrayList[V];   //NULL 

            for(int i =0;i<V;i++){
                graph[i] = new ArrayList<>();
            }

                graph[0].add(new Edges(0,1,4));
                 graph[0].add(new Edges(0,2,2));
                  graph[0].add(new Edges(0,3,2));
                   graph[0].add(new Edges(0,4,3));

                graph[1].add(new Edges(1, 6, 5));
                 graph[1].add(new Edges(1, 0, 4));


                 //so on


                 //0's Neighbours

                 for(int i =0;i<graph[2].size();i++){
                    Edges e = graph[2].get(i);
                    System.out.println(e.dest);
                 }
        }
    }
}