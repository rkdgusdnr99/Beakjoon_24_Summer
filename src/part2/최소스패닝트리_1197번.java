package part2;

import java.util.*;

class Prim implements Comparable<Prim> {
    int end;
    int len;

    public Prim(int end, int len) {
        this.end = end;
        this.len = len;
    }

    @Override
    public int compareTo(Prim other) {
        return Integer.compare(this.len, other.len);
    }
}


public class 최소스패닝트리_1197번 {
    static int V, E;
    static List<PriorityQueue<Prim>> routes;
    static boolean[] visited;
    static int totalCost = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        routes = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            routes.add(new PriorityQueue<>());
        }

        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            routes.get(A).add(new Prim(B, C));
            routes.get(B).add(new Prim(A, C));
        }

        visited = new boolean[V + 1];
        minimumSpanningTree(1);

        System.out.println(totalCost);

    }

    static void minimumSpanningTree(int start) {
        PriorityQueue<Prim> pq = new PriorityQueue<>();
        pq.add(new Prim(start, 0));

        while (!pq.isEmpty()) {
            Prim now = pq.poll();

            if (visited[now.end]) continue;
            visited[now.end] = true;
            totalCost += now.len;

            for (Prim next : routes.get(now.end)) {
                if (!visited[next.end]) {
                    pq.add(next);
                }
            }
        }
    }
}
