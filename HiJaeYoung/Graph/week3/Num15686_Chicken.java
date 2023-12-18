package HiJaeYoung.Graph.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num15686_Chicken {
    static boolean[] checkStore;
    static int homeSize;
    static int[][] distanceMap;
    static int answer;
    private static class Node{
        int h;
        int w;
        Node(int h, int w){
            this.h = h;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Node> homes = new ArrayList<>();
        List<Node> chicken = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                int nowValue = Integer.parseInt(st.nextToken());
                if(nowValue==1){
                    homes.add(new Node(i,j));
                }else if(nowValue==2){
                    chicken.add(new Node(i,j));
                }
            }
        }
        distanceMap = new int[homes.size()][chicken.size()];
        checkStore = new boolean[chicken.size()];
        homeSize = homes.size();
        answer =Integer.MAX_VALUE;
        calculateDistance(homes,chicken,distanceMap);
        //System.out.println(Arrays.deepToString(distanceMap));
        chooseChickenStore(chicken.size(),m,0,0);
        System.out.println(answer);
    }
    public static int calculate(Node o1, Node o2){
        int h = o1.h-o2.h;
        if(h<0){
            h*=-1;
        }
        int w= o1.w-o2.w;
        if(w<0){
            w*=-1;
        }
        return w+h;
    }
    public static void calculateDistance(List<Node> homes, List<Node> chickens, int[][] disMap){
        int i = 0;
        for(Node nowHome : homes){
            int j =0;
            for(Node nowChicken : chickens){
                disMap[i][j] = calculate(nowHome,nowChicken);
                j++;
            }
            i++;
        }
    }
    public static void chooseChickenStore(int n,int m, int s, int depth){
        if(depth == m){
            answer = Math.min(answer,calculateAnswer());
            return;
        }
        for(int i=s;i<n;i++){
            checkStore[i] = true;
            chooseChickenStore(n,m,i+1,depth+1);
            checkStore[i] = false;
        }
    }
    public static int calculateAnswer(){
        int[] dis = new int[homeSize];
        Arrays.fill(dis,Integer.MAX_VALUE);
        for(int i =0;i<checkStore.length;i++){
            if(checkStore[i]){
                for(int j=0;j<homeSize;j++){
                    dis[j] = Math.min(dis[j],distanceMap[j][i]);
                }
            }
        }
        int answer =0;
        for(int now:dis){
            answer+=now;
        }
        return answer;
    }
}
