package boj_4485_녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}
			sb.append("Problem ").append(tc++).append(": ");
			
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != 0 || j != 0) {
						dist[i][j] = INF;
					}
				}
			}
			min = Integer.MAX_VALUE;
			dijkstra(0,0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra(int x, int y) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
			
		});
		pq.add(new int[] {x, y, map[y][x]});
		
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int xx = info[0];
			int yy = info[1];
			if(xx == N-1 && yy == N-1) {
				min = Math.min(min, info[2]);
				continue;
			}
			for(int i =0; i<4; i++) {
				int xxx = xx + dx[i];
				int yyy = yy + dy[i];
				
				if(bound(xxx, yyy) && dist[yyy][xxx] > dist[yy][xx] + map[yy][xx]) {
					dist[yyy][xxx] = dist[yy][xx] + map[yy][xx];
					pq.add(new int[] {xxx, yyy, info[2] + map[yyy][xxx]});
				}
			}
		}
		
	}
	static boolean bound(int x, int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
}
