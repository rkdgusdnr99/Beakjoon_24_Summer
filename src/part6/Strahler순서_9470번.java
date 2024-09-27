package part6;

import java.io.*;
import java.util.*;

class River {
    private int prevCount;
    private int strahler;
    private int strahlerCount; // 동일한 Strahler의 개수
    private List<River> next;

    River() {
        this.prevCount = 0;
        this.strahler = 0;
        this.strahlerCount = 0;
        this.next = new ArrayList<>();
    }

    int getPrevCount() {
        return prevCount;
    }

    int getStrahler() {
        return strahler;
    }

    List<River> getNext() {
        return next;
    }

    // 다음 노드를 저장하며, 다음 노드의 이전 노드 개수를 1 더해줌
    void addNext(River r) {
        next.add(r);
        r.prevCount += 1;
    }

    void subPrevCount() {
        prevCount--;
    }

    // 올바른 strahler 값과 반복 횟수를 저장하기 위한 메서드
    void updateStrahler(int newStrahler) {
        if (this.strahler < newStrahler) {
            this.strahler = newStrahler;
            this.strahlerCount = 1;
        } else if (this.strahler == newStrahler) {
            this.strahlerCount++;
        }
    }

    // 최종적으로 해당 노드의 strahler값을 정해주기 위한 메서드
    void finalizeStrahler() {
        if (this.strahlerCount > 1) {
            this.strahler++;
        }
    }

}

public class Strahler순서_9470번 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int[][] arr = new int[T][2];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            List<River> riverList = new ArrayList<>();
            for (int j = 0; j <= M; j++) {
                riverList.add(new River());
            }

            for (int j = 0; j < P; j++) { // 각 노드의 정보 저장
                st = new StringTokenizer(br.readLine());
                int prev = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                riverList.get(prev).addNext(riverList.get(next));
            }

            arr[i][0] = K;
            arr[i][1] = findMax(M, riverList);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }

    static int findMax(int M, List<River> riverList) {
        Queue<River> queue = new LinkedList<>();

        // 시작 노드들을 큐에 넣어줌
        for (int j = 1; j <= M; j++) {
            River river = riverList.get(j);
            if (river.getPrevCount() == 0) {
                river.updateStrahler(1);
                queue.add(river);
            }
        }

        // 다음 노드를 queue에 저장된 순서로 탐색
        while (!queue.isEmpty()) {
            River river = queue.poll();
            for (River next : river.getNext()) {
                next.subPrevCount(); // 다음 노드의 이전 노드 하나(현재 노드)를 탐색했음
                next.updateStrahler(river.getStrahler()); // 다음 노드의 Strahler 값을 업데이트
                if (next.getPrevCount() == 0) { // 다음 노드의 이전 노드를 모두 탐색했다는 뜻
                    next.finalizeStrahler(); // 최종적으로 다음 노드의 Strahler 값을 업데이트
                    queue.add(next);
                }
            }
        }

        return riverList.get(M).getStrahler();
    }
}
