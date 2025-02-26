 import java.util.Scanner;

public class thu_boj_1952_달팽이2 {
    static int[] dy = {0, 1, 0, -1}; //우 하 좌 상
    static int[] dx = {1, 0, -1, 0};
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        boolean[][] visited = new boolean[m][n];
        for(int y=0; y<m; y++) {
            for(int x=0; x<n; x++) {
                visited[y][x] = false;
            }
        } //visited: false로 초기화

        visited[0][0] = true;
        int visitedCnt = 1;

        int curY = 0;
        int curX = 0;

        int dir = 0;

        int changeCnt = 0;

        while(true) {
            // if(visitedCnt == m*n) break;

            int ny = curY + dy[dir];
            int nx = curX + dx[dir];

            while(isValid(ny, nx) && visited[ny][nx] == false) {
                
                curY = ny;
                curX = nx;

                visited[curY][curX] = true;

                ny = curY + dy[dir];
                nx = curX + dx[dir];

                visitedCnt++;
            }

            dir = (dir+1) % 4;
            
            if(visitedCnt == m*n) break;

            changeCnt++;
        }

        System.out.println(changeCnt);
    }

    static boolean isValid(int y, int x) {
        if(y>=0 && y<m && x>=0 && x<n) return true;
        else return false;
    }
}