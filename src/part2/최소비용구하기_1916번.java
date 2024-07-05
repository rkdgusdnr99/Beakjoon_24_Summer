package part2;

import java.util.*;

// Edge 클래스: e와 fee 쌍을 저장하는 클래스
class Edge implements Comparable<Edge> {
    int e;
    int fee;

    public Edge(int e, int fee) {
        this.e = e;
        this.fee = fee;
    }

    // fee 값을 기준으로 오름차순 정렬
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.fee, other.fee);
    }
}

public class 최소비용구하기_1916번 {
    static int N, M;
    static List<PriorityQueue<Edge>> routes;
    static int start, end;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 노드 수
        M = sc.nextInt(); // 간선 수

        // routes 리스트 초기화
        routes = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            routes.add(new PriorityQueue<>()); // 기본 설정으로 최소 힙
        }

        // 입력 받아서 routes에 저장
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int fee = sc.nextInt();
            routes.get(s).add(new Edge(e, fee));
        }

        start = sc.nextInt();
        end = sc.nextInt();
        visited = new boolean[N+1];
        visited[start] = true;

        int min = minimumFee();
        System.out.println(min);
    }

    static int minimumFee() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.e == end) {
                return now.fee;
            }
            visited[now.e] = true;
            for (Edge next : routes.get(now.e)) {
                if (!visited[next.e]) {
                    pq.add(new Edge(next.e, now.fee + next.fee));
                }
            }
        }
        return -1;
    }
}