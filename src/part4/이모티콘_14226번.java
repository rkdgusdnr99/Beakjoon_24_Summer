package part4;

import java.util.*;

class Imo {
    int count;
    int clipboard;
    int time;
    public Imo(int count, int clipboard, int time){
        this.count = count;
        this.clipboard = clipboard;
        this.time = time;
    }
}

public class 이모티콘_14226번 {
    static int S;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();
        visited = new boolean[S*2][S*2];

        System.out.println(bfs());

    }

    static int bfs() {
        Queue<Imo> pq = new LinkedList<>();
        pq.add(new Imo(1, 0, 0));
        visited[1][0] = true;

        while (!pq.isEmpty()) {
            Imo imo = pq.poll();
            int count = imo.count;
            int clipboard = imo.clipboard;
            int time = imo.time;
            if (count == S) {
                return time;
            }
            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (clipboard > 0 && count + clipboard < S*2 && !visited[clipboard+count][clipboard]) {
                visited[count + clipboard][clipboard] = true;
                pq.add(new Imo(count + clipboard, clipboard, time + 1));
            }
            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if (count > 0 && count < S*2 && !visited[count][count]) {
                visited[count][count] = true;
                pq.add(new Imo(count, count, time + 1));
            }
            // 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (count > 0 && !visited[count - 1][clipboard]) {
                visited[count - 1][clipboard] = true;
                pq.add(new Imo(count - 1, clipboard, time + 1));
            }
        }

        return -1;
    }
}
