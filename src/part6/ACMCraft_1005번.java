package part6;

import java.io.*;
import java.util.*;

class Building {
    private int buildingId;
    private int buildTime;
    private List<Building> nextBuildings;
    private int totalTime;
    private int prevCount;

    Building(int buildingId, int buildTime) {
        this.buildingId = buildingId;
        this.buildTime = buildTime;
        this.nextBuildings = new ArrayList<>();
        this.totalTime = buildTime;
        this.prevCount = 0;
    }

    int getBuildingId() {
        return buildingId;
    }

    List<Building> getNextBuildings() {
        return nextBuildings;
    }

    int getTotalTime() {
        return totalTime;
    }

    int getPrevCount() {
        return prevCount;
    }

    void addNextBuilding(Building nextBuilding) {
        this.nextBuildings.add(nextBuilding);
        nextBuilding.prevCount += 1;
    }

    void subPrevCount() {
        this.prevCount -= 1;
    }

    void updateTotalTime(Building prevBuilding) { // 건설 시간을 구하기 위해선, 이전 노드의 총 건설 시간중 가장 긴 경우를 택해야 함
        this.totalTime = Math.max(this.totalTime, this.buildTime + prevBuilding.totalTime);
    }
}

public class ACMCraft_1005번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Queue<Integer> answer = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 건물 수
            int K = Integer.parseInt(st.nextToken()); // 규칙 수

            List<Building> buildingList = new ArrayList<>();
            buildingList.add(new Building(0,0));
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) { // 각 빌딩 객체 생성
                buildingList.add(new Building(j, Integer.parseInt(st.nextToken())));
            }

            for (int j = 0; j < K; j++) { // 각 입력 처리
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                Building building = buildingList.get(X);
                Building nextBuilding = buildingList.get(Y);
                building.addNextBuilding(nextBuilding);
            }

            int W = Integer.parseInt(br.readLine());
            answer.add(totalBuildTime(W, buildingList));
        }

        while (!answer.isEmpty()) { // 정답 출력
            System.out.println(answer.poll());
        }
    }

    static int totalBuildTime(int W, List<Building> buildingList) { // W번째 빌딩의 건설 시간을 구함
        Queue<Building> queue = new LinkedList<>();
        for (Building building : buildingList) { // 처음 빌딩부터 시작
            if (building.getPrevCount() == 0) {
                queue.add(building);
            }
        }

        while (!queue.isEmpty()) {
            Building building = queue.poll();
            if (building.getBuildingId() == W) { // 건물 W의 건설 시간을 이미 알고 있음
                break;
            }

            for (Building nextBuilding : building.getNextBuildings()) { // 다음 빌딩의 건설 시간을 구하기 위한 과정
                nextBuilding.subPrevCount();
                nextBuilding.updateTotalTime(building);
                if (nextBuilding.getPrevCount() == 0) {
                    queue.add(nextBuilding);
                }
            }
        }

        return buildingList.get(W).getTotalTime();
    }
}
