
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
	final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int n;
	private static int min;
	static int fx;
	static int fy;
	static Queue<int[]> queue;
	static int[][] arr;
	
	public static void main (String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t= 1; t<= T; t++) {
			System.out.println("#" + t + " " + run());
		}
	}
	
	private static String run() throws IOException {
		n = Integer.parseInt(br.readLine());
		min = -1; // 도착 불가인 경우 -1 출력
		queue = new LinkedList<>(); // 큐 초기화
		StringTokenizer st;
		arr = new int[n][n];
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		fx = Integer.parseInt(st.nextToken());
		fy = Integer.parseInt(st.nextToken());
		
		queue.add(new int[]{x,y,0});
		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			int xx = item[0];
			int yy = item[1];
			int tt = item[2];
			
			// 도착함
			if (xx == fx && yy == fy) {
				min=tt;
				break;
			}
			
			// 상하좌우로 움직일 때 벽이 없다면 시간을 더하고 한칸 이동
			int[] dx = new int[] {-1,1,0,0};
			int[] dy = new int[] {0,0,-1,1};
			for (int i=0;i<4;i++) {
				if (bound(xx+dx[i],yy+dy[i])) {
					//소용돌이가 열리지 않았으면 한턴 기다림. 시간을 더하고 다시 큐에 추가함
					if (arr[xx+dx[i]][yy+dy[i]] == 2 && tt % 3 != 2) {
						queue.add(new int[] {xx,yy,tt+1});
						continue;
					} else {
						arr[xx][yy] = 1;
						queue.add(new int[] {xx+dx[i],yy+dy[i],tt+1});
					}
				}
			}
		}
		return String.valueOf(min);
	}
	
	// 테두리나 벽에 막혔는지 판단
	private static boolean bound(int x,int y) {
		return (!(x<0||x>=n||y<0||y>=n)&&arr[x][y]!=1);
	}
}