package part3;

import java.io.*;
import java.util.*;

public class 단지번호붙이기_2667번 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        visited = new boolean[N][N];
        sum = 1;
        for(int x=0;x<N;x++) {
            for(int y=0;y<N;y++) {
                if(map[x][y]==1 && !visited[x][y]) {
                    dfs(x,y);
                    queue.add(sum);
                    sum = 1;
                }
            }
        }

        bw.write(queue.size()+"\n");
        while (!queue.isEmpty()) {
            bw.write(queue.poll()+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0;i<4;i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && map[nx][ny]==1) {
                sum++;
                dfs(nx,ny);
            }
        }
    }
}
