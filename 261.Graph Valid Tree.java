/*
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree. 

For example: 

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true. 

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false. 
*/


public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] node = new int[n];
        for (int i = 0; i < n; ++i) node[i] = i;
        for (int i = 0; i < edges.length; ++i) {
            int p = edges[i][0];
            int q = edges[i][1];
            if (find(node, p) == find(node, q)) return false;
            node[q] = p;
        }
        return edges.length == n - 1;
    }
    
    public int find(int[] node, int x) {
        if (node[x] == x) return x;
        else {
            int val = find(node, node[x]);
            node[x] = val;
            return val;
        }
    }
}