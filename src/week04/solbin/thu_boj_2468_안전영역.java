import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		int min = 100;
		int max = 0;
		
		// 입력값을 받을 때 최솟값과 최댓값을 미리 체크한다.
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				int input = Integer.parseInt(st.nextToken());
				min = input<min?input:min;
				max = input>max?input:max;
				arr[i][j] = input;
			}
		}
		
		
		// 물이 아예 차지 않는 경우에도 하나의 구역으로 치므로 min-1부터 시작한다.
		int dist = 0;
		for (int i=min-1;i<max;i++) {
			int cnt = 0;
			boolean[][] visited = new boolean[n][n];
			for (int j=0;j<n;j++) {
				for (int k=0;k<n;k++) {
					// dfs로 구역의 갯수를 센다.
					if (arr[j][k]>i&&!visited[j][k]) {
						dfs(j,k,visited,i);
						cnt++;
					}
				}
			}
			dist = Math.max(dist, cnt);
		}
		sb.append(dist);
		System.out.println(sb);
	}
	
	static void dfs(int x,int y,boolean[][] visited,int h) {
		visited[x][y] = true;
		for (int i=0;i<4;i++) {
			if (bound(x+dx[i],y+dy[i],visited,h)) dfs(x+dx[i],y+dy[i],visited,h);
		}
	}
	
	static boolean bound(int x, int y, boolean[][] visited, int h) {
		if (x<0||x>=n||y<0||y>=n||visited[x][y]||arr[x][y]<=h) {
			return false;
		} else {
			return true;
		}
	}
}
