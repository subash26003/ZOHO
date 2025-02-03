import java.util.PriorityQueue;

public class Queues {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        q.add(10);
        q.add(1);
        q.add(11);
        q.add(2);
        q.add(4);
        while (!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
