package week04.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class tue_boj_31575_도시와비트코인 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Queue<int[]> queue = new LinkedList<>();
	static int n;
	static int m;
	static boolean[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new boolean[n][m];
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken())==1?true:false;
			}
		}
		boolean isArrived = false;
		queue.add(new int[] {0,0});
		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			int x = item[0];
			int y = item[1];
			// 도착했는지 체크
			if (x==n-1&&y==m-1) {
				isArrived = true;
				break;
			}
			// 동쪽과 남쪽으로만 움직인다.
			if (bound(x+1,y)) {
				queue.add(new int[] {x+1,y});
				arr[x+1][y] = false;
			}
			if (bound(x,y+1)) {
				queue.add(new int[] {x,y+1});
				arr[x][y+1] = false;
			}
		}
		if (isArrived) {
			sb.append("Yes");
		} else {
			sb.append("No");
		}
		
		System.out.println(sb);
	}
	
	static boolean bound(int x,int y) {
		if (x<0||x>=n||y<0||y>=m||!arr[x][y]) {
			return false;
		} else {
			return true;
		}
	}
}