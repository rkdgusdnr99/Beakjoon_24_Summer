package wrong;

import java.util.*;

class PrimCount implements Comparable<PrimCount> {
    int end;
    int len;
    int count;

    public PrimCount(int end, int len, int count) {
        this.end = end;
        this.len = len;
        this.count = count;
    }

    public void addPrime (PrimCount other) {
        other.count += 1;
    }

    @Override
    public int compareTo(PrimCount other) {
        return Integer.compare(this.len, other.len);
    }
}


public class 최소스패닝트리_1197번_메모리초과 {
    static int V, E;
    static List<PriorityQueue<PrimCount>> routes;
    static int min = Integer.MAX_VALUE;

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
            routes.get(A).add(new PrimCount(B, C, 0));
        }

        minimumSpanningTree();

        System.out.println(min);

    }

    static void minimumSpanningTree() {
        for (int i = 1; i <= V; i++) {
            boolean[] visited = new boolean[V+1];
            PriorityQueue<PrimCount> pq = new PriorityQueue<>();
            pq.add(new PrimCount(i, 0, 0));
            while (!pq.isEmpty()) {
                PrimCount now = pq.poll();
                if (now.count == V-1) {
                    min = Math.min(min, now.len);
                    break;
                }
                visited[now.end] = true;
                for (PrimCount next : routes.get(now.end)) {
                    if (!visited[next.end]) {
                        pq.add(new PrimCount(next.end, now.len + next.len, now.count+1));
                    }
                }
            }
        }
    }
}
