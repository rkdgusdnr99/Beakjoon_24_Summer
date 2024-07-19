package part4;

import java.io.*;
import java.util.*;

public class BFS와DFS_1260번 {
    static int N, M, V;
    static boolean[] visited;
    static List<PriorityQueue<Integer>> dfsEdges;
    static List<PriorityQueue<Integer>> bfsEdges;
    static StringBuilder dfsOutput;
    static StringBuilder bfsOutput;
    static int sum = 1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        dfsEdges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            dfsEdges.add(new PriorityQueue<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dfsEdges.get(u).add(v);
            dfsEdges.get(v).add(u);
        }

        bfsEdges = new ArrayList<>();
        for (Queue<Integer> dfsQueue : dfsEdges) {
            PriorityQueue<Integer> bfsQueue = new PriorityQueue<>(dfsQueue);
            bfsEdges.add(bfsQueue);
        }

        visited = new boolean[N+1];
        dfsOutput = new StringBuilder();
        dfs(V);
        System.out.println(dfsOutput.toString());

        bfsOutput = new StringBuilder();
        bfsOutput.append(V + " ");
        sum = 1;
        visited = new boolean[N+1];
        visited[V] = true;
        bfs();
        System.out.println(bfsOutput.toString());

    }

    static void dfs(int start) {
        visited[start] = true;
        dfsOutput.append(start + " ");
        if (sum == N) {
            return;
        }
        while (!dfsEdges.get(start).isEmpty()) {
            int next = dfsEdges.get(start).poll();
            if (!visited[next]) {
                sum++;
                dfs(next);
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        while (!queue.isEmpty()) {
            if (sum == N) {
                return;
            }
            int start = queue.poll();
            while (!bfsEdges.get(start).isEmpty()) {
                int next = bfsEdges.get(start).poll();
                if (!visited[next]) {
                    visited[next] = true;
                    sum++;
                    queue.add(next);
                    bfsOutput.append(next + " ");
                }
            }
        }
    }
}
