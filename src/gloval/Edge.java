package gloval;

public class Edge implements Comparable<Edge> {
    public int e;
    public int fee;

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