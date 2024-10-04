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

    // 두 친구 모두 earlyAdaptor가 아닌 경우에만 한 친구를 earlyAdaptor로 지정
    public boolean becomeEarlyAdopter(Friend friend) {
        if (!friend.isEarlyAdaptor() && !this.isEarlyAdaptor()) {
            friend.setEarlyAdaptor();
            return true;
        }
        return false;
    }

    public Friend removeLastNode() {
        for(Friend friend : this.getFriendList()) {
            if (!friend.isVisited()) {
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
            friend.setVisited();
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
