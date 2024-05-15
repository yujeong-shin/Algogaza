import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14891_톱니바퀴 {
    public static class Wheel{
        List<Character> wheelList = new ArrayList<>();
        char leftStatus;
        char rightStatus;
        public Wheel(List<Character> list){
            this.wheelList = list;
            setLeftStatus(this.wheelList.get(6));
            setRightStatue(this.wheelList.get(2));
        }
        public void rotation(int status){
            // 시계 방향
            if(status == 1) {
                this.wheelList.add(0, this.wheelList.get(this.wheelList.size()-1));
                this.wheelList.remove(this.wheelList.size()-1);
            } else if(status == -1){
                this.wheelList.add(this.wheelList.get(0));
                this.wheelList.remove(0);
            }
            this.setRightStatue(this.wheelList.get(2));
            this.setLeftStatus(this.wheelList.get(6));
        }
        public void setLeftStatus(char leftStatus) {
            this.leftStatus = leftStatus;
        }
        public void setRightStatue(char rightStatus) {
            this.rightStatus = rightStatus;
        }
    }
    public static class Order {
        int index;
        int direction;

        public Order(int index, int direction) {
            this.index = index;
            this.direction = direction;
        }
    }
    static List<Wheel> wheels = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<4; i++){
            String str = br.readLine();
            List<Character> list = new ArrayList<>();
            for(int j=0; j<8; j++) {
                list.add(str.charAt(j));
            }
            wheels.add(new Wheel(list));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            rotationWheel(index-1, direction);
        }
        int result = getValueOfTop();
        System.out.println(result);
    }

    private static int getValueOfTop() {
        int sum = 0;
        for(int i=0; i<4; i++){
            char c = wheels.get(i).wheelList.get(0);
            if(c == '1'){
                sum += (int) Math.pow(2,i);
            }
        }
        return sum;
    }

    public static void rotationWheel(int index, int direction){
        Queue<Order> temp = new LinkedList<>();
        Queue<Order> queue = new LinkedList<>();
        boolean[] visited = new boolean[4];
        queue.offer(new Order(index, direction));

        while(!queue.isEmpty()){
            Order order = queue.poll();
            if(order.index == 0 && wheels.get(order.index).rightStatus != wheels.get(order.index+1).leftStatus && !visited[order.index+1]) {
                queue.offer(new Order(order.index+1, order.direction*-1));
            }
            if(order.index == 3 && wheels.get(order.index).leftStatus != wheels.get(order.index-1).rightStatus && !visited[order.index-1]) {
                queue.offer(new Order(order.index-1, order.direction*-1));
            }
            if(order.index > 0 && order.index < 3){
                if (wheels.get(order.index).leftStatus != wheels.get(order.index-1).rightStatus && !visited[order.index-1]){
                    queue.offer(new Order(order.index-1, order.direction*-1));
                }
                if(wheels.get(order.index).rightStatus != wheels.get(order.index+1).leftStatus && !visited[order.index+1]) {
                    queue.offer(new Order(order.index+1, order.direction*-1));
                }
            }
            visited[order.index] = true;
            temp.offer(order);
        }
        while(!temp.isEmpty()){
            Order order = temp.poll();
            wheels.get(order.index).rotation(order.direction);
        }
    }
}
