import java.util.*;

class beak3584 {
    static int T,N,A,B,n1,n2;
    static int parent[];

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt(); //testCase
        sc.nextLine();
        StringBuilder sb = new StringBuilder();

        while(T-->0)
        {
            N = sc.nextInt(); // #ofNode 2...1000
            parent = new int[N + 1];

            for(int i=0; i<N-1; i++)
            {
                A = sc.nextInt();
                B = sc.nextInt();
//                sb.append(A).append(" ").append(B).append('\n');
                parent[B] = A;
            }

            n1 = sc.nextInt();
            n2 = sc.nextInt();

//            System.out.println(Arrays.toString(parent));
//            System.out.println(n1 + " " + n2);

            Set<Integer>s1 = new HashSet<>();
            while(n1 != 0)
            {
                s1.add(n1);
                n1 = parent[n1];
            }
//            System.out.println(s1);
//            System.out.println(n1 + " " + n2);

            while(n2 != 0)
            {
                if(s1.contains(n2))
                {
                    sb.append(n2).append('\n');
                    break;
                }
                n2 = parent[n2];
            }
        }
        System.out.println(sb);
    }
}
