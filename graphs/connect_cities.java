/*
 * 
 * Connecting cities with minimum cost
 * 
 * 
 * 
 * saale question solve krne ko bhi premium lete h :(
 * 
 * //we will use prims algo
 */

import java.util.*;
 public class Edge{

    int dest;
    int cost;

    public Edge(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }

    class Solution{

        public int connectCities(int cities[][]){

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean visited[] = new boolean[cities.length];
            int finalcost =0;
            pq.add(new Edge(0, 0));

            while (!pq.isEmpty()) {
                Edge curr = pq.remove();
                if(!visited[curr.dest]){
                    visited[curr.dest] = true;
                    finalcost+= curr.cost;

                    for(int i =0;i<cities[curr.dest].length;i++){
                        if(cities[curr.dest][i]!=0){
                            pq.add(new Edge(i, cities[curr.dest][i]));
                        }
                    }
                }
                
            }
            return finalcost;
        }
    }
 }