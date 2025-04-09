import java.io.*;
import java.util.*;

//참고..
public class Main {
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0; // node 가 얼리 어답터 아님
        dp[node][1] = 1; // node 가 얼리 어답터임

        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child);
                dp[node][0] += dp[child][1]; // 내가 얼리 어답터 아니면, 자식은 무조건 얼리 어답터
                dp[node][1] += Math.min(dp[child][0], dp[child][1]); // 내가 얼리 어답터면 자식은 자유
            }
        }
    }
}
