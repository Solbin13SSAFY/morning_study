import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Boj_31575_도시와비트코인_스택 {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	static Stack<int[]> s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		n = sc.nextInt();
		m = sc.nextInt();
		
		
		map = new int[m][n];
		visited = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		s = new Stack<int[]>();
		
		// 시작점 북서쪽 코너 방문처리하고 스택에 추가
		visited[0][0] = true;
		int[] start = {0,0};
		s.push(start);
		// 스택 빌 때 까지
		while(!s.isEmpty()) {
			int[] now = s.pop();
			int x = now[0];
			int y = now[1];
			// 동쪽, 남쪽 2가지 경우에 대해
			for(int i=0; i<2; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				// 테두리, 갈 수 있는 지역, 방문했었는지
				if(bound(xx,yy) && map[xx][yy] != 0 && !visited[xx][yy]) {
					visited[xx][yy] = true;
					s.push(new int[] {xx, yy});
					if(xx == m-1 && yy == n-1) {
						break;
					}
				}
			}
		}
		System.out.println(visited[m-1][n-1] ? "Yes" : "No");
	}
	static boolean bound(int x, int y) {
		return x>=0&&x<m&&y>=0&&y<n;
	}
}
