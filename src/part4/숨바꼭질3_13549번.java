package part4;

import java.util.*;

class Node implements Comparable<Node>{
    int x;
    int time;
    public Node(int x, int time){
        this.x = x;
        this.time = time;
    }
    public int compareTo(Node node){
        return Integer.compare(this.time, node.time);
    }
}

public class 숨바꼭질3_13549번 {
    static int N, K;
    static boolean[] visited;
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        size = Math.min(Math.max(N,K)*2+1, 100001);

        visited = new boolean[size];

        System.out.println(bfs());
    }

    static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.x] = true;
            if (node.x == K) {
                return node.time;
            }
            if (node.x * 2 < size && !visited[node.x*2]) {
                pq.add(new Node(node.x*2, node.time));
            }
            if (node.x + 1 < size && !visited[node.x+1]) {
                pq.add(new Node(node.x+1, node.time+1));
            }
            if (node.x - 1 >= 0 && !visited[node.x-1]) {
                pq.add(new Node(node.x-1, node.time+1));
            }
        }
        return -1;
    }

}
