package part6;

import java.io.*;
import java.util.*;

class Friend {
    private boolean visited;
    private boolean earlyAdaptor;
    private int friendsNumber;
    private List<Friend> friendList;

    public Friend() {
        visited = false;
        earlyAdaptor = false;
        friendsNumber = 0;
        friendList = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    private boolean isEarlyAdaptor() {
        return earlyAdaptor;
    }

    public void setVisited() {
        visited = true;
    }

    private void setEarlyAdaptor() {
        earlyAdaptor = true;
    }

    public boolean isLastNode() {
        return friendsNumber == 1;
    }

    private List<Friend> getFriendList() {
        return friendList;
    }

    public void addFriend(Friend friend) {
        friendList.add(friend);
        friendsNumber++;
        friend.friendList.add(this);
        friend.friendsNumber++;
    }

    // 마지막 노드의 친구가 얼리어답터가 될 수 있는지 판정해서 될 수 있다면 true, 없다면 false 반환
    public boolean becomeEarlyAdopter(Friend friend) {
        if (!friend.isEarlyAdaptor() && !this.isEarlyAdaptor()) { // 둘다 얼리어답터가 아니라면 하나는 무조건 얼리아답터
            friend.setEarlyAdaptor();
            return true;
        }
        return false;
    }

    public Friend removeLastNode() {
        for(Friend friend : this.getFriendList()) { // 자신과 연결된 노드들 순회
            if (!friend.isVisited()) { // 만일 이미 처리된 노드라면 다시 처리해줄 필요 없음
                friendsNumber--;
                friend.friendsNumber--;
                return friend;
            }
        }
        return null;
    }
}

public class 사회망서비스_2533번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Friend> friendList = new ArrayList<>();
        friendList.add(new Friend());
        for (int i = 1; i <= N; i++) {
            friendList.add(new Friend());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            friendList.get(u).addFriend(friendList.get(v));
        }
        System.out.println(earlyAdapterCount(friendList));
    }

    static int earlyAdapterCount(List<Friend> friendList) {
        int count = 0;
        Queue<Friend> queue = new LinkedList<>();

        for (Friend friend : friendList) {
            if (friend.isLastNode()) {
                queue.add(friend);
            }
        }

        while (!queue.isEmpty()) {
            Friend friend = queue.poll();
            friend.setVisited(); // 다시 방문하지 않도록 표시
            Friend nextNode = friend.removeLastNode();
            if (nextNode == null) {
                break;
            }
            if (friend.becomeEarlyAdopter(nextNode)) {
                count++;
            }
            if (nextNode.isLastNode()) {
                queue.add(nextNode);
            }
        }

        return count;
    }

}
