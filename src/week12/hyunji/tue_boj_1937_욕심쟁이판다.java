import java.util.Scanner;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] dp;
    static int[][] map;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];
        dp = new int[n][n];

        for(int y=0; y<n; y++) {
            for(int x=0; x<n; x++) {
                map[y][x] = sc.nextInt();
            }
        } //입력받기

        int maxDist = Integer.MIN_VALUE;
        for(int y=0; y<n; y++) {
            for(int x=0; x<n; x++) {

                int dist = dfs(y, x); //map[y][x]에서 출발해서 이동할 수 있는 최대 거리 
                maxDist = Math.max(maxDist, dist);
            }
        }

        System.out.println(maxDist);
    }

    static int dfs(int y, int x) {
        //종료
        if(dp[y][x] != 0) { //계산한 적 있으면 종료(중복X) 
            return dp[y][x];
        }

        dp[y][x] = 1;

        //재귀
        for(int d=0; d<4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(isValid(ny, nx) && map[ny][nx]>map[y][x]) {
                dp[y][x] = Math.max(dp[y][x], dfs(ny, nx)+1);
            }
        }

        return dp[y][x];
    }

    static boolean isValid(int y, int x) {
        if(y>=0 && y<n && x>=0 && x<n) return true;
        return false;
    }
}