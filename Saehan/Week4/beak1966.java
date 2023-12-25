import java.util.*;

public class beak1966
{
    public static void main(String[] args)
    {
        class Node
        {
            int idx, lv;

            Node(int idx, int lv)
            {
                this.idx = idx;
                this.lv = lv;
            }
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        while(T-- > 0)
        {
            int size = sc.nextInt();
            int target = sc.nextInt();
            sc.nextLine();
            String[] input = sc.nextLine().split(" ");

            Queue<Node> pq = new PriorityQueue<>((o1, o2) -> -(o1.lv - o2.lv));
            Queue<Node> queue = new LinkedList<>();

            for(int i = 0; i < size; i++)
            {
                int value = Integer.parseInt(input[i]);
                pq.add(new Node(i, value));
                queue.add(new Node(i, value));
            }

            int acc = 0;
            while(true)
            {
                if(queue.peek().lv == pq.peek().lv)
                {
                    if(queue.peek().idx == target)
                        break;
                    else
                    {
                        acc++;
                        queue.poll();
                        pq.poll();
                    }
                }
                else
                    queue.add(queue.poll());
            }
            sb.append((acc + 1) + "\n");
        }
        System.out.print(sb);
    }
}
