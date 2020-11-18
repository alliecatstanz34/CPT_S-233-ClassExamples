import java.io.*;
import java.util.*;


public class Graph {
        
    private int V;
    
    private ArrayList<ArrayList<Integer>> adjList;

    Graph(int v){

        V = v;

        adjList = new ArrayList<ArrayList<Integer>> (v);
        for (int i = 0; i < v; i++){
            adjList.add(new ArrayList<Integer>());
        }

    }

    public void topologicalSort(){
        Stack<Integer> stack = new Stack<Integer>();

        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++){
            visited[i] = false;
        }

        for (int i = 0; i <V; i++){
            if(visited[i] == false){
                topologicalSortUtil(i,visited, stack);
            }
        }

    }

    public void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack){
        
        visited[v] = true;

        Integer i;

        Iterator<Integer> it = adjList.get(v).iterator();

        while(it.hasNext()){
            i = it.next()
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }

        stack.push(new Integer(v));



    }

}
