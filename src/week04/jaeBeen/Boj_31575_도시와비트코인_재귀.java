

import java.util.Scanner;

public class Boj_31575_도시와비트코인_재귀 {
	// 동쪽, 남쪽으로만 이동하기 때문에 이동하는 조합은 2가지 뿐
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	// 지도 정보
	static int[][] map;
	// 방문 여부
	static boolean[][] visited;
	// 가로길이
	static int n;
	// 세로길이
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 20~28에서 입력받은 값으로 초기화 진행
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[m][n];
		visited = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 깊이 우선 탐색!
		dfs(0,0);
		
		// 목적지 방문처리 되어있니?
		System.out.println(visited[m-1][n-1] ? "Yes" : "No");
	}
	
	public static void dfs(int x, int y) {
		// 입력받은 좌표 방문처리
		visited[x][y] = true;
		// 방문처리된 좌표에서 움직일 수 있는 방향 2가지(남, 동)
		for(int i=0; i<2; i++) {
			// x+=dx[i] 이런식으로 했다가 한세월 걸림
			// 아직 이 함수가 끝난 상태가 아니라서 입력받은 좌표에서 남,동쪽을 나타내는 좌표값을 각각 만들어서 검사해줘야 한다
			// 무튼 새롭게 변수 만들어서 초기화해주고
			int xx = x+dx[i];
			int yy = y+dy[i];
			// 범위는 안벗어 나는지, 건물이 있어서 못가는건 아닌지, 이미 방문한 곳인지 검사해서 다시 dfs를 호출한다.
			if(bound(xx,yy) && map[xx][yy] != 0 && !visited[xx][yy]) {
				dfs(xx,yy);
			}
		}
	}
	// 솔빈이 뇌 복사, 지도에서 좌표값 넣어주고 범위를 벗어나는지 검사한 결과 return
	public static boolean bound(int x, int y) {
		if(x<0 || y<0 || x>=m || y>=n) {
			return false;
		}
		return true;
	}
}
