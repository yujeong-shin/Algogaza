import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q12865_평범한_배낭 {
    static class Item{
        int weight;
        int value;
        public Item(int weight, int value){
            this.value = value;
            this.weight = weight;
        }
    }
    static List<Item> items = new ArrayList<>();
    static int result = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            items.add(new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        visited = new boolean[N];
        bag(K, new ArrayList<>(), 0);
        System.out.println(result);
    }
    private static void bag(int maxWeight, List<Item> temp, int preWeight){
        if(maxWeight > preWeight) {
            System.out.println(temp);
            return;
        }
        for(int i=0; i<items.size(); i++){
            if(!visited[i]){
                int curWeight = preWeight + items.get(i).weight;
                if(curWeight < maxWeight){
                    visited[i] = true;
                    temp.add(items.get(i));
                    bag(maxWeight, temp, preWeight + items.get(i).weight);
                    visited[i] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
